<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>강사관리</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>강사 조회 by JSP</h1>
<form action='update.do' method='POST' enctype='multipart/form-data'>
번호:<input type='text' name='no' value='${student.no}' readonly><br>
이름:<input type='text' name='name' value='${student.name}'><br>
전화:<input type='text' name='tel' value='${student.tel}'><br>
이메일:<input type='text' name='email' value='${student.email}'><br>
암호:<input type='password' name='password'><br>
재직:<input type="radio" name="workingYn" value='Y' ${student.workingYn == 'Y'.charAt(0) ? 'checked' : ''}>Y
   <input type="radio" name="workingYn" value='N' ${student.workingYn != 'Y'.charAt(0) ? 'checked' : ''}>N<br>
최종학력:<input type="text" name="lastEducation" value='${student.lastEducation}'><br>
학교명:<input type="text" name="schoolName" value='${student.schoolName}'><br>
우편번호:<input type="text" name="postNumber" value='${student.postNumber}'><br>
기본주소:<input type="text" name="primaryAddress" value='${student.primaryAddress}'><br>
상세주소:<input type="text" name="detailAddress" value='${student.detailAddress}'><br>
사진:<input type="file" name="photo"><br>
<p></p>
<div>
  <img class='photo1' src='photo/${student.photoName}'>
</div>

<hr>
<button>변경</button>
<button type='button' onclick='doDelete()'>삭제</button>
<button type='button' onclick='doList()'>목록</button>
</form>
<script>
function doDelete() {
  location.href = 'delete.do?no=${student.no}'
}
function doList() {
  location.href = 'list.do'

}
</script>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
    