//package com.BootCampProject1.BootCampProject1.API;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//public class Admin_API {
//
//    @Autowired
//    private SessionRegistry sessionRegistry;
//
//        //As an ADMIN
//    //API to get all registered customers
//    @GetMapping("/users/customers")
//
//
//    //API to get all registered sellers
//    @GetMapping("/users/sellers")
//    public void listLoggedInSellers() {
//        final List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
//
//        for(final Object principal : allPrincipals) {
//            if(principal instanceof SecurityUser) {
//                final SecurityUser user = (SecurityUser) principal;
//
//                // Do something with user
//                System.out.println(user);
//            }
//        }
//    }
//
//    //API to activate a customer
//    //API to de-activate a customer
//    //API to activate a seller
//    //API to de-activate a seller
//
//
//    }
//
//
