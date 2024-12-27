package shop.youngatae.todo.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import shop.youngatae.todo.domain.TodoEntity;
import shop.youngatae.todo.dto.TodoListDto;
import shop.youngatae.todo.dto.TodoWriteDto;
import shop.youngatae.todo.repository.TodoRepository;

@AllArgsConstructor
@Service
public class TodoService {
  private TodoRepository repository;
  private EntityManager manager;
  @PostConstruct
  public void init(){
    repository.saveAll(Stream.of(TodoEntity.builder().task("첫일").build(),
    TodoEntity.builder().task("둘일").build(),
    TodoEntity.builder().task("셋일").build()).toList());
  }

  // 목록조회
  public List<TodoListDto> list(){
    // return repository.findAll().stream().map(TodoListDto::new).toList();
    // return repository.findAll(Sort.by(Direction.DESC,"id")).stream().map(TodoListDto::new).toList();
    // return repository.findByOrderByTaskDesc().stream().map(TodoListDto::new).toList();
    // return repository.findByOrderByTaskDescIdAsc().stream().map(TodoListDto::new).toList();
    return repository.findAll(Sort.by(Order.desc("task"),Order.asc("id"))).stream().map(TodoListDto::new).toList();
  }
  // 등록
  public void write(TodoWriteDto dto){
    repository.save(dto.todoEntity());
  }
  // 삭제
  public void remove(Long id){
    // repository.delete(TodoEntity.builder().id(id).build());
    repository.deleteById(id);
  }

  @Transactional
  public void modify(Long id){
    Optional<TodoEntity> entity = repository.findById(id);
    entity.ifPresent(e -> {e.setDone(true); repository.save(e);});
    // repository.save(TodoEntity.builder().id(id).done(true).task("직접준거").build());
    repository.updateTodoDoneById(id);
  }

  @Transactional
  public void modify2(Long id){
    // Optional.of(manager.find(TodoEntity.class, id)).ifPresent(e -> e.setDone(true));
    manager.find(TodoEntity.class, id).setDone(true);
  }
}
