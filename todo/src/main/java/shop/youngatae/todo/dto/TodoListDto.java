package shop.youngatae.todo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.youngatae.todo.domain.TodoEntity;

@Getter
@Setter
@ToString
public class TodoListDto {
  private Long id;
  private String task;
  private boolean done;
  public TodoListDto(TodoEntity entity) {
    id = entity.getId();
    task = entity.getTask();
    done = entity.isDone();  
  }
  // dto >> entity
  public TodoEntity todoEntity(){
    
    return TodoEntity.builder().id(id).task(task).done(done).build();
  }
  // write
}
