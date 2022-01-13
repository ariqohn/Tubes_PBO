/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kamil
 */
public class DB_Dokter {
    private String kode_dokter,nama_dokter, email_dokter,spesialis;

    //constructor
    public DB_Dokter(String kode_dokter, String nama_dokter, String email_dokter, String spesialis) {
        this.kode_dokter = kode_dokter;
        this.nama_dokter = nama_dokter;
        this.email_dokter = email_dokter;
        this.spesialis = spesialis;
    }
    
    //Melakukan insert database dokter
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO dokter VALUES('"+kode_dokter+"', '"+nama_dokter+"', '"+email_dokter+"', '"+spesialis+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Melakukan delete database Dokter
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM dokter WHERE kode_dokter='"+kode_dokter+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database Dokter
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE dokter SET nama_dokter = '"+nama_dokter+"' WHERE kode_dokter = '"+kode_dokter+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Dokter
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE dokter";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Dokter
    public ArrayList<Dokter> getData(){
        ArrayList<Dokter> list_dokter = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM dokter";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.kode_dokter = rs.getString("kode_dokter");
                this.nama_dokter = rs.getString("nama_dokter");
                this.email_dokter = rs.getString("email_dokter");
                this.spesialis = rs.getString("spesialis");
                
                list_dokter.add(new Dokter(kode_dokter,nama_dokter, email_dokter,spesialis));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_dokter;
    }
    
    public static void main(String[] args) {
        DB_Dokter test = new DB_Dokter("DOK", "Kamil", "kamil@gmail.com", "umum");
        test.reset();
        System.out.println();
        System.out.println("berhasil");
    }
}
