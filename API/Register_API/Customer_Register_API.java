package com.BootCampProject1.BootCampProject1.API.Register_API;

import com.BootCampProject1.BootCampProject1.ENTITIES.CUSTOMER;
import com.BootCampProject1.BootCampProject1.ENTITIES.SELLER;
import com.BootCampProject1.BootCampProject1.ENTITIES.USER;
import com.BootCampProject1.BootCampProject1.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
public class Customer_Register_API {

    @Autowired
    private Repository repository;

    @PostMapping("/users/register")     //Customer Register API
    public ResponseEntity<?> registerUser(@Valid @RequestBody CUSTOMER newUser) {
//        System.out.println("Runs");
        Optional<USER> u1 = repository.findByEmail(newUser.getEmail());
        if (u1.isPresent())
        {
            return new ResponseEntity<>("user already registered", HttpStatus.BAD_REQUEST);
        }
        String token = UUID.randomUUID().toString();
        newUser.setToken(token);
     repository.save(newUser);
        return new ResponseEntity<>(token,HttpStatus.OK);
        }
    }

