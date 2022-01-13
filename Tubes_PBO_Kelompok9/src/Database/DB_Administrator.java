/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Class.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.ResultSet ;
import java.sql.Statement ;
import java.util.ArrayList ;

/**
 *
 * @author kamil
 */
public class DB_Administrator {
    private String username, password;

    //constructor
    public DB_Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    //Melakukan insert database administrator
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO administrator VALUES('"+username+"', '"+password+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan delete database administrator
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM administrator WHERE username='"+username+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database administrator
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE administrator SET password = '"+password+"' WHERE username = '"+username+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database administrator
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE administrator";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Administrator
    public ArrayList<Administrator> getData(){
        ArrayList<Administrator> list_administrator = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM administrator";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.username = rs.getString("username");
                this.password = rs.getString("password");
                
                list_administrator.add(new Administrator(username, password));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_administrator;
    }
    
    public static void main(String[] args) {
        DB_Administrator test = new DB_Administrator("admin1", "admin1");
        test.reset();
        System.out.println();
        System.out.println("berhasil");
    }

}
