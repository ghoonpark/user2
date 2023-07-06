package com.spring.user.repository;


import org.apache.ibatis.annotations.Mapper;
import com.spring.user.VO.UserVo;

import java.util.Optional;
@Mapper
public interface UserMapperRepository {
    void saveUser(UserVo userVo);

    //로그인
    UserVo getUserAccount(String userId);

    Optional<UserVo> findByUserid(String userId);

    public UserVo findByEmail(String userId);

    //@Insert("insert into member(id, username, password) values(#{id}, #{username}, #{password})")
    //void saverUser2(UserDTO UserDTO);


}
