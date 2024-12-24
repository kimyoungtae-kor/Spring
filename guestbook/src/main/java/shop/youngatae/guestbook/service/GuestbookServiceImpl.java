package shop.youngatae.guestbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.youngatae.guestbook.domain.dto.GuestbookListDto;
import shop.youngatae.guestbook.domain.dto.GuestbookModifyDto;
import shop.youngatae.guestbook.domain.dto.GuestbookViewDto;
import shop.youngatae.guestbook.domain.dto.GuestbookWriteDto;
import shop.youngatae.guestbook.domain.entity.GuestbookEntity;
import shop.youngatae.guestbook.repository.GuestbookRepository;

@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;
  @Override
  public GuestbookViewDto get(Long dto) {
    Optional<GuestbookEntity> opt= repository.findById(dto);
    if(!opt.isPresent()){
      return null;
    }
    return new GuestbookViewDto(opt.get());
  }

  @Override
  public List<GuestbookListDto> list() {
    
    return repository.findAll().stream().map(GuestbookListDto::new).toList();
  }

  @Override
  public void modify(GuestbookModifyDto dto) {
    repository.save(dto.toEntity());    
  }

  @Override
  public void remove(Long gno) {
    repository.deleteById(gno);
    
  }

  @Override
  public void write(GuestbookWriteDto dto) {
    repository.save(dto.toEntity());
    
  }
  
}
