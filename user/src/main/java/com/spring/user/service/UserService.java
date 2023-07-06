package com.spring.user.service;
 // UserDTO를 호출하는 서비스

import com.spring.user.repository.UserMapperRepository;
import com.spring.user.data.UserDTO;
import com.spring.user.VO.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);


    private final UserMapperRepository userMapperRepository;

    @Transactional
    public void joinUser(UserVo userVo){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVo.setUserPw(passwordEncoder.encode(userVo.getUserPw()));
        userVo.setUserAuth("USER");
        userVo.setAppendDate(localTime);
        userVo.setUpdateDate(localTime);
        userMapperRepository.saveUser(userVo);
    }


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // 여기서 받은 유저 패스워드와 비교하여 로그인 인증
        UserVo userVo = userMapperRepository.findByEmail(userId);
        System.out.println("Username : " + userId);
        if (userVo == null){
            throw new UsernameNotFoundException("User not Authorized");
        }
        return userVo;
    }


}
