/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.time.LocalDate;
import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author Naufal
 */
public class DB_Pasien extends Pasien{
    
    private String kode_pasien, keluhan, dokter_rujukan, kode_terapi, nama_pasien;
    private LocalDate tgl_pendaftaran;
//    private Payment[] invoice;
    
    public DB_Pasien(String kode_pasien, String keluhan, String dokter_rujukan, String kode_terapi, String nama_pasien, LocalDate tgl_pendaftaran) {
        super(kode_pasien, keluhan, dokter_rujukan, kode_terapi, nama_pasien, tgl_pendaftaran);
    }

    //Melakukan insert database Pasien
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO pasien VALUES('"+kode_pasien+"', '"+keluhan+"', '"+tgl_pendaftaran+"', '"+dokter_rujukan+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan delete database Pasien
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM pasien WHERE kode_pasien='"+kode_pasien+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Melakukan update database Pasien
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE pasien SET keluhan = '"+keluhan+"', tgl_pendaftaran='"+tgl_pendaftaran+"', dokter_rujukan='"+dokter_rujukan+"' WHERE kode_pasien = '"+kode_pasien+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Pasien
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE pasien";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Pasien
    public ArrayList<Pasien> getData(){
        ArrayList<Pasien> list_pasien = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM pasien";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.kode_pasien = rs.getString("kode_pasien");
                this.keluhan = rs.getString("keluhan");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                String date = rs.getString("tgl_pendaftaran");
                LocalDate localDate = LocalDate.parse(date, formatter);
                this.tgl_pendaftaran = localDate;
                
                this.dokter_rujukan = rs.getString("dokter_rujukan");
                
                list_pasien.add(new Pasien(kode_pasien, keluhan, dokter_rujukan, kode_terapi, nama_pasien, tgl_pendaftaran));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_pasien;
    }
    
    public static void main(String[] args) {
//        DB_Pasien test = new DB_Pasien("PAS09", "demam, muntah", "Nama dokter", "TP1", LocalDate.now());
//        test.reset();
//        System.out.println();
//        System.out.println("berhasil");
    }
}
