<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tittle" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute name="tittle"/></title>
    <tiles:insertAttribute name="top" />
</head>
<body>
<%--头部--%>
<tiles:insertAttribute name="header" />
<%--菜单--%>
<tiles:insertAttribute name="menu"/>
<%--内容--%>
<tiles:insertAttribute name="body"/>
<%--尾部--%>
<tiles:insertAttribute name="footer"/>
</body>
</html>