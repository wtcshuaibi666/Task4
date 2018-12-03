
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Tomcat集群/动静分离测试</title>
</head>
<body>
<%
    out.println("["+request.getLocalAddr()+":" +request.getLocalPort()+"]" + "<br/>session id:" + session.getId());
%>
<h1>images:</h1>
<img src="/usr/local/nginx/tupian/8989.png" />
</body>
</html>
