
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button " class="navbar-toggle btn-primary" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><img class="" src="/logo_header.png" style="width:90px; ;"></a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">

        <#if links??>
            <#list links as link>

                <#if link.url??>
                    <li class="">
                        <a href="${link.url}">


                        ${link.name}

                        </a>
                    </li>

                <#else>
                    <li class="">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> ${link.name} <b class="caret"></b></a>
                        <ul class="dropdown-menu">

                            <#list link.subMenu as menu>
                                <li><a href="${menu.url}">${menu.name}</a></li>

                            </#list>

                        </ul>
                    </li>
                </#if>


            <#--
                                <li class=""><a href="${link.url}">${link.name}</a></li>
            -->
            </#list>
        </#if>





        </ul>


        <ul class="nav navbar-right pull-right ">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                    <img alt="" class="img-circle" src="https://static1.squarespace.com/static/55198f1ce4b00c2cab3e5e30/t/5526d500e4b009f3ec94b422/1428608282728/600x600%26text%3Dprofile+img.gif?format=300w" width="30">
        <span class="hidden-xs">
        <@security.authorize        access="isAuthenticated()">
            您好         <@security.authentication property="principal.mobile"></@security.authentication>            <@security.authentication property="principal.userName"></@security.authentication>
            <@security.authentication property="principal.person.realName" ></@security.authentication>
            <@security.authentication property="principal.company" var="company"></@security.authentication>
            【<#if company??><@security.authentication property="principal.company.companyName"></@security.authentication></#if>
            <@security.authentication property="principal.accountType"></@security.authentication>】
        </@security.authorize>


        </span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${userAccountUrl}"><i class="fa fa-fw fa-user"></i> 编辑个人信息</a></li>
                    <li><a href="${companyUrl}"><i class="fa fa-fw fa-cog"></i> 公司信息</a></li>

                <@security.authorize        access="isAuthenticated()">
                    <li class="divider"></li>
                    <li><a href="${logoutUrl}"><i class="fa fa-fw fa-power-off"></i> 退出</a></li>

                </@security.authorize>

                </ul>
            </li>
        </ul>
    </div>
</nav>
