package com.example.vigwamgomel.configuration;

import com.example.vigwamgomel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/user/reg" , "/images/**", "/user/login", "/colors", "/gallery").permitAll()
                .antMatchers( "/user/reg", "/user/login").not().authenticated()
                .antMatchers("/admin/**", "/order/orders/**","/order/findAllOrders/**",
                        "/orders/edit/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .logout().permitAll();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("test")
//				.password(passwordEncoder().encode("test"))
//				.roles("USER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
