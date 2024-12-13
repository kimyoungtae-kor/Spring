<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>더조은</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="icon" href="images/unnamed.png" types="images/xhr">
   <!-- bootstrap  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
   <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js" integrity="sha512-7Pi/otdlbbCR+LnW+F7PwFcSDJOuUJB3OxtEHbg4vSMvzvJjde4Po1v4BR9Gdc9aXNUNFVUY+SK51wWT8WF0Gg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
   <!-- jquery -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
   <!-- bxslider -->
   <script src="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.js"></script>
   <!-- font-awesome -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <style>
    
    </style>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment-with-locales.min.js" integrity="sha512-4F1cxYdMiAW98oomSLaygEwmCnIP38pb4Kx70yQYqRwLVCs3DbRumfBq82T08g/4LJ/smbFGFpmeFlQgoDccgg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
    <div class="wrap">
       <jsp:include page="../common/header.jsp"></jsp:include>

        <main class="container">
          <div class="container clearfix p-2">
               
                <h2 class="text-center fw-bold p-3">View</h2>
            </div>
            <div class="my-3 col-md-9 mx-auto">
                <label for="title" class="form-label mt-3"><i class="fa-solid fa-heading text-danger"></i><b> 제목</b></label>
                <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title}" disabled>

                <label for="content" class="form-label  mt-3"><i class="fa-solid fa-pen text-danger"></i></i><b> Content</b></label>
                <textarea class="form-control" rows="20" id="content" name="content" disabled>${post.content}</textarea>

                <label for="writer" class="form-label mt-3"><i class="fa-solid fa-user-pen text-danger"></i><b> 작성자</b></label>
                <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${post.writer}" disabled>

                <label for="regdate" class="form-label mt-3"><i class="fa-solid fa-clock text-danger"></i><b> 작성일</b></label>
                <input type="text" class="form-control" id="regdate" placeholder="regdate" name="regdate" value="${post.regdate}" disabled>

                <label for="updatedate" class="form-label mt-3"><i class="fa-regular fa-clock text-danger"></i><b> 수정일</b></label>
                <input type="text" class="form-control" id="updatedate" placeholder="updatedate" name="updatedate" value="${post.updatedate}" disabled>
             	
             	<label class="form-label mt-3"><i class="fa-regular fa-file"></i><b> ATTACH</b><br></label><br>
                <label for="attach" class="form-label"><span class="btn btn-primary">파일 첨부</span></label>
                <span class="mx-2 attach-count-txt"></span>
                <input type="file" id="attach"name="files" class="d-none" multiple>
  			<ul class="list-group attach-result">
  				<c:if test="${empty post.attachs}" >
  				 <li class="list-group-item">첨부파일이 없습니다.</li>
  				</c:if>
  				<c:forEach items="${post.attachs}" var="a">
 			  <li class="list-group-item"><a href="${cp}download?uuid=${a.uuid}&origin=${a.origin}&path=${a.path}">${a.origin}</a></li>
 			  </c:forEach>
			</ul>



              <!-- 내 댓글 구간 -->
              <div class="clearfix mt-5 mb-2">
                <label class="form-label float-start"><i class="fa-regular fa-comment-dots text-danger"></i> <b>My Reply</b><br></label>
            </div>
            <ul class="list-group small my-replies my-2" data-bs-theme="dark">
                <li class="list-group-item" data-rno="38">
                    <p class="fw-bold mt-3 text-truncate">haha</p>
                    <div class="clearfix">
                        <span class="float-start">aaaa</span>
                        <span class="float-end small">하루 전</span>
                        <a class="float-end small text-danger mx-2 btn-reply-remove" href="#">삭제</a>
                    </div>
                </li>
            </ul>


            <div class="clearfix mt-5 mb-2">
                <label class="form-label float-start"><i class="fa-regular fa-comment-dots"></i><b> 댓글</b><br></label>
                <button type="button" class="btn btn-primary float-end btn-sm" id="btnReplyWrite">write reply</button>
            </div>
            <ul class="list-group small replies">
                
            </ul>
            <div class ="d-grid my-3">
                <button class="btn btn-primary btn-bolck btn-more-reply">댓글 더보기</button>
            </div>
			 </div>

              <hr>
              <div class ="text-center my-5">
              	<c:if test="${post.writer == member.id}">
                <a href="modify?pno=${post.pno}&${cri.qs2}" class="btn btn-warning">수정</a>
                <a href="remove?pno=${post.pno}&${cri.qs2}" class="btn btn-danger" onclick="return confirm('정말 삭제 하시겠습니까?')">삭제</a>                              
                </c:if>
                <a href="list?${cri.qs2}" class="btn btn-primary">목록</a>
              </div>
             <!-- The Modal -->
            <div class="modal fade" id="replyModal">
                <div class="modal-dialog">
                <div class="modal-content">
            
                    <!-- Modal Header -->
                    <div class="modal-header">
                    <h4 class="modal-title">댓글</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
            
                    <!-- Modal body -->
                    <div class="modal-body">
                        <label for="replyContent" class="mb-2">content</label>
                        <input type="text" class="form-control mb-3" id="replyContent">
                    
                        <label for="replyWriter" class="mb-2">writer</label>
                        <input type="text" class="form-control mb-3" id="replyWriter" value="${member.id}">
                    </div>
            
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <div>
                        <button type="button" class="btn btn-primary" id="btnReplyWriteSumbit">작성</button>
                    <button type="button" class="btn btn-warning" data-bs-dismiss="modal" id="btnReplyModifySumbit">수정</button>
                    <button type="button" class="btn btn-primary" id="btnReplyDeleteSumbit">삭제</button>
                    </div>
                    <button type="button" class="btn btn-danger btn-secondary" data-bs-dismiss="modal">닫기</button>
                    </div>
            
                </div>
                </div>
            </div>
  
      </div>
        </main>
		<script src="${cp}js/reply.js"></script>
        <script>
			moment.locale('ko');            
            const pno = '${post.pno}';

            // replyService.write({content : 'aaaa'})

            function list(cri,myOnly) {
                replyService.list(pno, cri, function(data) {
                    if(!data.list.length) {
                        $(".btn-more-reply")
                        .prop("disabled", true)
                        .text("댓글이 없습니다.")
                        .removeClass("btn-primary")
                        .addClass("btn-secondary");
                        return;
                    }
                    let str = "";
                    let myStr = "";
                    for(let i in data.list) {
                        str += makeLi(data.list[i])
                    }
                    for(let i in data.myList) {
                        myStr += makeLi(data.myList[i])
                    }

                    if(myOnly != null){
                        return false;
                    }
                    $(".replies").append(str);
                    $(".my-replies").html(myStr);
                    // 추가 css 작업
                    $(".my-replies .text-secondary, .my-replies .text-black").removeClass("text-secondary text-black")
                });
            }
            list();
           

        function makeLi(reply){
            return `<li class="list-group-item" data-rno="\${reply.rno}">

                <p class="text-black fw-bold my-3 text-truncate">\${reply.content}</p>
                <div class="clearfix text-secondary">
                    <span class="float-start">\${reply.writer}</span>
                    
                    <span class="float-end small">\${moment(reply.regdate,'yyyy/MM/DD-HH:mm:ss').fromNow()}</span>
                    <a type="button" class="float-end  small text-danger mx-2 btn-reply-remove" id = "deletebtn" href="#">삭제</a>
                </div>
            </li>`;
        }
        //li 클릭시 이벤트
        $(".replies, .my-replies").on("click", "li",function(){
            console.log($(this).data("rno"));
            const rno = $(this).data("rno");
            $("#replyModal").modal("show");
            replyService.view(rno, function(data){
                console.log(data);
                $("#replyModal").find(".modal-footer div button").hide().filter(":gt(0)").show();
                $("#replyModal").data("rno",rno).modal("show");
                $("#replyContent").val(data.content);
                $("#replyWriter").val(data.writer);
               



            })
        });

        // 삭제 버튼 클릭시 이벤트
        // $(".replies").on("click",$("#deletebtn"),function(){
        //     event.preventDefault();
        //     if(!confirm("삭제 하겠습니까?")){
        //         return;
        //     }
        //     const rno = $(this).closest("li").data("rno");
        //     replyService.remove(rno,function(data){
        //         alert("삭제 되었습니다");
        //         list();
        //     });
        // });

        $(".replies, .my-replies").on("click", "li .btn-reply-remove",function(){
            
            if(!confirm("삭제 하겠습니까?")){
                return false;
            }
            const $li = $(this).closest("li");
            const rno = $li.data("rno");
            replyService.remove(rno,function(data){
                alert("삭제 되었습니다");

                $li.remove();

                list(undefined, true);
                
            });
            return false;
        });

        // 댓글 더보기 버튼 클릭시
        $(".btn-more-reply").click(function() {
                const lastRno = $(".replies li:last").data("rno");
                list({lastRno});
            });

        //댓글쓰기 버튼 클릭시
        $("#btnReplyWrite").click(function(){

                $("#replyModal").find(".modal-footer div button").hide().filter(":eq(0)").show();
                $("#replyModal").modal("show");
                $("#replyContent").val("");
                $("#replyWriter").val("${member.id}");
                list(undefined, true);
        });
        $(function(){
			//댓글수정
            $("#btnReplyModifySumbit").click(function(){

                const rno = $("#replyModal").data("rno");
                const content = $("#replyContent").val();
                const reply = {rno,content};
                console.log(rno);
                replyService.modify(reply,function(data){
                    $("#replyModal").modal("hide");
                    const $li = $(`.replies li[data-rno='\${rno}'] p`).text(content);
                    list(undefined,true);
                    // location.reload();
                });
            });
            $("#btnReplyWriteSumbit").click(function(){
                const writer = $("#replyWriter").val();
                const content = $("#replyContent").val();
                const reply = {pno,writer,content};
                console.log("ffff");
                replyService.write(reply,function(data){
                    $("#replyModal").modal("hide");
                    list();
                    list(undefined,true);
                    // location.reload();
                });
            });
          //댓글삭제
            $("#btnReplyDeleteSumbit").click(function(){
                const rno = $("#replyModal").data("rno");
                const reply = rno;
                console.log(rno);
                const $li = $(`.replies li[data-rno='\${rno}']`);
                replyService.remove(reply,function(data){
                    $("#replyModal").modal("hide");
                    $li.remove();
                    // location.reload();
                });
            });
        });
        </script>
		
        <footer class="bg-warning text-center p-4 my-5">
            <address>서울특별시 구로구 디지털로 306 대룡포스트 2차 2층 더조은 아카데미 204호</address>
            <p>All rights reserved &copy; copyright.</p>
        </footer>
    </div>
</body>
</html>