package simpledb.test;

import simpledb.jdbc.embedded.EmbeddedDriver;
import simpledb.plan.Planner;
import simpledb.server.SimpleDB;
import simpledb.tx.Transaction;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeMajor {
    public static void main(String[] args) {
        try {
            // create driver
            SimpleDB db = new SimpleDB("studentdb");

            // connect
            Transaction tx = db.newTx();
            Planner planner = db.planner();

            // create statement
            String cmd = "update STUDENT "
                    + "set MajorId=30 "
                    + "where SName = 'amy'";
            planner.executeUpdate(cmd, tx);
            System.out.println("Amy is now a drama major.");

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
