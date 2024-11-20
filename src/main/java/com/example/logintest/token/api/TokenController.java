package com.example.logintest.token.api;

import com.example.logintest.common.ApiResponse;
import com.example.logintest.common.constant.SuccessStatus;
import com.example.logintest.token.application.TokenService;
import com.example.logintest.token.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService authService;

    // 액세스 토큰을 재발행하는 API
    @GetMapping("/reissue/access-token")
    public ResponseEntity<ApiResponse<TokenDto.TokenResponse>> reissueAccessToken(
            @RequestHeader("Authorization") String authorizationHeader) {

        TokenDto.TokenResponse accessToken = authService.reissueAccessToken(authorizationHeader);
        return ApiResponse.onSuccess(SuccessStatus._CREATED_ACCESS_TOKEN, accessToken);
    }
}
