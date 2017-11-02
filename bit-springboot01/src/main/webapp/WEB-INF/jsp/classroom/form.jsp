<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교실관리</title>
</head>
<body>
<h1>교실 등록</h1>
<form action="add.do" method="POST" enctype="multipart/form-data">
이름:<input type="text" name="name"><br>
사진1:<input type="file" name="photo"><br>
사진2:<input type="file" name="photo"><br>
사진3:<input type="file" name="photo"><br> 
<button>등록</button>
</form>

</body>
</html>