package shop.youngatae.guestbook.service;


import shop.youngatae.guestbook.domain.dto.GuestbookDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.dto.PageResultDto;
import shop.youngatae.guestbook.domain.entity.Guestbook;

public interface GuestbookService {
  Long write(GuestbookDto dto);
  PageResultDto<GuestbookDto,Guestbook> list(PageRequestDto dto);
  void modify(GuestbookDto dto);
  void remove(Long gno);

  GuestbookDto read(Long gno);
  
  // GuestbookViewDto get(Long dto);

  //entity타입을 반환

  default Guestbook toEntity(GuestbookDto dto){
    return Guestbook.builder()
    .gno(dto.getGno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .writer(dto.getWriter())
    .build();
  }
//dto타입을반환
//이름은 to DTO
//entity >>>dto 변환 메서드 정의
  default GuestbookDto toDto(Guestbook entity){
    return GuestbookDto.builder()
    .gno(entity.getGno())
    .title(entity.getTitle())
    .content(entity.getContent())
    .writer(entity.getWriter())
    .regDate(entity.getRegDate())
    .modDate(entity.getModDate())
    .build();
  }
}
