package shop.yongatae.club.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import shop.yongatae.club.security.handler.LoginSuccessHandler;

@Configuration
@EnableMethodSecurity
public class SecurityConfig{
  @Autowired
  private UserDetailsService detailsService;
  @Bean
  public PasswordEncoder passwordEncoder(){
    //salt
    //스트렝스 (힘)
    return new BCryptPasswordEncoder();
  };
  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
          .csrf(csrf -> csrf.disable())// CSRF 비활성화 (필요에 따라 활성화)
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/sample/all").permitAll() // `/public/` 경로는 인증 없이 접근 가능
              .requestMatchers("/sample/member").hasRole("USER") // `/public/` 경로는 인증 없이 접근 가능
              .requestMatchers("/api/**").permitAll() 
              // .requestMatchers("/sample/admin").hasRole("ADMIN") // `/public/` 경로는 인증 없이 접근 가능
              .anyRequest().authenticated() // 나머지는 인증 필요
          )
          // .formLogin(f -> f
          // .loginPage("/member/signin")
          // .permitAll()
          // ) // 기본 로그인 폼 활성화
          .formLogin(f -> f.permitAll()) // 기본 로그인 폼 활성화
          .logout(l -> l.logoutUrl("/member/signout"))
          .oauth2Login(o -> o.successHandler(loginSuccesHandler()))
          .rememberMe(r -> r.tokenValiditySeconds(60 * 60 * 24 * 14).userDetailsService(detailsService).rememberMeCookieName("remember-id"));
          // .formLogin(null)
          
      return http.build();
  }
  @Bean
  public LoginSuccessHandler loginSuccesHandler(){
    return new LoginSuccessHandler(passwordEncoder());
  }
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
    return authenticationConfiguration.getAuthenticationManager();
  }
}
