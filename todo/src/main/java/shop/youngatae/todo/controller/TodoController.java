package shop.youngatae.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.todo.dto.TodoWriteDto;
import shop.youngatae.todo.service.TodoService;


@Controller
// @AllArgs
@Log4j2
public class TodoController {
  @Autowired
  TodoService service;
  @GetMapping("todos")
  public String list(Model model) {
    model.addAttribute("todos",service.list());
      return "todo-list";
  }
  @PostMapping("todos")
  public String write(TodoWriteDto dto) {
      log.info(dto);
      service.write(dto);
      return "redirect:todos";
  }
  
}
