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
<h1>�鿴���н�Ŀ��Ϣ</h1>
<div style="text-align:center;">
  <table class="hovertable" align="center">
    <tr>
      <td><input id="btn1" type="button" value="ȫѡ" onclick="allcheck();" class="text3"/>
	      <input id="btn2" type="button" value="����" onclick="allnotcheck();" class="text3"/>
	  </td>
      <td>��Ŀ��</td>
      <td>��Ŀ��</td>
      <td>�ݳ�ʱ��</td>
      <td><input id="btn3" type="button" value="����ɾ��" onclick="delAllProgram();" class="text3"/></td>
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
      <td><a href="updateProgram.jsp?pid=<%=p.getPid()%>">�޸�</a>
          <a href="deleteProgram?pid=<%=p.getPid()%>"
             onclick="return confirm('��ȷ��Ҫɾ��������¼��');">ɾ��</a>
      </td>
    </tr>
   <%
       }
   %>
  </table>
</div><br>
  <a href="addPro.jsp">��ӽ�Ŀ</a>
  <a href="admin.html">������ҳ</a>
</body>
</html>