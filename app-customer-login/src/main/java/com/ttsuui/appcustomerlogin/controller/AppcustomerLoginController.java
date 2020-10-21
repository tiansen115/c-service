package com.ttsuui.appcustomerlogin.controller;

import com.ttsuui.appcustomerlogin.entity.User;
import com.ttsuui.appcustomerlogin.service.UserServiceDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequestMapping("/user")
@RestController
@Slf4j
public class AppcustomerLoginController {
    @Autowired
    UserServiceDetail userServiceDetail;

    @RequestMapping("/login")
    public ResponseEntity<OAuth2AccessToken> login(@Valid User loginDto, BindingResult bindingResult, HttpServletResponse response) throws Exception {
        return userServiceDetail.login(loginDto,bindingResult,response);
    }
    @PostMapping("/register")
    public User postUser(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        return userServiceDetail.insertUser(username, password);
    }
    @RequestMapping("/foo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo() {
        return "程序猿小哥哥，你的鉴权测试通过啦";
    }
}
