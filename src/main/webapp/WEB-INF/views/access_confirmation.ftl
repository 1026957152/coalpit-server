<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Sparklr</title>
    <link type="text/css" rel="stylesheet"
          href="../webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
    <script type="text/javascript"
            src="../webjars/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript"
            src="../webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
    <h1>Sparklr</h1>

    <%
    if (session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null
    && !(session
    .getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) instanceof UnapprovedClientAuthenticationException)) {
    %>
    <div class="error">
        <h2>Woops!</h2>

        <p>
            Access could not be granted. (<%=((AuthenticationException) session
            .getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY))
            .getMessage()%>)
        </p>
    </div>


        <h2>Please Confirm</h2>

        <p>
            You hereby authorize "
            "${client.clientId}"
            " to access your protected resources.
        </p>

        <form id="confirmationForm" name="confirmationForm"
              action="${rc.contextPath}/oauth/authorize" method="post">
            <input name="user_oauth_approval" value="true" type="hidden" />

            <button class="btn btn-primary" type="submit">Submit</button>
        </form>


    <div class="footer">
        Sample application for <a
            href="http://github.com/spring-projects/spring-security-oauth"
            target="_blank">Spring Security OAuth</a>
    </div>

</div>

</body>
</html>