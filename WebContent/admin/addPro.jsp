<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
<%-- <script type="text/javascript" src="addPro.js"></script> --%> 
<meta charset="GBK">
<title>Insert title here</title>
</head>
  <body>
   <h1>添加节目页面</h1>
   <form action="addpro">
	 节目号：<input type="text" name="pid" id="pid" required="required">
	 节目名：<input type="text" name="pname" id="pname" required="required">
	 表演时间：<input type="text" name="showtime" id="showtime" required="required">
	 <input type="submit" value="添加" onclick="check();">
   </form>
  </body>
</html>