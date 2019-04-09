<%@ attribute name="userName" required="true" rtexprvalue="true" %>
<%@ attribute name="password" required="true" %>
<%@ tag body-content="tagdependent" %>


<h1 class="center">Welcome ${userName}</h1>
<h2 class="center">${password}</h2>
<h3 class="center"><jsp:doBody/></h3>