<%--
  Created by IntelliJ IDEA.
  User: arthik.daniel
  Date: 21/06/18
  Time: 2:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%--Error & Status Messages Formatted & Fadeout.--%>
<%
    if (request.getParameter("result") != null) {
%>
<div class="alert alert-success fade in">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>
        <%=request.getParameter("result")%>
    </strong>
</div>
<%
    }
%>

<script type="text/javascript">
    $(document).ready(function () {
        window.setTimeout(function() {
            $(".alert").fadeTo(1000, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 500);
    });
</script>
