<%--
  Created by IntelliJ IDEA.
  User: arthik.daniel
  Date: 21/06/18
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<form:form action="searchForStudent" method="POST" class="pull-right">
    <div class="input-group changethisone">
        <input type="text" name="theSearchString" class="form-control"
               placeholder="Enter Student to Search"/>
        <span class="input-group-addon"><i class="glyphicon glyphicon-search" onclick="submit()"></i></span>
    </div>
    <%--<div style="margin-left: 20px" onClick="window.location.href='addStudent'; return false;" class="input-group-addon"><i class="glyphicon glyphicon-plus" ></i></div>--%>
</form:form>



