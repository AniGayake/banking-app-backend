package com.banking.app.service;

import com.banking.app.bo.User;
import com.banking.app.entities.LoginRequest;
import com.banking.app.entities.RegisterUserRequest;
import com.banking.app.exception.customexceptions.DuplicateUserException;
import com.banking.app.exception.entity.ErrorMessage;
import com.banking.app.exception.customexceptions.InvalidCredentialsException;
import com.banking.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserRequest userRequest){
        LOGGER.info("Entering signup() in service to process user with username: {} ",userRequest.getUsername() );
        User user = new User();
        user.setUserName(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        try{
            return userRepository.save(user);
        }catch (Exception exception){
            LOGGER.error("Duplicate username, try with another username");
            throw new DuplicateUserException("Duplicate user",new ErrorMessage("Duplicate User", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Duplicate user found, please try with another username"));
        }

    }

    public User authenticate(LoginRequest loginRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),loginRequest.getPassword()));
            LOGGER.info("User Authentication Successful for user: {}",loginRequest.getUsername());
        }catch (AuthenticationException authenticationException){
            LOGGER.error("Unable to authenticate the user: {}",authenticationException.getMessage());
            throw new InvalidCredentialsException("Authentication Error",401,"Invalid username and password","login error","incorrect username or password");

        }

        return userRepository.findByUserName(loginRequest.getUsername()).orElseThrow();
    }
}
