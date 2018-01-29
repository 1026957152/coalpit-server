
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



            <li class="dropdown right-right">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li class="divider"></li>
                </ul>
            </li>

        </ul>


    <ul class="nav navbar-nav pull-right">


        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">更多 <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li class="divider"></li>
            </ul>
        </li>

    </ul>

<#if searchUrl??>

    <div class="col-sm-3 col-md-3 pull-right">
        <form class="navbar-form" action="${searchUrl}" role="search">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="输入煤矿名称， 煤种， 公司，区域等信息" name="q">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                </div>
            </div>
        </form>
    </div>
</div>

</#if>
</nav>
