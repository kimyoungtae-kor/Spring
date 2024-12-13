<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
    <div class="wrap">
          <jsp:include page="../common/header.jsp"></jsp:include>
        <main class="container">
            <h1 class="text-center mt-5">회원 가입</h1>
            <form name = "frm"class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-2 mt-5" method="post" >
                <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id">
                <input type="password" class="form-control my-3" id="pwd" placeholder="비밀번호" name="pwd">
                <input type="text" class="form-control my-3" id="name" placeholder="이름" name="name">
                <input type="email" class="form-control my-3" id="email" placeholder="Enter email" name="email">
                <input type="text" class="form-control my-3" id="roadAddr" placeholder="도로명 주소" name="roadAddr">
                <input type="text" class="form-control my-3" id="detailAddr" placeholder="상세주소" name="detailAddr">
                <div class="input-group my-3">
                    <input type="text" class="form-control" placeholder="도로명검색">
                    <button class="btn btn-success" id="search" type="button">주소 검색</button>
                  </div>
                  <ul class="list-group search-result-wrap">
                    
                  </ul>
                  <button class="btn btn-primary">가입하기</button>
    
            </form>
        </main>
                 <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
    <script>
        $(function(){
                $("#search").click(function(){
                const keyword = $(this).prev().val();
                if(!keyword) {
                    return;
                }
                const data = {
                    keyword,
                    confmKey : 'devU01TX0FVVEgyMDI0MTEwNjE0NTczMjExNTIxNjE=',
                    currentPage : 1,
                    countPerPage : 100,
                    resultType : 'json'
                };
                
                $.ajax({
                    url :"https://business.juso.go.kr/addrlink/addrLinkApiJsonp.do",
                    type : "get",
                    data,
                    dataType : "jsonp",
                    crossDomain : true,
                    success : function(data){
                        let arr = data.results.juso;
                        console.log(data.results.juso);
                        let idx = 0;

                        for(let i =0;i < arr.length;i++){
                            let str = `<li class="list-group-item"><a href="#" class="small">\${arr[idx].roadAddr}</a></li>`
                            $('ul.search-result-wrap').append(str);
                            idx++;
                        }
                    },
                    error : function(xhr,msg){
                        console.log(msg);
                    }
                })
            });
            $("ul.search-result-wrap").on("click","a",function(){
                $("#roadAddr").val($(this).text().trim());
                $("ul.search-result-wrap").closest("ul.search-result-wrap").empty();
            });
        })
       
     </script>
</body>
</html>