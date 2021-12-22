/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Naufal
 */
public class Payment {
    private int jumlah_tagihan, no_pembayaran;
    private String deskripsi_pembayaran, metodePembayaran;
    
    public Payment(int jumlah_tagihan, int no_pembayaran, String deskripsi_pembayaran, String metodePembayaran){
        this.jumlah_tagihan = jumlah_tagihan;
        this.no_pembayaran = no_pembayaran;
        this.deskripsi_pembayaran = deskripsi_pembayaran;
        this.metodePembayaran = metodePembayaran;
    }
    
    public void setMetodePembayaran(String metodePembayaran){
        this.metodePembayaran = metodePembayaran;
    }
    
    public void setJumlah_tagihan(int jumlah_tagihan){
        this.jumlah_tagihan = jumlah_tagihan;
    }
    
    public void setDeskripsi_pembayaran(String deskripsi_pembayaran){
        this.deskripsi_pembayaran = deskripsi_pembayaran;
    }
    
    public int getJumlah_tagihan(){
        return jumlah_tagihan;
    }
    
    public int getNopembayaran(){
        return no_pembayaran;
    }
    
    public String getDeskripsi_pembayaran(){
        return deskripsi_pembayaran;
    }
    
    public void display(){
        System.out.println("Jumlah Tagihan          :" + this.jumlah_tagihan);
        System.out.println("Nomor Pembayaran        :" + this.no_pembayaran);
        System.out.println("Deskripsi Pembayaran    :" + this.deskripsi_pembayaran);
        System.out.println("Metode Pembayaran       :" + this.metodePembayaran);
    }
    
    
}
