<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>你所访问的页面不存在 (404)</title>
    <link href="${rc.contextPath}/css/error.css" media="screen" rel="stylesheet" type="text/css" />
    <style type="text/css">


        .notice {
            padding: 15px;
            background-color: #fafafa;
            border-left: 6px solid #7f7f84;
            margin-bottom: 10px;
            -webkit-box-shadow: 0 5px 8px -6px rgba(0,0,0,.2);
            -moz-box-shadow: 0 5px 8px -6px rgba(0,0,0,.2);
            box-shadow: 0 5px 8px -6px rgba(0,0,0,.2);
        }
        .notice-sm {
            padding: 10px;
            font-size: 80%;
        }
        .notice-lg {
            padding: 35px;
            font-size: large;
        }
        .notice-success {
            border-color: #80D651;
        }
        .notice-success>strong {
            color: #80D651;
        }
        .notice-info {
            border-color: #45ABCD;
        }
        .notice-info>strong {
            color: #45ABCD;
        }
        .notice-warning {
            border-color: #FEAF20;
        }
        .notice-warning>strong {
            color: #FEAF20;
        }
        .notice-danger {
            border-color: #d73814;
        }
        .notice-danger>strong {
            color: #d73814;
        }

    </style>
</head>

<body>

<h1>访问错误</h1>

<div class="container">
    <div  id="message-alert" class="notice notice-success">
        <strong>Notice</strong> notice-success
    </div>
    <div class="notice notice-danger">
        <strong>Notice</strong>
        <p>Application has encountered an error. Please contact support on ...</p>
        <p>你可能输入了不存在的URL地址，或者该资源已经被删除， <a href="/homepage">点击这里</a> 回到首页.</p>

    </div>
    <div class="notice notice-info">
        <strong>Notice</strong> notice-info
    </div>
    <div class="notice notice-warning">
        <strong>Notice</strong> notice-warning
    </div>
    <div class="notice notice-lg">
        <strong>Big notice</strong> notice-lg
    </div>
    <div class="notice notice-sm">
        <strong>Small notice</strong> notice-sm
    </div>
</div>

    Failed URL: ${url}
    Exception:  ${exception.message}
        <#list  exception.stackTrace as ste>
${ste}
    </#list>

<!--
<h1>404</h1>
<h3>你所访问的页面不存在.</h3>
<hr/>-->
</body>
</html>