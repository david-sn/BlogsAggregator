<%-- 
    Document   : users
    Created on : May 14, 2017, 10:43:59 PM
    Author     : David Shire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>



<table class="table table-bordered table-hover table-striped">

    <thead>
        <tr>
            <th>User Code</th>
            <th>User Name</th>
            <th>User Email</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    ${user.user_dbid}
                </td>
                <td>
                    ${user.userName}
                </td>
                <td>
                    ${user.userEmail}
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>