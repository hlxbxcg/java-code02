<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>������ֵ</title>
</head>
<body>
 <center >
 <font color=red size=72>ѧ������ҳ��</font>
<hr>
<form action="Insert" method="post">
<table border="1">
<tr>
<td>������</td>
<td><input name ="name"></td>
</tr>

<tr>
<td>���룺</td>
<td><input type="password" name ="password"></td>
</tr>

<tr>
<td>�Ա�</td>
<td><input type="radio" name ="sex" value="��">��
        <input type="radio" name ="sex" value="Ů">Ů
 </td>
</tr>

<tr>
<td>���䣺</td>
<td><input type="text" name ="age"></td>
</tr>

<tr>
<td colspan="2">
 <center>
 <input type="submit" value="�ύ">
 <input type="reset" value="����">
</center>
</td>
</tr>

</table>
</form>
<a href="SearchList.jsp">��ѯ</a>
 </center>
</body>
</html>
