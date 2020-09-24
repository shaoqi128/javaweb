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
<h1>修改节目信息</h1>
<form action="updatePro">
  <table>
    <tr>
      <td>节目号</td>
      <td>节目名</td>
      <td>演出时间</td>
      <td></td>
    </tr>
   <%
       String pid = request.getParameter("pid");
       Vector<Program> v = (Vector<Program>)session.getAttribute("allpro");
       Iterator<Program> it = v.iterator();
       Program p = null;
       while(it.hasNext()){
    	   p = it.next();
    	   if(p.getPid().equals(pid)){
   %>
    <tr>
      <td><input type="hidden" name="pid" value=<%=p.getPid()%>><%=p.getPid()%></td>
      <td><input type="text" name="name" value=<%=p.getPname()%>></td>
      <td><input type="text" name="showtime" value=<%=p.getShowtime()%>></td>
      <td><input type="submit" value="修改"></td>
    </tr>
   <%
       }}
   %>
  </table>
</form>
</body>
</html>