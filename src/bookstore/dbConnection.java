/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Minh Hieu
 */
public class dbConnection {
    public Connection getConnection(){
        Connection  conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost;databaseName=BOOKSTORE;user=hieu;password=123456";
            conn = DriverManager.getConnection(dbURL);
            if(conn != null){
                System.out.println("Connect Successful");
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return conn;
    }
}

