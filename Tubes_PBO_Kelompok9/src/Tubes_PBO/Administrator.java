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
public class Administrator {
    private String username;
    private String password;
    
    public Administrator(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean verify_Login(String username, String password){
        if (username==username && password==password){
            return true;
        } else {
            return false;
        }
    }
    
}
