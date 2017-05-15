<%-- 
    Document   : usersDetail
    Created on : May 15, 2017, 12:16:21 AM
    Author     : David Shire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<span>User Name: <strong>${users.userName}</strong></span> 
<br/><br/>

<c:forEach items="${users.blogs}" var="blog">


    <span>Blog Name: <strong> ${blog.blogName} </strong> </span> 
    <br/><br/>

    <span>Blog Link: <a href="${blog.blogUrl}" target="_blank" data-toggle="tooltip" title="${blog.blogUrl}"><strong>Click Here</strong></a> </span> <br><hr>
    <br/>

    <table class="table table-bordered table-hover table-striped">
        <caption>Item Details</caption>
        <thead>
            <tr>
                <th>    <span><strong>Item Title: </strong></span>    </th>
                <th>    <span><strong>Item Link: </strong></span>     </th>
                <th>    <span><strong>Item Date Published </strong></span></th>
                <th>    <span><strong>Item Description </strong></span></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${blog.items}" var="item">
                <tr>
                    <td>${item.itemTitle}</td>
                    <td>${item.itemLink}</td>
                    <td>${item.itemPublishedDate}</td>
                    <td>${item.itemDescriptions}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</c:forEach>