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
<html>
<head>
    <title>Dependency</title>

    <style>
        .error {
            color: red
        }
    </style>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        input {
            margin-bottom: 10px;
        }

        input[type="radio"] {
            width: 15px;
        }

        label {
            width: 250px;
            text-align: left;
        }
    </style>
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
        <h3 align="middle">Save Student</h3>
        <div>
            <form:form class="col-md-6 col-md-offset-3" action="saveStudent" modelAttribute="theStudent" method="POST">

                <!-- Used to update customer if already exists -->
                <form:hidden path="id"/>

                <table class="addStudentTable" style="margin-bottom:50px;margin-left:50px">
                    <tbody>
                    <tr>
                        <td style="padding-left: 20px;padding-top:20px;border-radius: 5px 0 0 0;"><label>First Name
                            (*):</label></td>
                        <td style="padding-right: 20px;padding-top:20px;border-radius: 0 5px 0 0;"><form:input
                                path="firstName"/></td>
                        <form:errors path="firstName" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Last Name (*):</label></td>
                        <td style="padding-right: 20px;"><form:input path="lastName"/></td>
                        <form:errors path="lastName" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>DOB (*):</label></td>
                        <td style="padding-right: 20px;"><form:input type="date" path="dob"/></td>
                        <form:errors path="dob" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Rank (*):</label></td>
                        <td style="padding-right: 20px;">
                            <select name="rank"
                                    style="padding: 6px;border: 1px solid #666;border-radius: 5px;width: 250px;">
                                <option value="1">White</option>
                                <option value="2">Yellow</option>
                                <option value="3">Green</option>
                                <option value="4">Blue</option>
                                <option value="5">Red</option>
                                <option value="6">Black</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Level (*):</label></td>
                        <td style="padding-right: 20px;">
                            <div><input type="radio" name="level" value="Beginner"> Beginner</div>
                            <div><input type="radio" name="level" value="Intermediate"> Intermediate</div>
                            <div><input type="radio" name="level" value="Advanced"> Advanced</div>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Mobile (*):</label></td>
                        <td style="padding-right: 20px;"><form:input path="mobile"/></td>
                        <form:errors path="mobile" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Email (*):</label></td>
                        <td style="padding-right: 20px;"><form:input path="email"/></td>
                        <form:errors path="email" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Door No:</label></td>
                        <td style="padding-right: 20px;"><form:input path="doorNo"/></td>
                        <form:errors path="doorNo" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Street:</label></td>
                        <td style="padding-right: 20px;"><form:input path="street"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>City:</label></td>
                        <td style="padding-right: 20px;"><form:input path="city"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Province:</label></td>
                        <td style="padding-right: 20px;"><form:input path="province"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Postal Code:</label></td>
                        <td style="padding-right: 20px;"><form:input path="postalCode"/></td>
                        <form:errors path="postalCode" cssClass="error"/>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Primary Contact Name:</label></td>
                        <td style="padding-right: 20px;"><form:input path="primaryContact"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Primary Contact Number:</label></td>
                        <td style="padding-right: 20px;"><form:input path="primaryContactMobile"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Primary Contact Email:</label></td>
                        <td style="padding-right: 20px;"><form:input path="primaryContactEmail"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Secondary Contact Name:</label></td>
                        <td style="padding-right: 20px;"><form:input path="secondaryContact"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Secondary Contact Number:</label></td>
                        <td style="padding-right: 20px;"><form:input path="secondaryContactMobile"/></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 20px;"><label>Secondary Contact Email:</label></td>
                        <td style="padding-right: 20px;"><form:input path="secondaryContactEmail"/></td>
                    </tr>

                    <tr>
                        <td style="border-radius: 0 0 0 5px"><div style="width: 30px; margin-top: 30px;" align="right">
                            <a href="${pageContext.request.contextPath}/kungfu/list" class="btn btn-primary">Back</a>
                        </div></td>
                        <td style="border-radius: 0 0 5px 0">

                            <div style="width: 30px">
                                <input type="submit" value="Save" class="save btn btn-primary"/>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>