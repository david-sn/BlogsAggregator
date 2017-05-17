<%-- 
    Document   : users
    Created on : May 14, 2017, 10:43:59 PM
    Author     : David Shire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>



<table class="table table-bordered table-hover table-striped">
    <caption>Users List</caption>
    <thead>
        <tr>
            <th>User Code</th>
            <th>User Name</th>
            <th>User Email</th>
            <th>User Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    ${user.user_dbid}
                </td>
                <td>
                    <a href="<spring:url value="/users/${user.user_dbid}"/>">${user.userName}</a>
                </td>
                <td>
                    ${user.userEmail}
                </td>
                <td>
                    <a href="<spring:url value="/users/remove/${user.user_dbid}"/>" class="btn btn-danger btn-xs triggerRemove">  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>

<script>
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $('.triggerRemove').click(function(e){
            e.preventDefault();
          $("#modalRemove .rmbtn").attr("href",$(this).attr("href"));  
          $("#modalRemove").modal();
        });
    });
</script>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
            </div>
            <div class="modal-body">
                Are you sure
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger rmbtn">Remove</a>
            </div>
        </div>
    </div>
</div>