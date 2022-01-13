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
public class DB_Terapi_Kimia {
    private String kode_terapi, nama_terapi, deskripsi_terapi, kode_dokter;

    //constructor
    public DB_Terapi_Kimia(String kode_terapi, String nama_terapi, String deskripsi_terapi, String kode_dokter, String jenis_terapi, String jenis_penyakit, String deskripsi_penyakit) {
        this.kode_terapi = kode_terapi;
        this.nama_terapi = nama_terapi;
        this.deskripsi_terapi = deskripsi_terapi;
        this.kode_dokter = kode_dokter;
    }
    
    //Melakukan insert database Terapi Kimia
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO terapi_kimia VALUES('"+kode_terapi+"', '"+nama_terapi+"', '"+deskripsi_terapi+"', '"+kode_dokter+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan delete database Terapi Kimia
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM terapi_kimia WHERE kode_terapi='"+kode_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database Terapi Kimia
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE terapi_kimia SET nama_terapi = '"+nama_terapi+"' WHERE kode_terapi = '"+kode_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Terapi Kimia
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE terapi_kimia";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Terapi Kimia
    public ArrayList<Terapi_Kimia> getData(){
        ArrayList<Terapi_Kimia> list_terapi_kimia = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM terapi_kimia";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.kode_terapi = rs.getString("kode_terapi");
                this.nama_terapi = rs.getString("nama_terapi");
                this.deskripsi_terapi = rs.getString("deskripsi_terapi");
                this.kode_dokter = rs.getString("kode_dokter");
                
                list_terapi_kimia.add(new Terapi_Kimia(kode_terapi, nama_terapi, deskripsi_terapi, kode_dokter, jenis_terapi, deskripsi_penyakit, jenis_penyakit));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_terapi_kimia;
    }
    
    public static void main(String[] args) {
        DB_Terapi_Kimia test = new DB_Terapi_Kimia("TK01", "Diathermy", "tes tes", "SPA01");
        test.reset();
        System.out.println();
        System.out.println("berhasil");
    }
    
}
