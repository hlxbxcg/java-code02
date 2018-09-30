<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.sql.Connection" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%  
    String username=new String(request.getParameter("username").getBytes("ISO8859_1"),"GBK");  
    String password=new String(request.getParameter("password").getBytes("ISO8859_1"),"GBK");  
    try {  
        // 加载数据库驱动，注册到驱动管理器  
        //String  mysqldriver="com.mysql.jdbc.Driver";
        Class.forName("com.mysql.jdbc.Driver");  
        // 数据库连接字符串  
        String url = "jdbc:mysql://localhost:3306/userdatabase";  
        // 数据库用户名  
        String usename = "root";  
        // 数据库密码  
       // String psw = "root";  
        // 创建Connection连接  
        Connection conn = DriverManager.getConnection(url,usename,"3306");  
        // 判断 数据库连接是否为空  
        if(conn != null){             
            String sql="select * from user where username='"+username+"' and password='"+ password + "'";  
            Statement stmt = conn.createStatement();  
            ResultSet rs=stmt.executeQuery(sql);  
            if(rs.next()){  
                response.sendRedirect("index.jsp");
                session.setAttribute("usr",username);                
            }else{  
                out.print("用户名或密码错误，请重新输入！");  
                %>  
                <a href="javascript:history.back()">返回</a>  
                <%   
            }             
            // 输出连接信息  
            //out.println("数据库连接成功！");  
            // 关闭数据库连接  
            conn.close();  
        }else{  
            // 输出连接信息  
            out.println("数据库连接失败！");                          
        }  
    } catch (ClassNotFoundException e) {  
        e.printStackTrace();  
    } catch (SQLException e) {  
        e.printStackTrace();  
    }  
%>  
  </body>
</html>
