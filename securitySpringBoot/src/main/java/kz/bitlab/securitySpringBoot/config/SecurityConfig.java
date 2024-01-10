//package kz.bitlab.securitySpringBoot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//  @Bean
//  public CustomUserDetailsService userService() {
//    return new CustomUserDetailsService();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    var authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//
//    authenticationManagerBuilder
//        .userDetailsService(
//            userService())
//        .passwordEncoder(passwordEncoder());
//
//    http.csrf(AbstractHttpConfigurer::disable);
//
//    http.formLogin(flc -> flc.loginProcessingUrl("/entry")
//        .usernameParameter("username")
//        .passwordParameter("password")
//        .loginPage("/entry")
//        .defaultSuccessUrl("/", true)
//        .failureUrl("/entry?error=true"));
//
//    http.logout(logout -> logout.logoutUrl("/logout")
//        .logoutSuccessUrl("/entry"));
//
//    return http.build();
//  }
//}

