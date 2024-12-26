package shop.youngatae.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.service.GuestbookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Log4j2
@RequestMapping("guestbook")
public class GuestbookController {
    @Autowired
    private GuestbookService service;
    @GetMapping({"/","list",""})
    public String list(Model model,PageRequestDto dto) {
      // log.info("list");
      model.addAttribute("result", service.list(dto));
      return "/guestbook/list";
    }
    
}
