<ol class="breadcrumb">
    <li class="active"> <a id="" class="" href="${homepageUrl}"><span class="fa fa-plus-circle"></span> 主页 </a></li>
    <li class="active">个人中心</li>
    <li class="active">
    <@security.authorize        access="isAuthenticated()">

        <a href="${userAccountUrl}">您好，</a>
        <@security.authentication property="principal.mobile"></@security.authentication>   <@security.authentication property="principal.userName"></@security.authentication>
        <@security.authentication property="principal.person.realName" ></@security.authentication>
        <@security.authentication property="principal.company" var="company"></@security.authentication>
        【<#if company??>
    <a href="${companyUrl}"><@security.authentication property="principal.company.companyName"></@security.authentication></a>


        </#if>


        <@security.authentication property="principal.accountType"></@security.authentication>】




    </@security.authorize></li>
<@security.authorize        access="isAuthenticated()">
    <a id="follow" class=" pull-right" href="${logoutUrl}"><span class="fa fa-plus-circle"></span> 退出 </a>
</@security.authorize>

</ol>
