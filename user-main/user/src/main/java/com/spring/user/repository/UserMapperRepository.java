package com.spring.user.repository;


import lombok.Builder;
import org.apache.ibatis.annotations.Mapper;
import com.spring.user.VO.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Mapper
public interface UserMapperRepository {
    void saveUser(UserVo userVo);

    //로그인
    UserVo getUserAccount(String userId);

    Optional<UserVo> findByEmail2(UserVo userVo);



    public UserVo findByEmail(String userId);

    //@Insert("insert into member(id, username, password) values(#{id}, #{username}, #{password})")
    //void saverUser2(UserDTO UserDTO);


}
