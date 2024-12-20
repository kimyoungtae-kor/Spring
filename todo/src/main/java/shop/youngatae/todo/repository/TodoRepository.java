package shop.youngatae.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.youngatae.todo.domain.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity,Long>{

  
}