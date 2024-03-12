package com.apigateway.model;

import lombok.Data;

import java.util.Collection;

@Data
public class AuthResponse {

    private  String userId;
    private  String refreshToken;
    private  String accessToken;
    private  long expiredAt;

    private Collection<String> authorities;
}
