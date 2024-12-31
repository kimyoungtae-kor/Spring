package shop.youngatae.guestbook.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.BoardDto;
import shop.youngatae.guestbook.domain.dto.GuestbookDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.dto.PageResultDto;
import shop.youngatae.guestbook.domain.entity.Board;
import shop.youngatae.guestbook.domain.entity.Guestbook;
import shop.youngatae.guestbook.repository.BoradRepository;
import shop.youngatae.guestbook.repository.ReplyRepository;

@Service
@Data
@Log4j2
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoradRepository repository;
  @Autowired
  private ReplyRepository replyRepository;
  @Override
  public BoardDto get(Long bno) {
    
    return toDto((Object[])repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board); 
    return board.getBno();
  }

  @Override
  @Transactional
  public void remove(Long bno) {
    replyRepository.deleteByBoardBno(bno);
    repository.deleteById(bno);
  }

  @Override
  public PageResultDto<BoardDto, Object[]> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC,"bno"));
    // BooleanBuilder booleanBuilder = getSearch(dto);
    Page<Object[]> page = repository.searPage(dto.getType(),dto.getKeyword(),pageable);
    Function<Object[],BoardDto> fn = e -> toDto(e);
    PageResultDto<BoardDto,Object[]> resultDto = new PageResultDto<>(page,fn);
    return resultDto;
  }

  @Override
  public void modify(BoardDto dto) {
    log.info(repository.save(toEntity(dto)));
  }
  
  
}
