<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>³ö´íÀ²£¡£¡£¡</title>
</head>

<body>
    ¶Ô²»Æð£¡Äú<%=request.getAttribute("error") %>Ê§°Ü
</body>
</html>
