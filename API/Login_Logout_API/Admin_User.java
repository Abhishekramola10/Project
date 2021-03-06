package com.BootCampProject1.BootCampProject1.API.Login_Logout_API;

import com.BootCampProject1.BootCampProject1.ENTITIES.USER;
import com.BootCampProject1.BootCampProject1.JwtUtil;
import com.BootCampProject1.BootCampProject1.MyUserDetailsService;
import com.BootCampProject1.BootCampProject1.appuser.AppUser;
import com.BootCampProject1.BootCampProject1.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
public class Admin_User {

    @Autowired
    private Repository repository;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/admin_user/login")    // API to LOG-INTO the system as ADMIN user
    private ResponseEntity<?> LoginAdminUser(@RequestBody USER user){
        Optional<USER> ad = repository.findByEmail(user.getEmail());
        if (!ad.isPresent())
        {
            return new ResponseEntity<>("customer user not present", HttpStatus.BAD_REQUEST);
        }
        UserDetails appUser = myUserDetailsService.loadUserByUsername(user.getEmail());
        String token2 = jwtUtil.generateToken(appUser);
        String token = UUID.randomUUID().toString();
        ad.get().setToken(token2);
        return new ResponseEntity<>(token2,HttpStatus.OK);
    }

    //API to logout ,logged-in Admin user
    @PostMapping("/admin_user/logout")
    public ResponseEntity<?> logSellerUserOut(@Valid @RequestBody USER user) {
        Optional<USER> adu = repository.findByEmail(user.getEmail());
        if (!adu.isPresent())
        {
            return new ResponseEntity<>("user not present", HttpStatus.BAD_REQUEST);
        }
        String token2 = UUID.randomUUID().toString();
       adu.get().setToken(null);
        return new ResponseEntity<>(token2,HttpStatus.OK);
    }
}
