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
</head>
<body>
    <div class="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		
        <main class="container">
                  <div class="container clearfix p-2">
               
                <h2 class="text-center fw-bold p-3">write</h2>
            </div>
            ${cri.qs}
            <form method="post" action="write?page=1&${cri.qs}">
            <div class="my-3 col-md-9 mx-auto">

                <label for="title" class="form-label mt-3"><i class="fa-solid fa-heading text-danger"></i><b> 제목</b></label>
                <input type="text" class="form-control" id="title" placeholder="title" name="title" >

                <label for="content" class="form-label  mt-3"><i class="fa-solid fa-pen text-danger"></i><b> Content</b></label>
                <textarea class="form-control" rows="20" id="content" name="content" placeholder="content" ></textarea>

                <label for="writer" class="form-label mt-3"><i class="fa-solid fa-user-pen text-danger"></i><b> 작성자</b></label>
                <input type="text" class="form-control" id="writer" placeholder="writer" name="writer"  value="${member.id}" readonly>
                
                <label class="form-label mt-3"><i class="fa-regular fa-file"></i><b> ATTACH</b><br></label><br>
                <label for="attach" class="form-label"><span class="btn btn-primary">파일 첨부</span></label>
                <span class="mx-2 attach-count-txt"></span>
                <input type="file" id="attach"name="files" class="d-none" multiple>
  			<ul class="list-group attach-result">
<!-- 			  <li class="list-group-item">First item</li>
			  <li class="list-group-item">Second item</li>
			  <li class="list-group-item">Third item</li> -->
			</ul>
              </div>
              
              <hr>
			
              <div class ="text-center my-5">
              	<button class="btn btn-primary">작성</button>
                <a href="list?${cri.qs2}" class="btn ">목록</a>
              </div>
              
              
              <div class="uploaded-input">
              	
              </div>
              </form>
        </main>
       <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
     <script>
    $("#attach").change(function() {
        const url = '${cp}' + 'upload'
        const formData = new FormData();
        console.log(this.files);
        const files = this.files;
        
        if(!files){
        	$(".attach-count-txt").text("");
        	$(".attach-result").empty();
        	return;
        }
        for(let i = 0 ; i < files.length ; i++) {
            formData.append("file", files[i]);
        }
        $.post({
            url,
            contentType:false,
            processData:false,
            data:formData
        })
        .done(function(data) {
        	$(".attach-count-txt").text(data.length+"개의 파일");
        	let str = "";
        	let strHidden = '';
        	for(let i in data){
            	str += `<li class="list-group-item">\${data[i].origin}</li>`;
                strHidden += `<input type="hidden" name="uuid" value="\${data[i].uuid}">`;
                strHidden += `<input type="hidden" name="origin" value="\${data[i].origin}">`;
                strHidden += `<input type="hidden" name="image" value="\${data[i].image}">`;	
                strHidden += `<input type="hidden" name="path" value="\${data[i].path}">`;
        	}
        	$(".attach-result").html(str);
            $(".uploaded-input").html(strHidden);

            console.log(data);
        });
    });
    </script>
    
</body>
</html>