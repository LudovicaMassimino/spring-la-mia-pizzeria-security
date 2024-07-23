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

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http
    // .authorizeHttpRequests(requests -> requests (ESPRESSIONE LAMBDA)
    // .requestMatchers("/").hasAuthority("ADMIN"))
    // // .anyRequest().permitAll())
    // .formLogin(form -> form
    // .loginPage("/login") // specifica la tua pagina di login
    // .permitAll())
    // .logout(logout -> logout
    // .permitAll())
    // .exceptionHandling(exceptions -> exceptions
    // .accessDeniedPage("/403") // specifica la tua pagina di accesso negato
    // );
    // return http.build();

    // }

    // METODO DEPRECATO

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests()
                // .requestMatchers("/").hasAuthority("USER")
                .requestMatchers("/**").hasAuthority("ADMIN")
                // .requestMatchers("/** */").permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .and().exceptionHandling();

        return http.build();
    }

    // Accesso a
    // localhost negatoNon
    // disponi dei diritti dell'utente per
    // visualizzare questa
    // pagina.HTTP ERROR 403

    // .formLogin()
    // .loginPage("/login")
    // .defaultSuccessUrl("/home", true)
    // .permitAll()
    // .and()
    // .logout()
    // .permitAll();

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