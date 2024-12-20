package shop.youngatae.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
// @AllArgs
@Log4j2
public class controller {
  @GetMapping("todos")
  public String list(Model model) {
    model.addAddAttribute("todos",service.list());
      return "todo-list";
  }
  @PostMapping("todos")
  public String write(TodoWriteDto dto) {
      log.info(dto);
      service.write(dto);
      return "redirect:todos";
  }
  
}
