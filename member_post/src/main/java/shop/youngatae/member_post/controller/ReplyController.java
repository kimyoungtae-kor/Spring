package shop.youngatae.member_post.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.dto.ReplyCri;
import shop.youngatae.member_post.service.ReplyService;
import shop.youngatae.member_post.vo.Member;
import shop.youngatae.member_post.vo.Reply;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("reply")
@Log4j2
@AllArgsConstructor
@Tag(name = "reply", description = "댓글 관리 API를 처리합니다.")
public class ReplyController {
  private ReplyService service;
  //목록조회
  //OPtional == 포장
    @GetMapping({"list/{pno}","list/{pno}/{lastRno}","list/{pno}/{lastRno}/{amount}"})
    public Map<?,?> list(@PathVariable(required = false,value = "pno") Long pno,@SessionAttribute(required = false,value="member") Member member,ReplyCri cri
    ,@PathVariable(required = false,value = "lastRno") Optional<Long> lastRno,@PathVariable(required = false,value = "amount") Optional<Integer> amount) {
      // cri.setAmount(amount.orElseGet(()->10));
      cri.setAmount(amount.orElse(10));
      cri.setLastRno(lastRno.orElse(0L));
      log.info(cri);
      log.info(service.selectList(pno, cri, member));  
      return service.selectList(pno, cri, member);
    }

    //단일조회
    @Operation(summary = "reply single selecdt",description = "@PathVariable인 rno값을 입력 받고 해당댓을을 json으로 리턴")
    @GetMapping("selectone/{rno}")
    public ResponseEntity<?> selectone(@PathVariable("rno") Long rno) {
      log.info(rno);  
      log.info(service.findBy(rno));
        return new ResponseEntity<>(service.findBy(rno),HttpStatus.OK);
    }
    
    //등록
    @PostMapping
    @Operation(
      summary = "댓글 작성", 
      description = "댓글 작성을 위해 필요한 값을 전달받음. content, writer, 게시글 번호",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "작성 성공",
              content = @Content(schema = @Schema(implementation = String.class))
          ),
          @ApiResponse(
              responseCode = "500", 
              description = "작성 실패"
          )
      }
  )
    public ResponseEntity<?> write(@RequestBody Reply reply){
      log.info(reply);
      return service.write(reply)>0?ResponseEntity.ok().body("success"):ResponseEntity.internalServerError().build();
    }
    //수정
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Reply reply) {
      log.info(service.modify(reply));
      log.info(reply + ":::::::::::");
        return ResponseEntity.ok().body("success");
    }

    // 삭제
    @DeleteMapping("{rno}")
    public ResponseEntity<?> delete(@PathVariable Long rno){
      service.remove(rno);
      return ResponseEntity.ok().body("success");
    }
}
