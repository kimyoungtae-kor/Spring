package shop.yongatae.club.security.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.MemberRole;
import shop.yongatae.club.repository.MemberRepository;
import shop.yongatae.club.security.dto.AuthMemberDto;

@Service
@Log4j2
public class Oauth2UserDetailsService extends DefaultOAuth2UserService {

  @Autowired
  private MemberRepository repository;
  @Autowired
  private PasswordEncoder encoder;
  @Override
  @Transactional
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    log.info(userRequest);
    String clientName =userRequest.getClientRegistration().getClientName();
    Map<?,?> params = userRequest.getAdditionalParameters();
    OAuth2User oAuth2User = super.loadUser(userRequest);
    log.info(clientName);
    log.info(params);
    oAuth2User.getAttributes().forEach((k,v) -> {log.info(k); log.info(v);});

    String email = null;
    if(clientName.equalsIgnoreCase("google")){
      email = oAuth2User.getAttribute("email");
    }
    Member member = saveSocailMember(email);
    //authmember dto로 변환
      AuthMemberDto authMemberDto = new AuthMemberDto(member.getEmail(), member.getPassword(), member.getMno(), member.getFromSocial(), 
    member.getName(),member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.name())).toList(),oAuth2User.getAttributes());
    return authMemberDto;
  }
  @Transactional
  private Member saveSocailMember(String email){
    Member member = repository.findByEmailAndFromSocial(email, true);

    if(member != null){
      return member;
    }
    Member member2 = Member.builder()
    .email(email)
    .password(encoder.encode("1234"))
    .fromSocial(true)
    .build();
    member2.addMemberRole(MemberRole.USER);
    repository.save(member2);
    return member2;
  }
  
}
