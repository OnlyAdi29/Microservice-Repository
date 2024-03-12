package com.apigateway.controller;

import com.apigateway.model.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
public class AuthController {
    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient oAuth2AuthorizedClient ,
            @AuthenticationPrincipal OidcUser oidcUser){
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUserId(oidcUser.getEmail());
        authResponse.setAccessToken(oAuth2AuthorizedClient.getAccessToken().getTokenValue());
        authResponse.setRefreshToken(oAuth2AuthorizedClient.getRefreshToken().getTokenValue());
        authResponse.setExpiredAt(oAuth2AuthorizedClient.getAccessToken().getExpiresAt().getEpochSecond());
        List<String> collect = oidcUser.getAuthorities().stream().map(grantedAuthority -> {
            return grantedAuthority.getAuthority();
        }).collect(Collectors.toList());
        authResponse.setAuthorities(collect);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);

    }
}
