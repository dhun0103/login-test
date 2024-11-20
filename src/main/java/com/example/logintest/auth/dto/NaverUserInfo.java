package com.example.logintest.auth.dto;

import com.example.logintest.auth.constant.Provider;
import lombok.AllArgsConstructor;
import java.util.Map;

@AllArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes;

    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return Provider.NAVER_PROVIDER.getProvider();
    }

    @Override
    public String getName() {
        return (String) attributes.get("nickname");
    }
}
