/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasampleapproach.jqueryajax.model;

import java.util.List;

/**
 *
 * @author User
 */
public class AjaxResponseBody {
 
    String msg;
//    List<UserLogin> result;
    List<User> result;
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public List<User> getResult() {
        return result;
    }
 
    public void setResult(List<User> result) {
        this.result = result;
    }
 
}