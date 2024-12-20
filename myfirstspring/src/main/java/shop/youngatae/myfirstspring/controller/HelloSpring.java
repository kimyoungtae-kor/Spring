package shop.youngatae.myfirstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloSpring {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "hello world";
    }
    
}