<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>교실관리</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>교실 조회</h1>
<form action='update.do' method='POST' enctype='multipart/form-data'>
번호:<input type='text' name='no' value='${classRoom.no}' readonly><br>
이름:<input type='text' name='name' value='${classRoom.name}'><br>
사진1:<input type='file' name='photo'><br>
사진2:<input type='file' name='photo'><br>
사진3:<input type='file' name='photo'><br>
<div>
<c:forEach items='${classRoom.photoNames}' var='name'>
<img class='photo1' src='photo/${name}'>
</c:forEach>
</div>
<button>변경</button>
<button type='button' onclick='doDelete()'>삭제</button>
<button type='button' onclick='doList()'>목록</button>
</form>
<script>
function doDelete() {
  location.href = 'delete.do?no=${classRoom.no}'
}
function doList() {
  location.href = 'list.do'

}
</script>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
    