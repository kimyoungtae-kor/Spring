package shop.youngatae.jpa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.youngatae.jpa.domain.TodoEntity;

@Getter
@Setter
@ToString
public class TodoListDto {
  
  private String task;
  
  public TodoWriteDto(TodoEntity entity) {
    
    task = entity.getTask();
    
  }
  // dto >> entity
  public TodoEntity todoEntity(){
    
    return TodoEntity.builder().task(task).build();
  }
  // write
}
