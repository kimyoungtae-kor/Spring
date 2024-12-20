package shop.youngatae.mysecondpratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.youngatae.mysecondpratice.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;






@Controller
@RequestMapping("/posts")


public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public String listPosts(Model model) {
        model.addAttribute("Post", postService.getAllPosts());
        return "post/list";
    }
    
}