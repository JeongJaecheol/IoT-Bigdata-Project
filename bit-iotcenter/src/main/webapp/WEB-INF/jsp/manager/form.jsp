<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매니저관리</title>
</head>
<body>
<h1>매니저 등록</h1>
<form action="add.do" method="POST" enctype="multipart/form-data">
이름:<input type="text" name="name"><br>
전화:<input type="text" name="tel"><br>
이메일:<input type="text" name="email"><br>
암호:<input type="password" name="password"><br>
직급:<input type="text" name="position"><br>
Fax:<input type="text" name="fax"><br>
사진:<input type="file" name="photo"><br>

<button>등록</button>
</form>

</body>
</html>