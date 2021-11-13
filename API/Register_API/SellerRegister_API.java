package com.BootCampProject1.BootCampProject1.API.Register_API;

import com.BootCampProject1.BootCampProject1.ENTITIES.SELLER;
import com.BootCampProject1.BootCampProject1.ENTITIES.USER;
import com.BootCampProject1.BootCampProject1.repository.Repository;
import com.BootCampProject1.BootCampProject1.OTHERS.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class SellerRegister_API {

    @Autowired
    private Repository repository;

    @PostMapping("/sellers/register")     //Seller Register API
    public ResponseEntity<?> registerSeller(@Valid @RequestBody SELLER newSeller) {
//        System.out.println("Runs");
        Optional<USER> u2 = repository.findByEmail(newSeller.getEmail());
        if (u2.isPresent())
        {
            return new ResponseEntity<>("Seller already registered", HttpStatus.BAD_REQUEST);
        }
        String tokens = UUID.randomUUID().toString();
        newSeller.setToken(tokens);
        repository.save(newSeller);
        return new ResponseEntity<>(tokens,HttpStatus.OK);
    }
}
