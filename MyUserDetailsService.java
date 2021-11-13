package com.BootCampProject1.BootCampProject1;

import com.BootCampProject1.BootCampProject1.ENTITIES.USER;
import com.BootCampProject1.BootCampProject1.appuser.AppUser;
import com.BootCampProject1.BootCampProject1.appuser.AppUserRole;
import com.BootCampProject1.BootCampProject1.appuser.GrantAuthorityImpl;
import com.BootCampProject1.BootCampProject1.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired

    private Repository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return new User("user-name", "pass-word", new ArrayList<>());
        USER user = repository.findByEmail(userName).get();
        System.out.println(user);
        if (userName != null) {
            //new GrantAuthorityImpl(user.getRole())
            return new AppUser(user.getEmail(), user.getPassword(), Arrays.asList(new GrantAuthorityImpl("ROLE_ADMIN")));
        } else {
            throw new RuntimeException();
        }
    }
}
