<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="margin-left:0 ;margin-right:0">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Attendance</title>

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
            <script>
                $(document).ready(function () {
                    $('#stud_table').DataTable();
                });
            </script>

            <table id="stud_table" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
                <tr>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">DateAttended</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Day</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Time</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Level</th>
                    <th style="background: none repeat scroll 0 0 #333;text-align:center">Rank</th>
                </tr>
                <c:forEach var="tmpAttendance" items="${theStudentAttendance}">
                    <tr>
                        <td>${tmpAttendance.dateAttended}</td>
                        <td>${tmpAttendance.day}</td>
                        <td>${tmpAttendance.time}</td>
                        <td>${tmpAttendance.level}</td>
                        <td>${tmpAttendance.rank}</td>
                    </tr>
                </c:forEach>
            </table>

            <label class="col-md-10 col-md-offset-1"> <a
                    href="${pageContext.request.contextPath}/kungfu/list"
                    style="margin-top: 45px; width: 120px; float: left;"class="btn btn-primary">Back to list</a>
            </label>


        </div>
    </div>
</div>
</body>
</html>