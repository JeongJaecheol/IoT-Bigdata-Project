<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>강의관리</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>강 목록 by JSP</h1>
<a href='form.do'>새강의</a>
<table border='1'>
<thead>
  <tr>
    <th>강의번호</th>
    <th>반번호</th>
    <th>매니저번호</th>
    <th>과목명</th>
    <th>상세</th>
    <th>시작일</th>
    <th>종료일</th>
    <th>인원</th>
    <th>가격</th>
    <th>총시간</th>
  </tr>
</thead>
<tbody>
<c:forEach items="${list}" var="item">
<tr>
  <td>${item.lectureNo}</td>
  <td><a href='detail.do?no=${item.lectureNo}'>${item.classroomNo}</a></td>
  <td>${item.managerNo}</td>
  <td>${item.title}</td>
  <td>${item.descript}</td>
  <td>${item.startDate}</td>
  <td>${item.endDate}</td>
  <td>${item.qty}</td>
  <td>${item.price}</td>
  <td>${item.thours}</td>
</tr>
</c:forEach> 
</tbody>
</table>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
    