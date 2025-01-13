package shop.yongatae.club.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.security.util.JWTUtil;

@SpringBootTest
@Log4j2
public class JWTTests {
  private JWTUtil jwtUtil;
  @BeforeEach
  public void testBefore() {
    log.info("testBefore.....");
    jwtUtil = new JWTUtil();
  }
  @Test
  public void testCreate() throws Exception{
    String email = "user100@youngatae.shop";
    String str = jwtUtil.generateToken(email);
    log.info(str);
  }
  @Test
  public void testEncode() throws Exception{
    String email = "user100@youngatae.shop";
    String token = jwtUtil.generateToken(email);
    Thread.sleep(5000);
    String resultEmail = jwtUtil.validateExtract(token);
    log.info("========================"+resultEmail);
    assertEquals(email, resultEmail);
  }  
}
