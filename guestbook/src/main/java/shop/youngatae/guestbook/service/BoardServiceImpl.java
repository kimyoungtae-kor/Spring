package shop.youngatae.guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import shop.youngatae.guestbook.domain.dto.BoardDto;
import shop.youngatae.guestbook.domain.entity.Board;
import shop.youngatae.guestbook.repository.BoradRepository;

@Service
@Data
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoradRepository repository;
  @Override
  public BoardDto get(Long bno) {
    
    return toDto(repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board); 
    return board.getBno();
  }
    
}
