
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <jsp:include page="head.jsp"/>
        
        <style>
          .popup{
            position: absolute;
            width: 420px;
            /* right: 800px; */
            left: calc(50% - 210px);
            top: 300px;
            display: none;
        }
        .popup p {
            margin: 0;
            background-color: skyblue;
            color: #eee;
        }
        .popup img {
            display: block;
        }
        .popup p input{
            vertical-align:middle;
        }
        .popup p a{
            float: right;
            text-decoration: none;
            color: #eee;
        }
        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
    <div class="wrap">
        <jsp:include page="header.jsp"/>
        <main class="container">
            <div class="row">
                <div class="col-md-9">
                    <div class="p-3">
                        <h1>index</h1>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="p-3 d-grid gap-2">
                  		<c:if test="${empty sessionScope.member}">
                        <a href="${cp}member/signin" class="btn btn-primary btn-block">로그인</a>
                        <div class="small clearfix">
                        <a href="${cp}member/signup" class="small float-start text-decoration-none">회원가입</a>
                        <a href="signup.html" class="small float-end text-decoration-none">아이디/비밀번호찾기</a>
                        </div>
                		</c:if>
                    	<c:if test="${not empty sessionScope.member}">
                    	<p><a href="${cp}member/mypage" class="text-decoration-none text-dark"><strong>${member.name}</strong>님 환영합니다</a></p>
                        <div class="small clearfix">
                            <a href="${cp}member/logout" class="small float-start text-decoration-none">로그아웃</a>
                            <a href="${cp}member/mypage" class="small float-end text-decoration-none">마이페이지</a>
                        </div>
                      	</c:if>
               
                    </div>
                </div>
            </div>


        </main>
            <div class="popup">
        <div>
            <img src="https://image.yes24.com/momo/scmfiles/AdvertFiles/202410/2578206_241014101146.jpg">
            <p class="clearfix">
                <span><label for="chbox">오늘은 그만 보기</label><input type="checkbox" id="chbox"></span>
                <a href="#">닫기</a>
            </p>
            
        </div>
    </div>
       <jsp:include page="footer.jsp"></jsp:include>
    </div>
    
    <script>
    
    
    
    // 하룻동안 보지 않기가 체크가 안되어 있으실 할일
    if(!$.cookie("layer")){
		$(".popup").show();
    }
    
    
    //레이어 팝업내의 닫기 버튼 클릭시 이벤트
    	$(".popup a").click(function(){
    		event.preventDefault();
    		const checked = $(this).prev().find("input:checkbox").prop("checked");
    		if(checked){
    			$.cookie('layer', 'yes', {expires: 1});
    		}
    		$(".popup").hide();
    	});
    </script>
</body>
</html>