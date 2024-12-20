package shop.youngatae.myfirstspring.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.myfirstspring.mapper.MemberMapper;

@Service
@Log4j2
public class MemberService {
    private MemberMapper mapper;
    public String selectNow(){
        return mapper.selectnow();
    }
    
}