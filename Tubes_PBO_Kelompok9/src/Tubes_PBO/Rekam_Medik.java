/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_PBO;

/**
 *
 * @author Naufal
 */
public class Rekam_Medik {
    private String kode_terapi,nama_terapi,deskripsi_terapi,kode_dokter, kode_pasien;
    
    public Rekam_Medik(String kode_terapi,String nama_terapi, String deskripsi_terapi,String kode_dokter, String kode_pasien){
        this.kode_terapi = kode_terapi;
        this.nama_terapi = nama_terapi;
        this.deskripsi_terapi = deskripsi_terapi;
        this.kode_dokter = kode_dokter;
        this.kode_pasien = kode_pasien;
    }
    
    public void setKode_terapi(String kode_terapi){
        this.kode_terapi = kode_terapi;
    }
    
    public void setNama_terapi(String nama_terapi){
        this.nama_terapi = nama_terapi;
    }
    
    public void setDeskripsi_terapi(String deskripsi_terapi){
        this.deskripsi_terapi = deskripsi_terapi;
    }
    
    public String getKode_terapi(){
        return kode_terapi;
    }
    
    public String getNama_terapi(){
        return nama_terapi;
    }
    
    public String getDeskripsi_terapi(){
        return deskripsi_terapi;
    }
    
    public String getKode_dokter(){
        return kode_dokter;
    }
    
    public String getKode_pasien(){
        return kode_pasien;
    }
    
    public void display(){
        System.out.println("Kode Terapi          :" + this.kode_terapi);
        System.out.println("Nama Terapi        :" + this.nama_terapi);
        System.out.println("Deskripsi Terapi    :" + this.deskripsi_terapi);
        System.out.println("Kode Dokter       :" + this.kode_dokter);
        System.out.println("Kode Pasien       :" + this.kode_pasien);
    }
}
