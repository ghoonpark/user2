package com.spring.user.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;

    //@Builder
    //public UserDTO(Integer id, String username, String password){
    //    this.id = id;
    //    this.username = username;
    //    this.password = password;

    //}
}
