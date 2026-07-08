package com.example.history_logs.dto;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private Boolean isActive = true;
    private LocalDateTime lastLogin;
}
