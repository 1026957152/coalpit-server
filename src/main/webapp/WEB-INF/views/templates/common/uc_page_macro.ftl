<#assign subtitle="" />

<!-- html header content macro-->
<#macro header author="" description="">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="${description}">
<meta name="author" content="${author}">
<title>西北煤炭交易用户中心 ${subtitle}</title>
<link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${rc.contextPath}/components/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="${rc.contextPath}/components/sbAdmin2/sb-admin-2.css" rel="stylesheet">
<link href="${rc.contextPath}/components/fontAwesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${rc.contextPath}/css/yizhaomei-usercenter-top.css" rel="stylesheet">


<script type="text/javascript" src="${rc.contextPath}/js/jquery/jquery.js"></script>


<#nested>
</#macro>

<!-- html body wrapper content macro-->
<#macro body>
<div id="wrapper">
    <#include "uc_nav.ftl" />
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <#nested>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<!-- html body wrapper search panel -->
<#macro body_search_panel searchTitle searchProperties>
<div class="panel panel-default">
    <div class="panel-heading">
        <a data-toggle="collapse" href="#searchPanelCol">${searchTitle}</a>
    </div>
    <div id="searchPanelCol" class="panel-collapse collapse in">
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <#list searchProperties?chunk(2) as row>
                <div class="row">
                    <#list row as cell>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="${cell.attr}" class="col-lg-2 control-label">${cell.label}</label>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control" id="${cell.attr}" name="${cell.attr}" placeholder="${cell.placeholder}" >
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
                </#list>
                <div class="row">
                    <div class="col-lg-10">
                        <button type="button" class="btn btn-default pull-right" onclick="refresh()">搜索</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</#macro>

<!-- html body bootstrap table -->
<#macro body_table id data_url data_card_view>
    <table id=${id}
           data-url=${data_url}
           data-classes="table table-hover"
           data-toggle="table"
           data-method="POST"
           data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
           data-query-params-type="unlimit"
           data-query-params="queryParams"
           data-response-handler="handleResponse"
           data-pagination="true"
           data-side-pagination="server"
           data-page-number="1"
           data-page-list="[10]"
           data-page-size="10"
           data-click-to-select="true"
           data-card-view=${data_card_view}>
        <#nested>
    </table>
</#macro>
<#macro body_table_queryParams id data_url data_card_view query_params>
<table id=${id}
               data-url=${data_url}
       data-classes="table table-hover"
       data-toggle="table"
       data-method="POST"
       data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
       data-query-params-type="unlimit"
       data-query-params=${query_params}
       data-response-handler="handleResponse"
       data-pagination="true"
       data-side-pagination="server"
       data-page-number="1"
       data-page-list="[10]"
       data-page-size="10"
       data-click-to-select="true"
       data-card-view=${data_card_view}>
    <#nested>
</table>
</#macro>
<#macro body_table_queryParams_single_select id data_url data_card_view query_params>
<table id=${id}
               data-url=${data_url}
       data-classes="table table-hover"
       data-toggle="table"
       data-method="POST"
       data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
       data-query-params-type="unlimit"
       data-query-params=${query_params}
               data-response-handler="handleResponse"
       data-pagination="true"
       data-side-pagination="server"
       data-page-number="1"
       data-page-list="[10]"
       data-page-size="10"
       data-click-to-select="true"
       data-single-select="true"
       data-card-view=${data_card_view}>
    <#nested>
</table>
</#macro>
<!-- html body javascript content macro-->
<#macro script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/metisMenu/metisMenu.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/sbAdmin2/sb-admin-2.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/usercenter/dashboard.js">

</script>

<#nested>
</#macro>