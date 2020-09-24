<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<title>Insert title here</title>
</head>
<style type="text/css">
table.hovertable {
 	font-family: verdana,arial,sans-serif;
 	font-size:14px;
 	color:#333333;
 	border-width: 1px;
 	border-color: #999999;
 	border-collapse: collapse;
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
body{
	height:100%;
	width:100%;
	background-color: floralwhite;
	background-size:1900px 1500px;
	perspective:500px;
}
</style>
<body style="text-align:center;">
<h1>节目安排</h1>
<div style="text-align:center;">
  <table class="hovertable" align="center">
    <tr>
      <td>编号</td>
      <td>节目名</td>
      <td>演出时间</td>
      <td></td>
    </tr>
   <%
       Vector<Program> v = (Vector<Program>)session.getAttribute("allprog");
       Iterator<Program> it = v.iterator();
       Program p = null;
       while(it.hasNext()){
    	   p = it.next();
   %>
   <tr>
     <td><%=p.getPid() %></td>
     <td><%=p.getPname() %></td>
     <td><%=p.getShowtime() %></td>
     <td><a href="joinprogram?pid=<%=p.getPid()%>">参加</a></td>
   </tr> 	   
   <%  
       }
   %>
  </table>
</div><br>
  <a href="findpro1">查看参加的节目</a><br><br>
  <a href="/Test/user.html">返回首页</a>
</body>
</html>