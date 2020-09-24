<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*, cn.edu.lingnan.dao.*" %>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="GBK">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
<div style="text-align:center;">
    <table class="hovertable" align="center">
      <tr>
        <td>用户编号</td>
        <td>用户姓名</td>
        <td>节目编号</td>
        <td>节目名称</td>
        <td>演出时间</td>
        <td></td>
      </tr>
      <%
          ScoreDAO sd = new ScoreDAO();
          Vector<Score> v = sd.findAllScore();
          Iterator<Score> it = v.iterator();
          Score s = null;
          while(it.hasNext()){
        	  s = it.next();
        	  UserDAO ud = new UserDAO();
        	  String uname = ud.findUserNameById(s.getUid());
        	  ProgramDAO pd = new ProgramDAO();
        	  Program p = pd.findProgramByPid(s.getPid());
        	  
      %>
       <tr>
         <td><%=s.getUid() %></td>
         <td><%=uname %></td>
         <td><%=s.getPid() %></td>
         <td><%=p.getPname() %></td>
         <td><%=p.getShowtime() %></td>
         <td><a href="deleteScore?uid=<%=s.getUid()%>&pid=<%=s.getPid()%>"
                onclick="return confirm('您确定要删除该学生节目吗？');">删除</a></td>
       </tr>
      <%
          }
      %>
    </table>
</div><br>
<a href="/Test/admin/admin.html">返回上一页</a>
</body>
</html>