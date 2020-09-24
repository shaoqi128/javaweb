<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<title>Insert title here</title>
</head>
<body>
<h1>修改用户信息的页面</h1>
<form action="updateUser">
	<table>
	  <tr>
	    <td>编号</td>
	    <td>姓名</td>
	    <td>密码</td>
	    <td>权限</td>
	    <td></td>
	  </tr>
	  <%
	  	String uid = request.getParameter("uid");
		Vector<User> v = (Vector<User>)session.getAttribute("alluser");
		Iterator<User> it = v.iterator();
		User u = null;
		while(it.hasNext()){
			u = it.next();
			if(u.getUid().equals(uid)){
	  %>	
	  <tr>
	      <td><input type="hidden" name="uid" value=<%=u.getUid()%>><%=u.getUid()%></td>
	      <td><input type="text" name="name" value=<%=u.getUname()%>></td>
	      <td><input type="text" name="password" value=<%=u.getPassword()%>></td>
	      <td><input type="text" name="superuser" value=<%=u.getSuperuser()%>></td>
	      <td><input type="submit" value="修改"></td>
	    </tr>	
	  <%		
			}}
	  %>
	</table>
</form>
	

</body>
</html>