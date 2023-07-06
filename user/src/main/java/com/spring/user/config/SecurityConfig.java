package com.spring.user.config;


import com.spring.user.service.UserService;
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    //private final UserService userService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/signUp").permitAll()
                        .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                )

                .formLogin(login -> login	// form 방식 로그인 사용
                        .loginPage("/login")
                        .loginProcessingUrl("/login_proc")
                        .usernameParameter("userId")
                        .passwordParameter("userPw")
                        .defaultSuccessUrl("/login_success", true)	// 성공 시 dashboard로
                        .failureUrl("/login_fail")
                        .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
                )
                .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //public void configure(AuthenticationManagerBuilder auth) throws Exception{
    //    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    //}
}
