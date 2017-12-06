<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의관리</title>
  <style>
body {
  background-image: url('11.png');
  background-color: #D9E5FF;
  background-position:center center;
}
</style>
</head>
<body>
<h1>강의 등록</h1>
<form action="add.do" method="POST" enctype="multipart/form-data">
강의실:
<select name="classroomNo">
<c:forEach items="${classrooms}" var="classroom">
  <option value="${classroom.no}">${classroom.name}</option>
</c:forEach>
</select>
<br>
매니저:
<select name="managerNo">
<c:forEach items="${managers}" var="manager">
  <option value="${manager.no}">${manager.name}(${manager.email})</option>
</c:forEach>
</select>
<br>
강의명:<input type="text" name="title"><br>
상세:<input type="text" name="descript"><br>
시작일:<input type="text" name="startDate"><br>
종료일:<input type="text" name="endDate"><br>
인원:<input type="text" name="qty"><br>
가격:<input type="text" name="price"><br>
총시간:<input type="text" name="thours"><br>
<button>등록</button>
</form>

</body>
</html>