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
public class DB_Terapi{
    private String jenis_terapi, jenis_penyakit, deskripsi_penyakit, kode_terapi;

    //constructor
    public DB_Terapi(String jenis_terapi, String jenis_penyakit, String deskripsi_penyakit, String kode_terapi) {
        this.jenis_terapi = jenis_terapi;
        this.jenis_penyakit = jenis_penyakit;
        this.deskripsi_penyakit = deskripsi_penyakit;
        this.kode_terapi = kode_terapi;
    }
    
    //Melakukan insert database Terapi
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO terapi VALUES('"+kode_terapi+"','"+jenis_terapi+"', '"+jenis_penyakit+"', '"+deskripsi_penyakit+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Melakukan delete database Terapi
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM terapi WHERE jenis_terapi='"+jenis_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database Terapi
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE terapi SET jenis_penyakit = '"+jenis_penyakit+"' WHERE jenis_terapi = '"+jenis_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Terapi 
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE terapi";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Terapi 
    public ArrayList<Terapi> getData(){
        ArrayList<Terapi> list_terapi = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM terapi";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.jenis_terapi = rs.getString("jenis_terapi");
                this.jenis_penyakit = rs.getString("jenis_penyakit");
                this.deskripsi_penyakit = rs.getString("deskripsi_penyakit");
                this.kode_terapi = rs.getString("kode_terapi");
                
                //list_terapi.add(new Terapi(jenis_terapi, jenis_penyakit, deskripsi_penyakit));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_terapi;
    }
    
    public static void main(String[] args) {
//            DB_Terapi test = new DB_Terapi("Kimia", "Umum", "Demam");
//        test.reset();
//        System.out.println();
//        System.out.println("berhasil");
    }
    
}
