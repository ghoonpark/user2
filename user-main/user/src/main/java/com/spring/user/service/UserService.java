package com.spring.user.service;
 // UserDTO를 호출하는 서비스

import com.spring.user.repository.UserMapperRepository;
import com.spring.user.VO.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);


    private final UserMapperRepository userMapperRepository;

    public UserVo getUserAccount(String userId)
    {
        return userMapperRepository.findByEmail(userId);
    }

    @Transactional
    public void joinUser(UserVo userVo){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVo.setUserPw(passwordEncoder.encode(userVo.getUserPw()));
        userVo.setUserAuth("USER");
        userVo.setAppendDate(localTime);
        userVo.setUpdateDate(localTime);
        userMapperRepository.saveUser(userVo);
    }

    //@Autowired
    //public Optional<UserVo> findOne2(UserVo uservo)
    //{
     //   return ;
    //    return userMapperRepository.findByEmail2(uservo);
    //}

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // 여기서 받은 유저 패스워드와 비교하여 로그인 인증
        //UserVo userVo = UserVo.builder().userId(userId).build();

       // Optional<UserVo> findOne = findOne2(userVo);


       // UserVo userVo = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        UserVo userVo = userMapperRepository.getUserAccount(userId);
        System.out.println("Username : " + userId);
        System.out.println("User Name" + userVo.getUserId());
        System.out.println("User pw" + userVo.getUserPw());
        if (userVo == null){
            throw new UsernameNotFoundException("User not Authorized");
        }
        return userVo;
    }


}
