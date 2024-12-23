package shop.youngatae.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.youngatae.jpa.dto.TodoListDto;
import shop.youngatae.jpa.repository.TodoRepository;

@AllArgsConstructor
@Service
public class TodoService {
  private final TodoRepository repository;
  // 목록조회
  public List<TodoListDto> list(){
    return repository.findAll().stream().map(TodoListDto::new).toList();
  }
  // 등록
  public void write(TodoWriteDto dto){
    repository.save(dto.toEntity());
  }
  // 삭제

}
