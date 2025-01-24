package shop.youngatae.chating.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import shop.youngatae.chating.entity.Student;
import shop.youngatae.chating.repository.StudentRepository;

@Service
@AllArgsConstructor
@Transactional
public class StudentService {
  @Autowired
  private final StudentRepository repository;

  public void register(Student student){
    repository.save(student);
  } 
  
  public List<Student> list(){
    return repository.findAll();
  }
  public Optional<Student> get(Long no){
    return repository.findById(no);
  }
}
