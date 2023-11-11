package com.example.Calendar.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/", "/js/**", "/css/**", "/images/**").permitAll()
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/user").hasAnyRole("ADMIN", "EMPLOYEE")
                                .requestMatchers(HttpMethod.GET).permitAll()
                                .requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "EMPLOYEE")
                                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                )
                .formLogin(form ->
                form
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/admin")
                        .permitAll()
                );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrv -> csrv.disable());
        return http.build();
    }
}

