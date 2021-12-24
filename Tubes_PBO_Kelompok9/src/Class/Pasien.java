package Class;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Class.Payment;
import java.time.LocalDate;

/**
 *
 * @author Naufal
 */
public class Pasien {
    private String kode_pasien, penyakit, dokter_rujukan;
    private LocalDate tgl_pendaftaran;
    private String[] list_pembayaran;
    private Payment[] invoice;
    
    public Pasien(String kode_pasien, String penyakit, String dokter_rujukan, LocalDate tgl_pendaftaran){
        this.kode_pasien = kode_pasien;
        this.penyakit = penyakit;
        this.dokter_rujukan = dokter_rujukan;
        this.tgl_pendaftaran = tgl_pendaftaran;
    }
    
    public void setKode_pasien(String kode_pasien){
        this.kode_pasien = kode_pasien;
    }

    public void setTgl_pendaftaran(LocalDate tgl_pendaftaran) {
        this.tgl_pendaftaran = tgl_pendaftaran;
    }
    
    public String getKode_pasien(){
        return kode_pasien;
    }
    
    public String[] getList_pembayaran(){
        return list_pembayaran;
    }
    
    public Payment[] getInvoice(){
        return invoice;
    }
    
    public LocalDate getTgl_pendaftaran(){
        return tgl_pendaftaran;
    }
    
    public String getPenyakit(){
        return penyakit;
    }
    
    public void setDokter_rujukan(String dokter_rujukan){
        this.dokter_rujukan = dokter_rujukan;
    }
    
    public void display(){
        System.out.println("Kode Pasien         :" + this.kode_pasien);
        System.out.println("Nama Penyakit       :" + this.penyakit);
        System.out.println("Dokter Rujukan      :" + this.dokter_rujukan);
        System.out.println("Tanggal Pendaftaran :" + this.tgl_pendaftaran);
    }
    
}
