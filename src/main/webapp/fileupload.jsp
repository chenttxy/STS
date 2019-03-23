<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="product/upload.action" method="post" enctype="multipart/form-data">
  <label>用户ID：</label><input type="text" name="goodId"><br>
  <label>类别：</label><input type="text" name="categoryId"><br>
  <label>上传头像：</label><input type="file" name="file"><br>
  <input type="submit">
  </form>
</body>
</html>