package com.udeajobs.identity.account_service.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@Builder
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;
}
