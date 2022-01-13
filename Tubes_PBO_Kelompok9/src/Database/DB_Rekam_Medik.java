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
public class DB_Rekam_Medik {
    private String kode_terapi,nama_terapi,deskripsi_terapi,kode_dokter, kode_pasien;

    //constructor
    public DB_Rekam_Medik(String kode_terapi, String nama_terapi, String deskripsi_terapi, String kode_dokter, String kode_pasien) {
        this.kode_terapi = kode_terapi;
        this.nama_terapi = nama_terapi;
        this.deskripsi_terapi = deskripsi_terapi;
        this.kode_dokter = kode_dokter;
        this.kode_pasien = kode_pasien;
    }
    
    //Melakukan insert database Rekam Medik
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO rekam_medik VALUES('"+kode_terapi+"', '"+nama_terapi+"', '"+deskripsi_terapi+"', '"+kode_dokter+"', '"+kode_pasien+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan delete database Rekam Medik
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM rekam_medik WHERE kode_terapi='"+kode_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database Rekam Medik
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE rekam_medik SET nama_terapi = '"+nama_terapi+"' WHERE kode_terapi = '"+kode_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Rekam Medik
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE rekam_medik";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Rekam Medik
    public ArrayList<Rekam_Medik> getData(){
        ArrayList<Rekam_Medik> list_rekam_medik = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM rekam_medik";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.kode_terapi = rs.getString("kode_terapi");
                this.nama_terapi = rs.getString("nama_terapi");
                this.deskripsi_terapi = rs.getString("deskripsi_terapi");
                this.kode_dokter = rs.getString("kode_dokter");
                this.kode_pasien = rs.getString("kode_pasien");
                
                list_rekam_medik.add(new Rekam_Medik(kode_terapi, nama_terapi, deskripsi_terapi, kode_dokter, kode_pasien));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_rekam_medik;
    }
    
    public static void main(String[] args) {
        DB_Rekam_Medik test = new DB_Rekam_Medik("TK01", "Diathermy", "tes tes", "SPA01", "PAS01");
        test.reset();
        System.out.println();
        System.out.println("berhasil");
    }
    
}
