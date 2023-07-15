package com.spring.user.service;

import com.spring.user.repository.UserMapperRepository;
import com.spring.user.data.UserDTO;
import com.spring.user.VO.UserVo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Service
//@RequiredArgsConstructor
//public class JoinService implements UserDetailsService {


    //private final UserMapperRepository userMapperRepository;

  //  @Override
  //  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // 여기서 받은 유저 패스워드와 비교하여 로그인 인증
     //   UserVo userVo = userMapperRepository.getUserAccount(userId);
     //   if (userVo == null){
     //       throw new UsernameNotFoundException("User not Authorized");
     //   }
    //    return userVo;
    //}
//}
