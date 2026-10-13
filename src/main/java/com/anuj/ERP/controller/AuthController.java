package com.anuj.ERP.controller;

import com.anuj.ERP.requestDTO.LoginRequestDTO;
import com.anuj.ERP.security.JwtService;
import com.anuj.ERP.security.TokenRevocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRevocationService tokenRevocationService;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService, TokenRevocationService tokenRevocationService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.tokenRevocationService = tokenRevocationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequestDTO request) {

        // creating authentication object from uid and pass
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                request.getId(),
                                request.getPassword() )
        );

        // getting token generated from jwtService
        String token = jwtService.generateToken(authentication);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Login successful",
                        "token", token
                )
        );
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(
            @AuthenticationPrincipal Jwt jwt) {

        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Authentication required"));
        }

        tokenRevocationService.revokeToken(jwt);

        return ResponseEntity.ok(
                Map.of("message", "Logout successful")
        );
    }
}