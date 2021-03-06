package shivam.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * created by Shivam on 15-04-2019.
 */
public class Connect_to_DB {

    private static Connection conn=null;

    public static Connection connect(){

        try{
            // USING H2 DATABASE, since it is a EMBEDDED db.
            Class.forName("org.h2.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:h2:~/test", "shivam", "1234");
//            conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","1234");

            return conn;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void disconnect(){

        try{
            if (conn!=null){
                conn.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
