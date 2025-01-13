package shop.yongatae.club.security.util;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTUtil {

  private String secretKey = "youngatae12345678youngatae12345678youngatae12345678";

  // private long expire = 60 * 24 * 30;
  private SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
  public String generateToken(String content) throws Exception{
    return Jwts.builder().issuedAt(new Date())
    .expiration(Date.from(ZonedDateTime.now().plusMonths(1L).toInstant()))
    .claim("sub",content)
    // .signWith(secretKey,SignatureAlgorithm.HS256)
    .signWith(key)
    .compact();
  }
  public String validateExtract(String tokenStr){
    String contentVlaue = null;
    try{
      // DefaultJws<Claims> defaultJws = Jwts.parser().setSigningKey(secretKey.getBytes("utf-8")).build().parseClaimsJws(tokenStr).accept();
      Jws<Claims> defaultJws = Jwts.parser().verifyWith(key).build().parseSignedClaims(tokenStr);
      Claims claims = defaultJws.getPayload();
      log.info(claims.getSubject());
      log.info(claims.getIssuer());
      log.info(claims.getIssuedAt());
      log.info(claims.getExpiration());
      contentVlaue = claims.getSubject();
    }catch(Exception e){
      e.printStackTrace();
    }
    return contentVlaue;
  }
}