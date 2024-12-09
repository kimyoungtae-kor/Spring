package shop.youngatae.demo.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import shop.youngatae.demo.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService service;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest req,String str,Member member,HttpSession session){
        model.addAttribute("now",service.selectNow());
        req.setAttribute("name", "kil dong");
        model.addAttribute("str", str);
        model.addAttribute("member", member);

        
        return "hello";
    }
}
