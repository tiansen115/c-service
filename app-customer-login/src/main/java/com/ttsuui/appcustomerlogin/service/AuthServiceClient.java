package com.ttsuui.appcustomerlogin.service;

import com.ttsuui.appcustomerlogin.entity.JWT;
import com.ttsuui.appcustomerlogin.service.impl.AuthServiceClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "auth-server", fallback = AuthServiceClientFallback.class)
public interface AuthServiceClient {
    @PostMapping("/oauth/token")
    JWT getToken(@RequestHeader("Authorization") String Authorization,
                 @RequestParam("grant_type") String grant_type,
                 @RequestParam("username") String username,
                 @RequestParam("password") String password);
}
