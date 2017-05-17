<%-- 
    Document   : userAccount
    Created on : May 17, 2017, 7:35:16 PM
    Author     : David Shire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<!-- Button trigger modal -->
<button type="button" class="btn btn-success btn-md" data-toggle="modal" data-target="#myModal">
    <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>   New Blog
</button>
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
<form:form commandName="blogModel"  cssClass="form-horizontal registrationForm">
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


<script type="text/javascript">
    $(document).ready(function () {
        $(".registrationForm").validate(
                {
                    rules: {
                        blogName: {
                            required: true,
                            minlength: 3
                        },
                        blogUrl: {
                            required: false,
                            email: true
                        } 
                    },
//                    this for text input highlight when written
                    highlight: function (element) {
                        $(element).closest(".form-group").removeClass("has-success").addClass("has-error");
                    },
                    unhighlight: function (element) {
                        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
                    }
                }
        );
    });
</script>