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
public abstract class Terapi {
    private String jenis_terapi, deskripsi_penyakit, jenis_penyakit, kode_terapi;

    public Terapi(String jenis_terapi, String deskripsi_penyakit, String jenis_penyakit, String kode_terapi) {
        this.jenis_terapi = jenis_terapi;
        this.deskripsi_penyakit = deskripsi_penyakit;
        this.jenis_penyakit = jenis_penyakit;
        this.kode_terapi = kode_terapi;
    }

    public String getKode_terapi() {
        return kode_terapi;
    }

    public void setKode_terapi(String kode_terapi) {
        this.kode_terapi = kode_terapi;
    }
    
    public void setJenis_terapi(String jenis_terapi){
        this.jenis_terapi = jenis_terapi;
    }
    public void setDeskripsi_penyakit(String deskripsi_penyakit){
        this.deskripsi_penyakit = deskripsi_penyakit;
    }
    public void setJenis_penyakit(String jenis_penyakit){
        this.jenis_penyakit = jenis_penyakit;
    }
    
    public String getJenis_terapi(){
        return this.jenis_terapi;
    }
    public String getDeskripsi_penyakit(){
        return this.deskripsi_penyakit;
    }
    public String getJenis_penyakit(){
        return this.jenis_penyakit;
    }
    
    public abstract String informasi_terapi();
    
    public void display(){
        System.out.println("Jenis Terapi       :" + this.jenis_terapi);
        System.out.println("Deskripsi Penyakit :" + this.deskripsi_penyakit);
        System.out.println("Jenis Penyakit     :" + this.jenis_penyakit);
    }
}
