package com.selfproject.policedepartment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final TokenAuthenticationFilter tokenAuthenticationFilter;

    @Autowired
    public WebSecurityConfig(TokenAuthenticationFilter tokenAuthenticationFilter) {
        this.tokenAuthenticationFilter = tokenAuthenticationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                                .requestMatchers("car/get-car-by-number-pin").hasAnyAuthority("USER", "ADMIN")
                                .requestMatchers("user/get-all").hasAuthority("ADMIN")
                                .requestMatchers("violation/get-violation-by-id-pin" , "car/get-current-user-cars"
                                        ,"driving-license/create-driving-license", "vignette/create-vignette"
                                        ,"car/create-car","vignette/get-vignette-by-carnum-pin").hasAnyAuthority("ADMIN", "POLICEMAN", "USER")
                                .requestMatchers("violation/get-electronic-slips-by-pin", "violation/get-by-pin",
                                        "violation/get-not-handed-to-driver-by-pin", "car/get-cars-by-pin", "violation/get-all-by-pin",
                                        "/driving-license/get-not-verified", "/driving-license/verify-by-id").hasAnyAuthority("POLICEMAN", "ADMIN")
                                .requestMatchers("/violation/create-violation","/violation/get-penal-decrees-by-pin").hasAuthority("POLICEMAN")
                                .requestMatchers("/swagger-ui.html","/swagger-ui/**","/v3/api-docs/**","/auth/login","/auth/register").permitAll()
                                .anyRequest().authenticated()
                        )
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling-> exceptionHandling.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}