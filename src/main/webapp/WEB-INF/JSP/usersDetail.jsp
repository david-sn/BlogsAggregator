<%-- 
    Document   : usersDetail
    Created on : May 15, 2017, 12:16:21 AM
    Author     : David Shire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1>${users.userName}</h1>

<c:forEach items="${users.blogs}" var="blog">
    <h1>${blog.blogName}</h1>
    <p>${blog.blogUrl}</p>
    
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Link</th>
            </tr>
        </thead>
        <tbody>
            <%--<c:forEach items="blog.items" var="item">--%>
                <!--<tr>-->
                    <!--<td>${item.itemTitle}</td>-->
                    <!--<td>${item.itemLink}</td>-->
                <!--</tr>-->
            <%--</c:forEach>--%>
        </tbody>
    </table>
    
    
</c:forEach>