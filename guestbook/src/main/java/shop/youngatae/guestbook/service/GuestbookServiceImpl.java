package shop.youngatae.guestbook.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.GuestbookDto;
import shop.youngatae.guestbook.domain.dto.GuestbookListDto;
import shop.youngatae.guestbook.domain.dto.GuestbookModifyDto;
import shop.youngatae.guestbook.domain.dto.GuestbookViewDto;
import shop.youngatae.guestbook.domain.dto.GuestbookWriteDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.dto.PageResultDto;
import shop.youngatae.guestbook.domain.entity.Guestbook;
import shop.youngatae.guestbook.repository.GuestbookRepository;

@Service
@AllArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;
  @Override
  public GuestbookViewDto get(Long dto) {
    Optional<Guestbook> opt= repository.findById(dto);
    if(!opt.isPresent()){
      return null;
    }
    return new GuestbookViewDto(opt.get());
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
  public Long write(GuestbookDto dto) {
    Guestbook guestbook = toEntity(dto);
    log.info(guestbook);
    repository.save(guestbook);
    log.info(guestbook);
    // repository.save(dto.toEntity());
    // repository.save(toEntity())
    // toEntity(dto)
    return guestbook.getGno();
  }



  @Override
  public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC,"gno"));
    Page<Guestbook> page = repository.findAll(pageable);
    // Function<Guestbook,GuestbookDto> fn = e -> toDto(e);
    PageResultDto<GuestbookDto,Guestbook> resultDto = new PageResultDto<>(page, e -> toDto(e));
    return resultDto;
  }

  
  
}