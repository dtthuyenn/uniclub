package com.cybersoft.uniclub09.controller;

import com.cybersoft.uniclub09.services.imp.AuthenticationServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationServicesImp authenticationServicesImp;

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestParam String email,
                                    @RequestParam String password) {

        boolean isSuccess = authenticationServicesImp.checkLogin(email, password);





        return ResponseEntity.ok().build();
    }


}
