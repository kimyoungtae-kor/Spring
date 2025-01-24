package shop.youngatae.chating.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.youngatae.chating.entity.Student;
import shop.youngatae.chating.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class StudentController {
  private StudentService studentService;

  @PostMapping("register")
  public void register(@RequestBody Student student){
    studentService.register(student);
  }

  @GetMapping("students")
  public List<Student> list() {
      return studentService.list();
  }

  @GetMapping("students/{no}")
  public Student get(@PathVariable Long no) {
      return studentService.get(no).orElse(null);
  }
  
  
  
}