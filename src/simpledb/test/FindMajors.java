package simpledb.test;

import simpledb.jdbc.embedded.EmbeddedDriver;
import simpledb.plan.Plan;
import simpledb.plan.Planner;
import simpledb.query.Scan;
import simpledb.server.SimpleDB;
import simpledb.tx.Transaction;

import javax.xml.crypto.dsig.TransformService;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FindMajors {
    public static void main(String[] args) {
        try {
            // create input scanner
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a department name: ");
            String major = sc.next();
            sc.close();

            // create driver
            SimpleDB db = new SimpleDB("studentdb");

            // create connection
            Transaction tx = db.newTx();
            Planner planner = db.planner();

            System.out.println("Here are the " + major + " majors");
            System.out.println("Name\tGradYear");

            String qry = "select sname, gradyear "
                    + "from student, dept "
                    + "where did = majorid "
                    + "and dname = '" + major + "'";
            Plan p = planner.createQueryPlan(qry, tx);
            Scan s = p.open();
            while (s.next()) {
                String sname = s.getString("sname");
                int gradyear = s.getInt("gradyear");
                System.out.println(sname + "\t" + gradyear);
            }

            s.close();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
