package shop.youngatae.todo.dto;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.youngatae.todo.domain.TodoEntity;

@Getter
@Setter
@ToString
public class TodoWriteDto {
  
  private String task;
  public TodoWriteDto() {

  }
  
  public TodoWriteDto(TodoEntity entity) {
    
    task = entity.getTask();
    
  }
  // dto >> entity
  public TodoEntity todoEntity(){
    
    return TodoEntity.builder().task(task).build();
  }
  // write
}
