/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasampleapproach.jqueryajax.repository;

import com.javasampleapproach.jqueryajax.model.UserLogin;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface loginUserRepo extends CrudRepository<UserLogin, String> {

    @Query(value = "select * from login", nativeQuery = true)
    List<UserLogin> getAll();
}
