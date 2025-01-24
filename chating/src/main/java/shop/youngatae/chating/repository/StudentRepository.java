package shop.youngatae.chating.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.youngatae.chating.entity.Student;

public interface StudentRepository extends MongoRepository<Student,Long>{
  
  
}
