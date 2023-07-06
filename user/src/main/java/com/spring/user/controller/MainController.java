package com.spring.user.controller;

import com.spring.user.VO.UserVo;
import com.spring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    public String main() {
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return  "login";
    }




    /**
     * 회원가입 폼
     */
    @GetMapping("/signUp")
    public String singUpForm(){
        return "signup";
    }



}
