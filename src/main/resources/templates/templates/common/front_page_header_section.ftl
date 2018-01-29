<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<style>

    #login-dp{
        min-width: 250px;
        padding: 14px 14px 0;
        overflow:hidden;
        background-color:rgba(255,255,255,.8);
    }
    #login-dp .help-block{
        font-size:12px
    }
    #login-dp .bottom{
        background-color:rgba(255,255,255,.8);
        border-top:1px solid #ddd;
        clear:both;
        padding:14px;
    }
    #login-dp .social-buttons{
        margin:12px 0
    }
    #login-dp .social-buttons a{
        width: 49%;
    }
    #login-dp .form-group {
        margin-bottom: 10px;
    }
    .btn-fb{
        color: #fff;
        background-color:#3b5998;
    }
    .btn-fb:hover{
        color: #fff;
        background-color:#496ebc
    }
    .btn-tw{
        color: #fff;
        background-color:#55acee;
    }
    .btn-tw:hover{
        color: #fff;
        background-color:#59b5fa;
    }
    @media(max-width:768px){
        #login-dp{
            background-color: inherit;

            color: #fff;
        }
        #login-dp .bottom{
            background-color: inherit;
            border-top:0 none;
        }
    }
    .navbar-login
    {
        width: 305px;
        padding: 10px;
        padding-bottom: 0px;
    }

    .navbar-login-session
    {
        padding: 10px;
        padding-bottom: 0px;
        padding-top: 0px;
    }

</style>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button " class="navbar-toggle btn-primary" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <a class="navbar-brand" href="#"><img class="" src="${rc.contextPath}/logo_header.png" style="width:100px; ;"></a>

        <a class="navbar-brand " href="#">web yulinmei.cn</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">

            <#if links??>
                <#list links as link>
                    <li class="">

                        <#if link.url??>
                            <a href="${link.url!''}">


                            ${link.name}

                            </a>

                            <#else>
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"> ${link.name} <b class="caret"></b></a>
                                <ul class="dropdown-menu">

                                    <#list link.subMenu as menu>
                                        <li><a href="${menu.url}">${menu.name}</a></li>

                                    </#list>

                                </ul>
                        </#if>


                    </li>
                </#list>
            </#if>




        </ul>



    <ul class="nav navbar-nav navbar-right">


        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span> 
                <strong>Nombre</strong>
                <span class="glyphicon glyphicon-chevron-down"></span>
            </a>
            <ul style="background-color:white;" class="dropdown-menu">
                <li>
                    <div class="navbar-login">
                        <div class="row">
                            <div class="col-lg-4">
                                <p class="text-center">
                                    <span class="glyphicon glyphicon-user icon-size"></span>
                                </p>
                            </div>
                            <div class="col-lg-8">
                                <p class="text-left"><strong>Nombre Apellido</strong></p>
                                <p class="text-left small">correoElectronico@email.com</p>
                                <p class="text-left">
                                    <a href="#" class="btn btn-primary btn-block btn-sm">Actualizar Datos</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="divider"></li>
                <li>
                    <div class="navbar-login navbar-login-session">
                        <div class="row">
                            <div class="col-lg-12">
                                <p>
                                    <a href="#" class="btn btn-danger btn-block">Cerrar Sesion</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">SIGN IN <span class="caret"></span></a>
            <ul id="login-dp" class="dropdown-menu">
                <li>
                    <div class="row">
                        <div class="col-md-12">
                            Login via
                            <div class="social-buttons">
                                <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                            </div>
                            or
                            <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required="">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputPassword2">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required="">
                                    <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> keep me logged-in
                                    </label>
                                </div>
                            </form>
                        </div>
                        <div class="bottom text-center">
                            New here ? <a href="#"><b>Join Us</b></a>
                        </div>
                    </div>
                </li>
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
