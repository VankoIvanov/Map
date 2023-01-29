package com.example.map.security;

//import com.example.map.security.jwt.AuthEntryPointJwt;
//import com.example.map.security.jwt.AuthTokenFilter;
import com.example.map.security.jwt.AuthEntryPointJwt;
import com.example.map.security.jwt.AuthTokenFilter;
import com.example.map.security.oauth2.CustomerOAuth2UserService;
import com.example.map.security.oauth2.OAuth2LoginSuccessHandler;
import com.example.map.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;


    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter(){
        return new AuthTokenFilter();
    }

//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsServiceImpl userDetailsService)
//            throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder())
//                .and()
//                .build();
//    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
        http
                .csrf().and()//.disable()
//                .authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
                //.csrf(csrf->csrf.disable())
                .authorizeHttpRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/", "/users/login", "/users/register", "/about","/api/auth/signin", "/api/auth/signup","/map", "/map/pedestriansection/**", "/questions/sidewalk").permitAll()
                .requestMatchers("/admin/**").hasRole("ROLE_ADMIN")
                .requestMatchers("/users/**")
                .hasAnyRole("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                //.loginPage("/api/auth/signin")
                .usernameParameter("username")
                .passwordParameter("password")
                //.permitAll()
                .defaultSuccessUrl("/")
                .failureForwardUrl("/users/login-error")
                .and()
                .oauth2Login()
                .loginPage("/users/login")
                .userInfoEndpoint()
                .userService(customerOAuth2UserService)
                .and()
                .successHandler(oAuth2LoginSuccessHandler)
                .and()
                .logout()
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().cors().and().csrf().disable();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Autowired
    private CustomerOAuth2UserService customerOAuth2UserService;

    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
}
