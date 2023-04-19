package com.backend.BackendSecurity.controllers;

import com.backend.BackendSecurity.dtos.DataTokenJWT;
import com.backend.BackendSecurity.dtos.Login;
import com.backend.BackendSecurity.models.UserModel;
import com.backend.BackendSecurity.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    final AuthenticationManager authenticationManager;
    final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid Login login){
        var token = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        var authentication = authenticationManager.authenticate(token);

        var tokenJWT = tokenService.createToken((UserModel) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}
