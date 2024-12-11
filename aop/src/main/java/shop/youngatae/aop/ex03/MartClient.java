package shop.youngatae.aop.ex03;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.aop.ex02.Chicken;
import shop.youngatae.aop.ex02.adv.Packaging;
import shop.youngatae.aop.ex03.adv.ThrowLog;

@Log4j2
public class MartClient {
    public static void main(String[] args) {
        // 1. Proxy Factory 생성
        ProxyFactory factory = new ProxyFactory();
        // 2. target을 MartImpl로 지정
        // Mart mart = new MartImpl();
        factory.setTarget(new MartImpl());
        // 3. ex02의 packaging을 advice로 지정
        factory.addAdvice(new Packaging());
        // 4. ex03의 ThrowLog를 advice로 지정
        factory.addAdvice(new ThrowLog());
        
        // 5. proxy객체 생성 후 getProduct 호출
        Mart mart2 = (Mart)factory.getProxy();
        
        try{
            mart2.getProduct("선풍기2");
        }catch(Exception e){
            log.error(e.getMessage());
        }

        
       
    }
}
