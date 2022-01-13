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
public class DB_Terapi_Psikologis extends Terapi{
    private String kode_terapi, nama_terapi, deskripsi_terapi, kode_dokter;

    //constructor
    public DB_Terapi_Psikologis(String kode_terapi, String nama_terapi, String deskripsi_terapi, String kode_dokter, String jenis_terapi, String jenis_penyakit, String deskripsi_penyakit) {
        super(jenis_terapi, jenis_penyakit, deskripsi_penyakit);
        this.kode_terapi = kode_terapi;
        this.nama_terapi = nama_terapi;
        this.deskripsi_terapi = deskripsi_terapi;
        this.kode_dokter = kode_dokter;
    }
    
    //Melakukan insert database Terapi Psikologis
    public void insert(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO terapi_psikologis VALUES('"+kode_terapi+"', '"+nama_terapi+"', '"+deskripsi_terapi+"', '"+kode_dokter+"')";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan delete database Terapi Psikologis
    public void delete(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM terapi_psikologis WHERE kode_terapi='"+kode_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Melakukan update database Terapi Psikologis
    public void update(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE terapi_psikologis SET nama_terapi = '"+nama_terapi+"' WHERE kode_terapi = '"+kode_terapi+"'";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // melakukan reset database Terapi Psikologis
    public void reset(){
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "TRUNCATE TABLE terapi_psikologis";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mengambil data dari database Terapi Psikologis
    public ArrayList<Terapi_Psikologis> getData(){
        ArrayList<Terapi_Psikologis> list_terapi_psikologis = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/puskesmas", 
                "root", 
                "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM terapi_psikologis";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.kode_terapi = rs.getString("kode_terapi");
                this.nama_terapi = rs.getString("nama_terapi");
                this.deskripsi_terapi = rs.getString("deskripsi_terapi");
                this.kode_dokter = rs.getString("kode_dokter");
                
                list_terapi_psikologis.add(new Terapi_Psikologis(kode_terapi, nama_terapi, deskripsi_terapi, kode_dokter, kode_terapi, kode_terapi, deskripsi_terapi));
             }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_terapi_psikologis;
    }
    
    public static void main(String[] args) {
//        DB_Terapi_Psikologis test = new DB_Terapi_Psikologis("TP05", "Hipnoteraphy", "tes tes", "SPP01");
//        test.reset();
//        System.out.println();
//        System.out.println("berhasil");
    }

    @Override
    public String informasi_terapi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
