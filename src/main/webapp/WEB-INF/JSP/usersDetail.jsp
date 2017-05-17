<%-- 
    Document   : usersDetail
    Created on : May 15, 2017, 12:16:21 AM
    Author     : David Shire
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<span>User Name: <strong>${users.userName}</strong></span> 
<br/><br/>

<!-- Button trigger modal -->
<button type="button" class="btn btn-success btn-md" data-toggle="modal" data-target="#myModal">
    <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>   New Blog
</button>

<!-- Modal -->
<form:form commandName="blogModel"  cssClass="form-horizontal">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">new Blog Detail</h4>
                </div>
                <div class="modal-body">

                    <!--Input one for blog name-->
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="name" >Blog Name:</label>
                        <div class="col-sm-10">
                            <form:input path="blogName" cssClass="form-control"  />
                            <form:errors path="blogName" />
                        </div>
                    </div>

                    <!--Input one for blog URL-->
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="name" >Blog URL:</label>
                        <div class="col-sm-10">
                            <form:input path="blogUrl" cssClass="form-control"  />
                            <form:errors path="blogUrl" />
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </div>
        </div>
    </div>
</form:form>
<br><br>

<script>
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $('.triggerRemove').click(function (e) {
            e.preventDefault();
            $("#modalRemove .rmbtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
    });
</script>
<!--Tabs-->


<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
    <c:forEach items="${users.blogs}" var="blog">
        <li><a href="#blog_${blog.blog_dbid}" data-toggle="tab">${blog.blogName}</a></li>
        </c:forEach>
</ul>
<br><br>
<!-- Tab panes -->
<div class="tab-content">
    <c:forEach items="${users.blogs}" var="blog">
        <div role="tabpanel" class="tab-pane" id="blog_${blog.blog_dbid}">


            <span>Blog Name: <strong> ${blog.blogName} - ${blog.blog_dbid} </strong> </span> 
            <br/><br/>

            <span>Blog Link: <a href="${blog.blogUrl}" target="_blank" data-toggle="tooltip" title="${blog.blogUrl}"><strong>Click Here</strong></a> </span> <br>


            <a style="margin-top:20px;" href="<spring:url value='/blog/remove/${blog.blog_dbid}'/>" class="btn btn-danger btn-md triggerRemove">Remove Blog</a>

            <hr>
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
        </div>
    </c:forEach>
</div>

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