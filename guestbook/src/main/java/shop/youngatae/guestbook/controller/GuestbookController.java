package shop.youngatae.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.GuestbookDto;
import shop.youngatae.guestbook.domain.dto.GuestbookModifyDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.service.GuestbookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    @GetMapping("register")
    public void register() {
    
    }
    @PostMapping("register")
    public String register(GuestbookDto dto, RedirectAttributes rttr) {
      
        rttr.addFlashAttribute("msg",service.write(dto));
        return "redirect:list";
    }

    @GetMapping({"read","modify"})
    public void read(Long gno,Model model,@ModelAttribute("pageDto") PageRequestDto pageDto) {
        model.addAttribute("dto", service.read(gno));
    }
    
    @PostMapping("modify")
    public String postMethodName(GuestbookDto dto,PageRequestDto pageDto, RedirectAttributes rttr) {
        service.modify(dto);
        rttr.addAttribute("page",pageDto.getPage());
        return "redirect:list";
    }
    
    
    
    @GetMapping("remove")
    public String remove(Long gno) {
        service.remove(gno);
        return "redirect:/guestbook/list";
    }
    
    @PostMapping("remove2")
    public String remove2(GuestbookDto dto,PageRequestDto pageDto, RedirectAttributes rttr) {
        service.remove(dto.getGno());
        rttr.addAttribute("page",pageDto.getPage());
        return "redirect:list";
    }
    
    
    
    
}
