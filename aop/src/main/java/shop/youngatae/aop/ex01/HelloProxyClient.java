package shop.youngatae.aop.ex01;

import java.lang.reflect.Proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HelloProxyClient {
    public static void main(String[] args) {
        Class[] arrClass = {HelloWorld.class};
        HelloWorldHandler<HelloWorld> handler = new HelloWorldHandler<>(new HelloWorldimpl());
        

        HelloWorld helloWorld = new HelloWorldimpl();
        helloWorld.sayHello("개똥이");
        log.info("========================================");
        HelloWorld proxy = 
        (HelloWorld)Proxy.newProxyInstance(HelloWorld.class.getClassLoader(),
        arrClass, handler);
        proxy.sayHello("새똥이");
        log.info(proxy);
    }
}
