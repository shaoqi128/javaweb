<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table.hovertable {
    font-family: verdana,arial,sans-serif;
    font-size: 14px;
    color: #333333;
    border-width: 1px;
    border-color: #999999;
    border-collapse: collapse;
    background-color: cornsilk;
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
    background: url(../img/index.supermarket.seckilling.bg-l-2.png) no-repeat center center;
    background-size: 1869px 1210px;
    perspective: 500px;
    background-position-y: 0px;
}
.text3{
    background-color: darkSeaGreen;
}

</style>
<meta charset="GBK">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="allUser.js"></script>
<body style="text-align:center;">
<h1>查看所有节目信息</h1>
<div style="text-align:center;">
  <table class="hovertable" align="center">
    <tr>
      <td><input id="btn1" type="button" value="全选" onclick="allcheck();" class="text3"/>
	      <input id="btn2" type="button" value="重置" onclick="allnotcheck();" class="text3"/>
	  </td>
      <td>节目号</td>
      <td>节目名</td>
      <td>演出时间</td>
      <td><input id="btn3" type="button" value="批量删除" onclick="delAllProgram();" class="text3"/></td>
    </tr>
   <%
       Vector<Program> v = (Vector<Program>)session.getAttribute("allpro");
       Iterator<Program> it = v.iterator();
       Program p = null;
       while(it.hasNext()){
    	   p = it.next();
   %>
    <tr>
      <td><input type="checkbox" name="check" value=<%=p.getPid() %>></td>
      <td><%=p.getPid() %></td>
      <td><%=p.getPname() %></td>
      <td><%=p.getShowtime() %></td>
      <td><a href="updateProgram.jsp?pid=<%=p.getPid()%>">修改</a>
          <a href="deleteProgram?pid=<%=p.getPid()%>"
             onclick="return confirm('您确定要删除该条记录吗？');">删除</a>
      </td>
    </tr>
   <%
       }
   %>
  </table>
</div><br>
  <a href="addPro.jsp">添加节目</a>
  <a href="admin.html">返回首页</a>
</body>
</html>