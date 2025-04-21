package com.raza.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/PurchaseEntry**", "/report**").hasRole("MSD_ADMIN")
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/cstLogin.html")
                .loginProcessingUrl("/cstValidateSecureLogin")
                .usernameParameter("msd_uname123")
                .passwordParameter("msd_pwd123")
                .failureUrl("/cstLogin.html?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/cstlogout")
                .invalidateHttpSession(true)
                .permitAll()
            )
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/accessDeniedPage.html")
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user").password("user").roles("MSD_USER").build(),
            User.withUsername("admin").password("admin").roles("MSD_ADMIN").build(),
            User.withUsername("dba").password("dba").roles("MSD_DBA").build()
        );
    }

    // 👇 In-memory passwords need an encoder — NoOp for dev only!
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Use BCrypt for production
    }
}
