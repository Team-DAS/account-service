package com.udeajobs.identity.account_service.controller;


import com.udeajobs.identity.account_service.dto.RegistrationRequest;
import com.udeajobs.identity.account_service.entity.User;
import com.udeajobs.identity.account_service.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<User> registerAccount(@Valid @RequestBody RegistrationRequest registrationRequest) {
        User user = User.builder()
                .username(registrationRequest.username())
                .email(registrationRequest.email())
                .password(registrationRequest.password())
                .build();
        return new ResponseEntity<>(accountService.registerUser(user), HttpStatus.CREATED);
    }
}
