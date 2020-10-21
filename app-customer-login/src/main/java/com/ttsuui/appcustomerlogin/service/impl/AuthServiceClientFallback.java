package com.ttsuui.appcustomerlogin.service.impl;

import com.ttsuui.appcustomerlogin.entity.JWT;
import com.ttsuui.appcustomerlogin.service.AuthServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthServiceClientFallback implements AuthServiceClient {
    @Override
    public JWT getToken(String Authorization,
                        String grant_type,
                        String username,
                        String password) {
        log.info("您获取令牌失败了哦，请稍后重试");
        return null;
    }
}
