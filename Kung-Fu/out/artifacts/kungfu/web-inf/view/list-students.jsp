<%--
  Created by IntelliJ IDEA.
  User: arthik.daniel
  Date: 21/06/18
  Time: 2:11 AM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html style="margin-left:0 ;margin-right:0">
<head>
    <title>List Of Students</title>
    <jsp:include page="header.jsp"/>
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
            <%--Error & Status Messages Formatted.--%>
            <jsp:include page="resultmsg.jsp"/>


            <div class="col-md-10 col-md-offset-1" style="margin-bottom:40px">
                <input type="button" value="Add Student" style="margin-left:20px"
                       onClick="window.location.href='addStudent'; return false;"
                       class="add-button pull-right btn btn-success"
                />

                <!--  add a search box -->

                <form:form action="searchForStudent" method="POST" class="pull-right">
                    <span style="color:#fff">Search Student:</span> <input  type="text"
                                                                           name="theSearchString"
                                                                           style="padding: 3px;border-radius: 5px;border: 1px solid #000;margin-right: 5px;"/>

                    <input type="submit" value="Search" class="add-button btn btn-primary"/>

                    <%--<div class="input-group changethisone">--%>
                    <%--<input type="text" name="theSearchString" class="form-control"--%>
                    <%--placeholder="Enter Student to Search"/>--%>
                    <%--<span class="input-group-addon"><i class="glyphicon glyphicon-search" onclick="submit()"></i></span>--%>
                    <%--</div>--%>
                </form:form>
            </div>

            <script>
                $(document).ready(function () {
                    $('#stud_table').DataTable();
                });
            </script>

            <table id="stud_table" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
                <tr>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">ID</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">First Name</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Last Name</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Email</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Action</th>
                </tr>

                <c:forEach var="tmpStudent" items="${students}">
                    <c:url var="studentDetails" value="/kungfu/showStudentDetails">
                        <c:param name="studentId" value="${tmpStudent.id}"></c:param>
                    </c:url>
                    <c:url var="recordAttendance" value="/kungfu/captureAttendance">
                        <c:param name="studentId" value="${tmpStudent.id}"></c:param>
                    </c:url>
                    <c:url var="showFinanceForm" value="/kungfu/showPaymentDetails">
                        <c:param name="studentId" value="${tmpStudent.id}"></c:param>
                    </c:url>
                    <c:url var="showAchievementForm" value="/kungfu/showAchievements">
                        <c:param name="studentId" value="${tmpStudent.id}"></c:param>
                    </c:url>
                    <tr>
                        <td><a href="${studentDetails}">${tmpStudent.id}</a></td>
                        <td>${tmpStudent.firstName}</td>
                        <td>${tmpStudent.lastName}</td>
                        <td>${tmpStudent.email}</td>
                            <%-- <td>${tmpStudent.dob}</td>
                            <td>${tmpStudent.doorNo},${tmpStudent.street},${tmpStudent.city},${tmpStudent.province},${tmpStudent.postalCode}</td> --%>
                        <td>
                            <a href="${recordAttendance}" class="btn btn-primary btn-sm"
                               onClick="return confirm('Are you sure you want to record attendance for this student?');">
                                Attendance</a>

                            <a href="${showFinanceForm}" class="btn btn-primary btn-sm">Payment Choice</a>

                            <a href="${showAchievementForm}" class="btn btn-primary btn-sm">Rank Details</a>
                        </td>
                    </tr>

                </c:forEach>
                <tr>
                    <th colspan="5" style="background: none repeat scroll 0 0 #333;text-align:center;padding: 2px;"></th>
                </tr>
            </table>

        </div>
    </div>
</div>

</body>
</html>