<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="allUser.js"></script>
<meta charset="GBK">
<title>Insert title here</title>
</head>
<style type="text/css">
table.hovertable {
    font-family: verdana,arial,sans-serif;
    font-size: 14px;
    color: #333333;
    border-width: 1px;
    border-color: #999999;
    border-collapse: collapse;
    background-color: darkSeaGreen;
}
table.hovertable th {
 	background-color: #c3dde0;
 	border-width: 1px;
 	padding: 8px;
 	border-style: solid;
 	border-color: #a9c6c9;
 }
table.hovertable td {
 	border-width: 1px;
 	padding: 8px;
 	border-style: solid;
 	border-color: #a9c6c9;
 	width: 150px;
 }
body {
    height: 100%;
    width: 100%;
    background: url(../img/index.supermarket.seckilling.bg-m-2.png) no-repeat center center;
    background-size: 1869px 1210px;
    perspective: 500px;
    background-position-y: 0px;
}
.text2{
    background-color: burlyWood;
}

</style>
<body style="text-align:center;">
<h1>�鿴�����û���ҳ��</h1>
<div style="text-align:center;">
	<table class="hovertable" align="center">
	  <tr>
	    <td><input id="btn1" type="button" value="ȫѡ" onclick="allcheck();" class="text2"/>
	        <input id="btn2" type="button" value="����" onclick="allnotcheck();" class="text2"/>
	    </td>
	    <td>���</td>
	    <td>����</td>
	    <td>����</td>
	    <td>Ȩ��</td>
	    <td><input id="btn2" type="button" value="����ɾ��" onclick="delAllUser();" class="text2"/></td>
	  </tr>
	  <%
		Vector<User> v = (Vector<User>)session.getAttribute("alluser");
		Iterator<User> it = v.iterator();
		User u = null;
		while(it.hasNext()){
			u = it.next();
			if(!u.getUid().equals("u00")){
	  %>	
	  <tr>
	      <td><input type="checkbox" name="check" value=<%=u.getUid() %>></td>
	      <td><%=u.getUid() %></td>
	      <td><%=u.getUname() %></td>
	      <td><%=u.getPassword() %></td>
	      <td><%=u.getSuperuser() %></td>
	      <td>
	         <a href="updateUser.jsp?uid=<%=u.getUid()%>">�޸�</a>
	         <a href="updateUser?f=del&uid=<%=u.getUid()%>"
	            onclick="return confirm('��ȷ��Ҫɾ��������¼��');">ɾ��</a>
	      </td>
	    </tr>	
	  <%		
		}}
	  %>
	</table>
</div><br>
	<a href="admin.html">������ҳ</a>
	

</body>
</html>