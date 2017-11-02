<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장비등록결과</title>
</head>
<body>
<h1>장비등록결과</h1>
<c:choose>
	<c:when test="${result == 0}">
	<p>장비를 성공적으로 등록하였습니다.</p>
	</c:when>
	<c:when test="${result == 1}">
	<p>회원이 아닙니다. 회원 가입을 하신 후 장비를 등록하세요.</p>
	</c:when>
	
	<c:when test="${result == 2}">
  <p>이미 등록된 장비입니다. 장비를 재설정 하신 후 등록하세요.</p>
  </c:when>
  
  <c:when test="${result == 3}">
  <p>장비를 찾을 수 없습니다. 먼저 장비를 재설정 하신 후 등록하세요.</p>
  </c:when>
</c:choose>
</body>
</html>








