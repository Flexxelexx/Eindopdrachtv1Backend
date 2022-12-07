package com.example.eindopdrachtbackendv1.Security;

import com.example.eindopdrachtbackendv1.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig  {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public SecurityConfig(JwtService service, UserRepository userRepos) {
        this.jwtService = service;
        this.userRepository = userRepos;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder encoder, UserDetailsService udService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(udService)
                .passwordEncoder(encoder)
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(this.userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeRequests()


                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.PUT,"/users").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()

                .antMatchers(HttpMethod.POST, "/upload").permitAll()
                .antMatchers(HttpMethod.GET, "/upload").permitAll()
                .antMatchers(HttpMethod.PUT,"/upload").permitAll()
                .antMatchers(HttpMethod.DELETE, "/upload").permitAll()
                .antMatchers(HttpMethod.PATCH, "/upload").permitAll()

                .antMatchers(HttpMethod.POST, "/portfolio").permitAll()
                .antMatchers(HttpMethod.GET, "/portfolio").permitAll()
                .antMatchers(HttpMethod.PUT,"/portfolio").permitAll()
                .antMatchers(HttpMethod.DELETE, "/portfolio").permitAll()
                .antMatchers(HttpMethod.PATCH, "/portfolio").permitAll()

                .antMatchers(HttpMethod.POST, "/fishingspot").permitAll()
                .antMatchers(HttpMethod.GET, "/fishingspot").permitAll()
                .antMatchers(HttpMethod.PUT,"/fishingspot").permitAll()
                .antMatchers(HttpMethod.DELETE, "/fishingspot").permitAll()
                .antMatchers(HttpMethod.PATCH, "/fishingspot").permitAll()

                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.PUT,"/users").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").permitAll()

                .antMatchers(HttpMethod.POST, "/rating").permitAll()
                .antMatchers(HttpMethod.GET, "/rating").permitAll()
                .antMatchers(HttpMethod.PUT,"/rating").permitAll()
                .antMatchers(HttpMethod.DELETE, "/rating").permitAll()
                .antMatchers(HttpMethod.PATCH, "/rating").permitAll()

                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/roles").hasAuthority("ADMIN")

                .antMatchers("/secret").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/users").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/rating").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/portfolio").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/fishingspot").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/upload").hasAnyAuthority("USER", "ADMIN")

                .and()
                .addFilterBefore(new JwtRequestFilter(jwtService, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
}
