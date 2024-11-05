package com.banking.app.web;

import com.banking.app.bo.User;
import com.banking.app.entities.LoginRequest;
import com.banking.app.entities.LoginResponse;
import com.banking.app.entities.RegisterUserRequest;
import com.banking.app.service.AuthenticationService;
import com.banking.app.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest){
        LOGGER.info("Entering into login() controller to authenticate the user: {}",loginRequest.getUsername());
        User authenticatedUser = authenticationService.authenticate(loginRequest);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse.Builder()
                .setToken(jwtToken)
                .setExpiresIn(jwtService.getJwtExpiration()).build();
        LOGGER.info("Returning the JWT token to the user");
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterUserRequest registerUserRequest){
        LOGGER.info("Entering signup() method in AuthController to register the user with username: {}",registerUserRequest.getUsername());
           User signupUser = authenticationService.signup(registerUserRequest);
           if(signupUser!=null){
               LOGGER.info("Exiting signup() from AuthController after registering the user");
               return ResponseEntity.ok(signupUser);
           }else {
               LOGGER.error("Error registering the user into database, duplicate username: {} ",registerUserRequest.getUsername());
               return ResponseEntity.internalServerError().build();
           }
    }

}
