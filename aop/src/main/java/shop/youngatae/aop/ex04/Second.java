package shop.youngatae.aop.ex04;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Second {
    public void one(){
        log.info("Second.one()");
    }
    public void two(){
        // log.info("first.two()");
        log.info("Second.two()");
    }
}
