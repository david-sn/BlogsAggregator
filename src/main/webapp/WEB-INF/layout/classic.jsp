<%-- 
    Document   : classic
    Created on : May 3, 2017, 9:43:51 PM
    Author     : David Shire
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
        <title>
        <tiles:getAsString  name="title" />

        </title>
    </head>
    <body>
        <tiles:insertAttribute name="body" />

        <br/><br/>

    <center>
        <tiles:insertAttribute name="footer" />
    </center>
</body>
</html>
