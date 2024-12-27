package shop.youngatae.guestbook.aop;

import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class ControllerLogging {
  @Before("execution(* shop.youngatae.guestbook.controller..*(..))")
  public void log(JoinPoint jp){
    String className = jp.getTarget().getClass().getSimpleName();
    String methodNmae = jp.getSignature().getName();
    Object[] args = jp.getArgs();
    
    String paramTypes = String.join(", ",
    Stream.of(args)
          .map(a -> a != null ? a.getClass().getSimpleName() : "null")
          .toList());
    
    
    String str = String.format("%s.%s(%s)", className,methodNmae,paramTypes);
    log.info("======================Controller logger start====================");
    log.info(str);
    Stream.of(args).filter(o -> {

      String name = o.getClass().getName();
      return name.contains("shop.youngatae") || name.contains("java.lang");
      // return clazz != Model.class || clazz != RedirectAttributes.class;
      // Class<?> clazz = o.getClass();
    }).forEach(log::info);
    log.info("======================Controller logger end====================");
  }
}
