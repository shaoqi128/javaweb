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
   <h1>��ӽ�Ŀҳ��</h1>
   <form action="addpro">
	 ��Ŀ�ţ�<input type="text" name="pid" id="pid" required="required">
	 ��Ŀ����<input type="text" name="pname" id="pname" required="required">
	 ����ʱ�䣺<input type="text" name="showtime" id="showtime" required="required">
	 <input type="submit" value="���" onclick="check();">
   </form>
  </body>
</html>