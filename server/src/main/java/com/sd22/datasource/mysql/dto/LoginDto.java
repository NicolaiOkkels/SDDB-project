package com.sd22.datasource.mysql.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
