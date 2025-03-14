package shop.yongatae.club.security.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthMemberDto extends User implements OAuth2User{
  private Long mno;
  private String email;
  private String name;
  private Boolean fromSocial;
  private String pw;
  
  //get Attrivbutes의 속성
  private Map<String,Object> attr;

  //oauth2 호출 생성자
  public AuthMemberDto(String username,String password,Long mno,Boolean fromSocial,String name,Collection<? extends GrantedAuthority> authorities
  ,Map<String,Object>attr){
    this(username, password, mno, fromSocial, name, authorities);
    this.attr = attr;
  }
  // security 자체로그인 호출 생성자
  public AuthMemberDto(String username,String password,Long mno,Boolean fromSocial,String name,Collection<? extends GrantedAuthority> authorities){
    super(username, password, authorities);
    this.email = username;
    this.fromSocial = fromSocial;
    this.mno = mno;
    this.name = name;
    pw = password;
  }

  @Override
  public Map<String, Object> getAttributes() {
    
    return attr;
  }
  
}
