package it.ludo.pizzeria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/user").hasAnyAuthority("USER")
                .requestMatchers("/admin").hasAnyAuthority("ADMIN")
                // .requestMatchers("/").permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .and().exceptionHandling();

        // .formLogin()
        // .loginPage("/login")
        // .defaultSuccessUrl("/home", true)
        // .permitAll()
        // .and()
        // .logout()
        // .permitAll();
        return http.build();

    }

    @Bean
    CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}