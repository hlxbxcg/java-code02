<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
<style type="text/css">
	#login{
		
		background-image:url(image/11.jpg);
		width:500px;
		height:600px;
		background-position: center;
		text-align: center;
		font-size: 20px;
		vertical-align: middle;
		
	}

	</style>
</head>
<body>
<center>
<div id="login">
<form action="selectForm-result.jsp"method="post">
<center>
<table border="0" position="center">

<tr>
<td colspan="2" style="height: 50px;"><h3>��ӭʹ��ѧ����Ϣ����ϵͳ</h3></td>
</tr text-align="center">
<tr>
<tr>
<td colspan="2">
�˺�:<input name="acount" type="text"></td>
</tr>
<tr>
<td colspan="2">
����:<input name="password" type="password">
</tr>
<tr>
<td colspan="2">
��ɫ:<select name="role">
<option value="��ʦ">��ʦ</option>
<option value="ѧ��">ѧ��</option>	
<option value="����Ա">����Ա</option>	
</select>
</td>
</tr>
<tr>
<td colspan="2">
<input type="button"value="��¼">
<input type="button" value="����">
</td>
</tr>
</tr>
</table>
</center>
</div>
</center>
</body>
</html>