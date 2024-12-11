package shop.youngatae.aop.ex02;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Bbq {
    public void cook(String source){
        log.info("바베큐룰 굽는다");
    }
}
