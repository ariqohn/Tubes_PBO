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
public class Terapi_Psikologis {
    private string kode_terapi;
    private string nama_terapi;
    private string deskripsi_terapi;
    private string kode_dokter;
    private string kode_pasien;
    
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
        return this.kode_terapi;
    }
    public String getNama_terapi(){
        return this.nama_terapi;
    }
    public String getDeskripsi_terapi(){
        return this.deskripsi_terapi;
    }
    
    public String getKode_dokter(){
        return this.kode_dokter;
    }
    public String getKode_pasien(){
        return this.kode_pasien;
    }
    public String informasi_terapi(){
        return this.informasi_terapi;
    }
    public int totalBiaya_terapi(){
        return this.totalBiaya_terapi;
    }
    
}
