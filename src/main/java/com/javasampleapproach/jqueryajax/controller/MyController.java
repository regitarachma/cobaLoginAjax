/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasampleapproach.jqueryajax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class MyController {
 
    private final Logger logger = LoggerFactory.getLogger(MyController.class);
 
    @GetMapping("/")
    public String index() {
        return "login";
    }
 
}