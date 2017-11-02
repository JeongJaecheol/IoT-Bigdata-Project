<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강사관리</title>
	<jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>강사 등록</h1>
<form action="add.do" method="POST" enctype="multipart/form-data">
이름:<input type="text" name="name"><br>
전화:<input type="text" name="tel"><br>
이메일:<input type="text" name="email"><br>
암호:<input type="password" name="password"><br>
재직:<input type="radio" name="workingYn" value="Y" checked>Y
   <input type="radio" name="workingYn" value="N">N<br>
최종학력:<input type="text" name="lastEducation"><br>
학교명:<input type="text" name="schoolName"><br>
우편번호:<input type="text" name="postNumber"><br>
기본주소:<input type="text" name="primaryAddress"><br>
상세주소:<input type="text" name="detailAddress"><br>
사진:<input type="file" name="photo"><br>
<hr>
<button>등록</button>
</form>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>