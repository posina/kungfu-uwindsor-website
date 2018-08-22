<%--
  Created by IntelliJ IDEA.
  User: arthik.daniel
  Date: 21/06/18
  Time: 2:11 AM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="margin-left:0 ;margin-right:0">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Finances</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body style="display:table;width:100%">
<img src="../resources/images/photo_bg.jpg"
     style="margin-bottom:50px;width: 100%;height: 260px;">
<div class="table-bkg">
    <div id="wrappper" style="position:relative">
        <div id="header"
             style="width:35%;background:transparent !important;padding:15px !important;position: absolute;top: -233px;left: 460px;">
            <h2 style="color:rgb(253,233,30);font-size:50px">UWindsor KungFu Center</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <c:forEach var="tmpAccountSummary" items="${theAccountSummary}">
                <c:set var="studentId" scope="session" value="${tmpAccountSummary.studentId}"/>
            </c:forEach>
            <div class="col-md-10 col-md-offset-1">
                <form:form action="searchFinanceRange" method="GET"
                                                              style="width: 700px;float: right;">

                <input type="hidden" name="studentId" value=${studentId}>
                <span>From:</span> <input type="date" name="fromDate"
                                          style="padding: 3px;border-radius: 5px;border: 1px solid #000;margin-right: 5px;"/>
                <span style="margin-left: 15px;">To:</span> <input type="date" name="toDate"
                                                                   style="padding: 3px;border-radius: 5px;border: 1px solid #000;margin-right: 5px;"/>
                <input type="submit" value="Search Finances " style="margin-left: 20px;"
                       class="add-button btn btn-primary"/>
            </form:form></div>
            <script>
                $(document).ready(function () {
                    $('#fin_table').DataTable();
                });
            </script>

            <table id="fin_table" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
                <tr>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Category</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Sub Category</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">fees</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Date Paid</th>
                </tr>
                <c:forEach var="tmpAccountSummary" items="${theAccountSummary}">
                    <tr>
                        <td>${tmpAccountSummary.category}</td>
                        <td>${tmpAccountSummary.subCategory}</td>
                        <td>${tmpAccountSummary.fees}$</td>
                        <td>${tmpAccountSummary.datePaid}</td>
                    </tr>
                </c:forEach>
            </table>

            <label class="col-md-10 col-md-offset-1"> <a class="btn btn-primary"
                                                         href="${pageContext.request.contextPath}/kungfu/list"
                                                         style="margin-top: 45px; width: 120px; float: left;">Back to
                List</a>
            </label>

        </div>
    </div>
</div>
</body>
</html>