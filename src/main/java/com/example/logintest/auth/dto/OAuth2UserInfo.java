package com.example.logintest.auth.dto;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getName();
}
