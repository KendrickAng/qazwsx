package simpledb.test;

import java.sql.*;
import java.util.Scanner;

import simpledb.jdbc.ResultSetMetaDataAdapter;
import simpledb.jdbc.embedded.EmbeddedDriver;
import simpledb.jdbc.network.NetworkDriver;
import simpledb.plan.Plan;
import simpledb.plan.Planner;
import simpledb.query.Scan;
import simpledb.record.Schema;
import simpledb.server.SimpleDB;
import simpledb.tx.Transaction;

import static java.sql.Types.INTEGER;

public class SimpleIJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Connect> ");
//        String s = sc.nextLine();
//        Driver d = (s.contains("//")) ? new NetworkDriver() : new EmbeddedDriver();

        // create driver
        SimpleDB db = new SimpleDB("studentdb");

        // create connection
        Transaction tx = db.newTx();
        Planner planner = db.planner();
        try {
            System.out.print("\nSQL> ");
            while (sc.hasNextLine()) {
                // process one line of input
                String cmd = sc.nextLine().trim();
                if (cmd.startsWith("exit"))
                    break;
                else if (cmd.startsWith("select"))
                    doQuery(tx, planner, cmd);
                else
                    doUpdate(tx, planner, cmd);
                System.out.print("\nSQL> ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try (Connection conn = d.connect(s, null);
//             Statement stmt = conn.createStatement()) {
//            System.out.print("\nSQL> ");
//            while (sc.hasNextLine()) {
//                // process one line of input
//                String cmd = sc.nextLine().trim();
//                if (cmd.startsWith("exit"))
//                    break;
//                else if (cmd.startsWith("select"))
//                    doQuery(stmt, cmd);
//                else
//                    doUpdate(stmt, cmd);
//                System.out.print("\nSQL> ");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        sc.close();
    }

    private static void doQuery(Transaction tx, Planner planner, String cmd) {
        Plan p = planner.createQueryPlan(cmd, tx);
        Scan s = null;

        try {
            s = p.open();

            // create wrapper around schema
            Schema sch = p.schema();
            SimpleSchema ss = new SimpleSchema(sch);
            int numcols = ss.getColumnCount();
            int totalwidth = 0;

            // print header
            for (int i = 1; i <= numcols; i++) {
                String fldname = ss.getColumnName(i);
                int width = ss.getColumnDisplaySize(i);
                totalwidth += width;
                String fmt = "%" + width + "s";
                System.out.format(fmt, fldname);
            }
            System.out.println();
            for (int i = 0; i < totalwidth; i++)
                System.out.print("-");
            System.out.println();

            // print records
            while (s.next()) {
                for (int i = 1; i <= numcols; i++) {
                    String fldname = ss.getColumnName(i);
                    int fldtype = ss.getColumnType(i);
                    String fmt = "%" + ss.getColumnDisplaySize(i);
                    if (fldtype == Types.INTEGER) {
                        int ival = s.getInt(fldname);
                        System.out.format(fmt + "d", ival);
                    } else {
                        String sval = s.getString(fldname);
                        System.out.format(fmt + "s", sval);
                    }
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            assert s != null;
            s.close();
        }
    }

    private static void doUpdate(Transaction tx, Planner planner, String cmd) {
        try {
            int howmany = planner.executeUpdate(cmd, tx);
            System.out.println(howmany + " records processed");
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}

class SimpleSchema {
    private final Schema sch;

    /**
     * Creates a metadata object that wraps the specified schema.
     * @param sch the schema
     */
    public SimpleSchema(Schema sch) {
        this.sch = sch;
    }

    /**
     * Returns the size of the field list.
     */
    public int getColumnCount() {
        return sch.fields().size();
    }

    /**
     * Returns the field name for the specified column number.
     * In JDBC, column numbers start with 1, so the field
     * is taken from position (column-1) in the list.
     */
    public String getColumnName(int column) {
        return sch.fields().get(column - 1);
    }

    /**
     * Returns the type of the specified column.
     * The method first finds the name of the field in that column,
     * and then looks up its type in the schema.
     */
    public int getColumnType(int column) {
        String fldname = getColumnName(column);
        return sch.type(fldname);
    }

    /**
     * Returns the number of characters required to display the
     * specified column.
     * For a string-type field, the method simply looks up the
     * field's length in the schema and returns that.
     * For an int-type field, the method needs to decide how
     * large integers can be.
     * Here, the method arbitrarily chooses 6 characters,
     * which means that integers over 999,999 will
     * probably get displayed improperly.
     */
    public int getColumnDisplaySize(int column) throws SQLException {
        String fldname = getColumnName(column);
        int fldtype = sch.type(fldname);
        int fldlength = (fldtype == INTEGER) ? 6 : sch.length(fldname);
        return Math.max(fldname.length(), fldlength) + 1;
    }
}
