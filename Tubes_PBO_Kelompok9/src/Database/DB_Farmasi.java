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
public class DB_Farmasi extends Farmasi{
    private String kode_obat, nama_obat,deskripsi_obat, kode_pasien, harga_obat;

    public DB_Farmasi(String kode_obat, String nama_obat, String deskripsi_obat, String kode_pasien, String harga_obat) {
        super(kode_obat, nama_obat, deskripsi_obat, kode_pasien, harga_obat);
    }
      
    //Melakukan insert database Farmasi
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO farmasi VALUES('"+kode_obat+"', '"+nama_obat+"', '"+deskripsi_obat+"', '"+kode_pasien+"', '"+harga_obat+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan delete database Farmasi
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM farmasi WHERE kode_obat='"+kode_obat+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database Farmasi
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE farmasi SET nama_obat = '"+nama_obat+"' WHERE kode_obat = '"+kode_obat+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Farmasi
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE farmasi";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Farmasi
    public ArrayList<Farmasi> getData(){
        ArrayList<Farmasi> list_farmasi = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM farmasi";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.kode_obat = rs.getString("kode_obat");
                this.nama_obat = rs.getString("nama_obat");
                this.deskripsi_obat = rs.getString("deskripsi_obat");
                this.kode_pasien = rs.getString("kode_pasien");
                
                list_farmasi.add(new Farmasi(kode_obat, nama_obat, deskripsi_obat, kode_pasien, harga_obat));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_farmasi;
    }
    
    public static void main(String[] args) {
//        DB_Farmasi test = new DB_Farmasi("OB01", "ULTRAFLU", "Meredakan demam", "PAS01");
//        for (Farmasi e:test.getData()){
//            Object[] obj = new Object[2];
//            obj[0] = e.getKode_obat();
//            obj[1] = e.getNama_obat();
//        }
//        System.out.println();
//        System.out.println("berhasil");
    }
}
