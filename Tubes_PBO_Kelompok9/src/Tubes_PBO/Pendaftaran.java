/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_PBO;

import java.time.LocalDate;

/**
 *
 * @author Naufal
 */
public class Pendaftaran {
    private LocalDate tgl_pendaftaran;
    private String kode_pendaftaran;
    private String penyakit;
    
    public Pendaftaran(String kode_pendaftaran, LocalDate tgl_pendaftaran, String penyakit){
        this.kode_pendaftaran = kode_pendaftaran;
        this.tgl_pendaftaran = tgl_pendaftaran;
        this.penyakit = penyakit;  
    }
    
    public void setKode_pendaftaran(String kode_pendaftaran){
        this.kode_pendaftaran = kode_pendaftaran;
    }
    
    public void setTgl_pendaftaran(LocalDate tgl_pendaftaran){
        this.tgl_pendaftaran = tgl_pendaftaran;
    }
    
    public void setPenyakit(String penyakit){
        this.penyakit = penyakit;
    }
    
    public void display(){
        System.out.println("Tanggal Pendaftaran :" + this.tgl_pendaftaran);
        System.out.println("Kode Pendaftaran    :" + this.kode_pendaftaran);
        System.out.println("Penyakit            :" + this.penyakit);
    }
}
