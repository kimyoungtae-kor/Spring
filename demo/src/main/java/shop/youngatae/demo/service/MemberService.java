package shop.youngatae.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.demo.mapper.MemberMapper;

@Service
@Log4j2
public final class MemberService {
    @Autowired
    // @Resource
    
    private MemberMapper mapper;
    public String selectNow(){
        
        return mapper.selectNow();
    }
}
