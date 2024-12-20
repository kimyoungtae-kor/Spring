package shop.youngatae.myfirstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.youngatae.myfirstspring.service.MemberService;


@Controller
@RequestMapping("member")
public class MemberControoler {
    @Autowired
    private MemberService service;
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("now", service.selectNow());
        return "hello";
    }
    
    
}