package shop.youngatae.aop.ex05;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Seasoning implements MethodBeforeAdvice {

    @Override
    public void before(@Nullable Method method, Object[] args, Object target) throws Throwable {
        log.info("넌누구냐 :::::" +target);
        log.info("염지를 한다.");
    }

}
