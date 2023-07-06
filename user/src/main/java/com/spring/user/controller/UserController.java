package com.spring.user.controller;

import com.spring.user.service.UserService;
import com.spring.user.repository.UserMapperRepository;
import com.spring.user.data.UserDTO;
import com.spring.user.VO.UserVo;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원가입 진행
     */
    @PostMapping("/signUp")
    public String signUp(UserVo userVo){
        userService.joinUser(userVo);
        return "login";
    }
    @GetMapping("/login_fail")
    public String index(){
        return  "login_fail";
    }

    /**
     * 유저 페이지
     */

    @GetMapping("/login_access")
    public String userAccess(Model model, Authentication authentication){
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        //UserVo userVo = (UserVo) authentication.getDeclaringClass();
        return "login_success";
    }
}
