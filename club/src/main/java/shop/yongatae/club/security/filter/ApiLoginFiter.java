package shop.yongatae.club.security.filter;

import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.security.util.JWTUtil;

@Log4j2
public class ApiLoginFiter extends AbstractAuthenticationProcessingFilter{
  private JWTUtil jwtUtil;
  public ApiLoginFiter(String defaultFilterProcessUrl,JWTUtil jwtUtil){
    super(defaultFilterProcessUrl);
    this.jwtUtil = jwtUtil;
  }
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    log.info("================= attemptAuthentication()=======");
    String email = request.getParameter("email");
    String pw = "1234";
    log.info("email :" + email);
    log.info("pw :"+pw );
    // if(email == null){
    //   throw new BadCredentialsException("email cannotbe null");
    // }
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pw);
    Authentication authentication = getAuthenticationManager().authenticate(authenticationToken);
    log.info(authentication.getPrincipal());
    return authentication;
  }
  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
   log.info(authResult.getName());
   log.info(authResult);
   String email = authResult.getName();
   try{
    String token = jwtUtil.generateToken(email);
    response.setContentType("text/plain");
    response.getOutputStream().write(token.getBytes());
    log.info("================api login success==============");
   }catch(Exception e){

   }
  //  SecurityContextHolder.getContext().setAuthentication(authResult);
    // super.successfulAuthentication(request, response, chain, authResult);

  }

  
  
}
