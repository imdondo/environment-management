package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.controller;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.AuthRequest;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTUtil jwtUtil;
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            return jwtUtil.generateToken(authRequest.getUsername());

        }catch (Exception e){
            throw e;
        }
    }
}
