package shop.yongatae.club.security;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SecurityTests {
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Test
  public void testEncode(){
    log.info(passwordEncoder);
    log.info(passwordEncoder.getClass().getName());

    String pw = "12345";
    String encode = passwordEncoder.encode(pw);
    log.info(pw);
    log.info(encode);
    //$2a$10$VrDrWYocCBj9F0fgwd8zsOTatIoYUFZrLjcg297YC5UZJCXOldzaq
    //$2a$10$XkCgJG3XD7AF7DqOsUZ9TuUiC5kXe.9ZHfqWTmbiXTGByJ843Zno2

    //matches로 인증코드가 맞는지 확인하고 탈퇴,등록등등 진행
    assertTrue(passwordEncoder.matches(pw, "$2a$10$XkCgJG3XD7AF7DqOsUZ9TuUiC5kXe.9ZHfqWTmbiXTGByJ843Zno2")); 
    assertTrue(passwordEncoder.matches(pw, "$2a$10$VrDrWYocCBj9F0fgwd8zsOTatIoYUFZrLjcg297YC5UZJCXOldzaq"));
  }
}
