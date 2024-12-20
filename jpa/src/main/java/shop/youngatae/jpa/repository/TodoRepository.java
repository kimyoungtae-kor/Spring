package shop.youngatae.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.youngatae.jpa.domain.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity,Long>{

  
}