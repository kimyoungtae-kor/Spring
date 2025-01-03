<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/head.jsp"></jsp:include>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>

    <div class="wrap">
       <jsp:include page="../common/header.jsp"></jsp:include>
        <main class="container">
            <h1 class="text-center mt-5">로그인</h1>
            <form name = "frm"class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-2 mt-5" method="post">
                <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id" value="${cookie['remember-id'].value}">
                <input type="password" class="form-control my-3" id="pwd" placeholder="비밀번호" name="pwd">
                <div class="form-check form-switch my-3">
                    <input class="form-check-input" type="checkbox" id="mySwitch" name="remember-id" value="${cookie['remember-id']}" ${empty cookie['remember-id'] ? '' : 'checked'}>
                    <label class="form-check-label" for="mySwitch">아이디 기억</label>
                  </div>
                  
                  <button class="btn btn-primary">로그인</button>
    
            </form>
            <c:if test="${not empty msg}">
            <p class="my-5 text-danger text-center">로그인 실패 - 아이디와 비밀번호를 확인하세요</p>
            </c:if>
        </main>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
    <script>
/*     if($.cookie("save")){
    	$("#id").val($.cookie("save"));
    	$("#mySwitch").prop("checked",true);
    } */
        
    </script>
</body>
</html>