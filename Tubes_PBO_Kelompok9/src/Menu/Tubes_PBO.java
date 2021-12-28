/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Class.*;
import Database.*;
import java.util.Scanner;

/**
 *
 * @author Naufal
 */
public class Tubes_PBO {

    /**
     * @param args the command line arguments
     */
    
    static void menu(){
        System.out.println("Main Menu:");
        System.out.println("1. Pendaftaran Pasien");
        System.out.println("2. Dokter mencatat keluhan dan memberikan diagnosa penyakit.");
        System.out.println("3. Dokter meberikan rekomendasi terapi");
        System.out.println("4. Dokter memberikan catatan obat.");
        System.out.println("5. Farmasi menkalkulasikan harga obat menjadi invoice");
        System.out.println("6. invoice dikirimkan ke pasien untuk dibayarkan");
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
        System.out.print("Masukkan angka: ");
        Integer input = (new Scanner(System.in)).nextInt();
        switch(input){
            case 1:
                System.out.println("Test");
                break;
            default:
                System.out.println("test2");
                break;
        }
    }
    
}
