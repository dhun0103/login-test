package com.example.logintest.token.application;

import com.example.logintest.token.dto.TokenDto;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
    TokenDto.TokenResponse reissueAccessToken(String authorizationHeader);
}
