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
    private String kode_pasien, keluhan, dokter_rujukan, kode_terapi, nama_pasien;
    private LocalDate tgl_pendaftaran;
    //private Payment[] invoice;

    public Pasien(String kode_pasien, String keluhan, String dokter_rujukan, String kode_terapi, String nama_pasien, LocalDate tgl_pendaftaran) {
        this.kode_pasien = kode_pasien;
        this.keluhan = keluhan;
        this.dokter_rujukan = dokter_rujukan;
        this.kode_terapi = kode_terapi;
        this.nama_pasien = nama_pasien;
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

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKode_terapi(String kode_terapi) {
        this.kode_terapi = kode_terapi;
    }

    public String getKode_terapi() {
        return kode_terapi;
    }

//    public void setInvoice(Payment[] invoice) {
//        this.invoice = invoice;
//    }
//
//    public Payment[] getInvoice(){
//        return invoice;
//    }
    
    public LocalDate getTgl_pendaftaran(){
        return tgl_pendaftaran;
    }
    
    public void setDokter_rujukan(String dokter_rujukan){
        this.dokter_rujukan = dokter_rujukan;
    }

    public String getDokter_rujukan() {
        return dokter_rujukan;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }
    
    public void display(){
        System.out.println("Kode Pasien         :" + this.kode_pasien);
        System.out.println("Dokter Rujukan      :" + this.dokter_rujukan);
        System.out.println("Tanggal Pendaftaran :" + this.tgl_pendaftaran);
    }
    
}
