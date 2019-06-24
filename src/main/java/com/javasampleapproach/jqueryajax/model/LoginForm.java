/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasampleapproach.jqueryajax.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author User
 */
public class LoginForm {
 
    @NotBlank(message = "Username tidak boleh kosong!")
    String username;
 
    @NotBlank(message = "Password tidak boleh kosong!")
    String password;
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
		this.password = password;
	}
    
    public String getPassword() {
		return password;
	}
    
}
