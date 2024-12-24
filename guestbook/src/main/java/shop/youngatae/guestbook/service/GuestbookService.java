package shop.youngatae.guestbook.service;

import java.util.List;

import shop.youngatae.guestbook.domain.dto.GuestbookListDto;
import shop.youngatae.guestbook.domain.dto.GuestbookModifyDto;
import shop.youngatae.guestbook.domain.dto.GuestbookViewDto;
import shop.youngatae.guestbook.domain.dto.GuestbookWriteDto;

public interface GuestbookService {
  void write(GuestbookWriteDto dto);
  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  List<GuestbookListDto> list();
  GuestbookViewDto get(Long dto);
}
