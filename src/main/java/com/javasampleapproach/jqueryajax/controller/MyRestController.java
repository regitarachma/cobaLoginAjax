package com.javasampleapproach.jqueryajax.controller;

import com.javasampleapproach.jqueryajax.model.AjaxResponseBody;
import com.javasampleapproach.jqueryajax.model.LoginForm;
import com.javasampleapproach.jqueryajax.model.User;
import com.javasampleapproach.jqueryajax.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    //pemanggilan user service

    UserService userService;

    @Autowired
    //constructor setter (untuk mengubah atau memberikan nilai)
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    //postMapping 
    @PostMapping("/api/login")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody LoginForm loginForm, Errors errors) {
        //mengambil fungsi setter getter result dari ajaxResponseBody
        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        //hasError didapat dari fungsi bawaan springBoot
        if (errors.hasErrors()) {
            
            //akan menampilkan message eror
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }
        
        //list model user yang diambil dari userService yang berisi fungsi untuk login
        List<User> users = userService.findByAll(loginForm.getUsername());
        if (users.isEmpty()) {
            result.setMsg("tidak ditemukan user tersebut!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);
    }
}
