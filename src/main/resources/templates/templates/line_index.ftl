<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>榆林煤 搜索</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
   <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <style type="text/css">


        .target-fix {
            padding-top: 45px;
            margin-top: -10px;
            display: block;
            height: 0;
            overflow: hidden;
        }

        .first {
            width: 10%;
        }

        .second {
            width: 30%;
        }
        .third {
            width: 40%;
        }

        .forth {
            width: 10%;
        }

        .img-comment-list  > div {
            display:table-cell;
        }

        .img-comment-list img {
            border-radius:50%;
            width: 80px;
            height: 80px;
            margin-right: 10px;
            margin-top: 20px;
        }

        .img-comment-list p {
            margin: 0;
        }

        .img-comment-list span {
            font-size: .8em;
            color: #aaa;
        }

        .xs-first {
            width: 25%;
        }

        .xs-second {
            width: 25%;
        }
    </style>


    <style type="text/css">
    /*
LISTINGS
*/



    .tab-box {
        background: #f8f8f8;
        position: relative;
    }

    .tab-filter {
        position: absolute;
        right: 0;
        top: 0;
    }


    .adds-wrapper {
        background: #fff;
        clear: both;
        display: block;
        height: auto;
        overflow: auto;
        width: 100%;
    }
    .listing-filter {
        border-bottom: solid 1px #ddd;
        padding: 15px 0;
    }

    .listings p {
        margin: 0;
    }
    .listings h3 {
        margin: 0;
    }
    .listings .listing-row {
        border-bottom: 1px solid #e6e6e6;
        padding-top: 10px;
        padding-bottom: 10px;
    }
    .listings .listing-row:nth-child(even) {
        background: #fafafa;
    }
    .listings .premium.listing-row {
        background: #FFFFDD;
        background: #E0F4FF;
        border-bottom: 1px solid #c6ebff;
        padding-top: 10px;
        padding-bottom: 10px;
        position: relative;
    }
    .listings .listing-row.last {
        border-bottom: 1px solid #fff;
    }
    .recent-listings .panel-body {
        padding: 0 15px;
    }
    .recent-listings .price-text {
        text-align: right;
    }
    .recent-listings .listing-row {
        border-bottom: 1px solid #e6e6e6;
        padding-top: 10px;
        padding-bottom: 10px;
    }
    .recent-listings .listing-row:nth-child(even) {
        background: #fafafa;
    }
    .ad-options {
        margin: 0;
        padding: 0;
    }
    .ad-options li {
        display: inline;
        list-style-type: none;
        padding-right: 20px;
    }
    .account-sidebar h3 {
        margin: 0;
    }
    .home-search {
        padding-bottom: 0;
    }
    .home-search .main_description {
        text-align: center;
    }
    .home-search .form-control {
        padding: 10px 8px;
    }
    .home-search .input-group-addon {
        padding: 0;
    }
    .home-search .input-group-addon.input-group-addon-text {
        background: #ffffff;
        color: #000;
        border: none;
        padding-right: 20px;
    }
    .home-search .input-group-addon .btn {
        padding: 9px 18px;
    }
    .home-search .input-group-addon li a {
        text-align: left;
        padding: 10px 18px;
    }
    .home-search .input-group-addon .btn {
        text-transform: none;
    }
    .home-search .input-group-addon .btn {
        color: #000;
        font-weight: 100;
    }
    .home-search .input-group-addon .btn .dropdown-menu ul il a {
        text-align: left;
    }
    .featured-gallery {
        border: none;
        padding-left: 15px;
        padding-right: 15px;
        margin-bottom: 0px;
    }
    .featured-gallery img {
        text-align: center;
        height: 60px;
        width: 121px;
    }
    .featured-gallery .featured-thumbnail {
        margin-bottom: 5px;
        padding-left: 2px;
        padding-right: 2px;
    }
    .featured-gallery .featured-thumbnail img {
        width: 100%;
    }
    #listings-page .price {
        font-size: 24px;
        text-align: left;
    }
    #listings-page hr {
        margin-bottom: 10px;
    }
    #visualization {
        height: 300px;
        width: 98%;
        margin-top: 40px;
        margin-bottom: 40px;
    }
    p.muted {
        color: #999999;
    }
    .edit-listings tr:hover .remove-ad {
        display: inline;
    }
    .edit-listings tr:hover .extend-ad:after {
        content: " | ";
        color: #222222;
    }
    .edit-listings .no-views {
        color: #555555;
        margin-left: 10px;
    }
    .edit-listings .edit-ad:after {
        content: " | ";
        color: #222222;
        text-decoration: none !important;
    }
    .edit-listings .edit-ad:after:hover {
        text-decoration: none;
    }
    .edit-listings .remove-ad {
        color: #FF0000;
        display: none;
    }
    .edit-listings .remove-ad:hover {
        color: #FF0000;
        text-decoration: underline;
    }
    .edit-listings .edit-ad {
        color: #79a618;
    }
    .edit-listings .edit-ad:hover {
        color: #79a618;
        text-decoration: underline;
    }
    .edit-listings .extend-ad {
        color: #79a618;
    }
    .edit-listings .extend-ad:hover {
        color: #79a618;
        text-decoration: underline;
    }
    .nav-category .remove-category {
        display: none;
    }
    .nav-category li:hover .remove-category {
        display: block;
        float: right;
    }
    .nav-category li:hover .remove-category i {
        color: #FF0000;
    }
    #gallery .thumbnail img {
        max-height: 80px;
    }
    #my-dropzone .dropzone .dz-default.dz-message {
        width: 100%;
    }
    @media (min-width: 768px) {
        #listings-page .price {
            text-align: right;
        }
        .footer {
            text-align: left;
        }
        .footer .footer-links {
            float: right;
        }
    }
    #modalLogin .modal-dialog,
    #modalSignup .modal-dialog {
        width: 400px;
    }
    .topbar {
        border: 3px solid #D2160A;
    }
    .post-ad-btn {
        padding: 2px 10px;
        height: 25px;
        width: auto;
        margin-left: 5px;
    }
    .search-btn {
        width: 180px;
        float: none;
    }
    .form-inline .form-control {
        width: 100%;
    }
    /*Just for preview*/
    #theme_switcher {
        top: 10px;
        left: 10px;
        position: fixed;
    }

    </style>
    <style type="text/css">

    .list-group-unbordered>.list-group-item {
        border-left: 0;
        border-right: 0;
        border-radius: 0;
        padding-left: 0;
        padding-right: 0;
    }
    .box.box-primary {
        border-top-color: #3c8dbc;
    }
    .box {
        position: relative;
        border-radius: 3px;
        background: #ffffff;
        border-top: 3px solid #d2d6de;
        margin-bottom: 20px;
        width: 100%;
        box-shadow: 0 1px 1px rgba(0,0,0,0.1);
    }
    .box-body {
        border-top-left-radius: 0;
        border-top-right-radius: 0;
        border-bottom-right-radius: 3px;
        border-bottom-left-radius: 3px;
        padding: 10px;
    }
    </style>


</head>

<body>
<div class="container" style="margin-bottom:80px; margin-top:10px ">

<#include "./common/front_page_header_section.ftl">

<div class=" well hidden" data-offset-top="100" ><!--data-spy="affix"-->

        <div class="input-group">
            <div class="input-group-btn search-panel">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span id="search_concept">全部</span> <span class="camake-list ret"></span>
                </button>
                <ul class="dropdown-menu" role="menu"  style="z-index:99999">

                    <li><a href="#contains">找公司</a></li>
                    <li><a href="#its_equal">找供应商</a></li>
                    <li><a href="#greather_than">找货源</a></li>
                    <li class="divider"></li>
                </ul>
            </div>
            <input type="hidden" name="search_param" value="all">
            <input type="text" class="form-control"  id="search_param"  name="x" value="${q!''}" placeholder="输入搜索关键字...，如 神木, 三八块">
                <span class="input-group-btn">
                    <button class="btn btn-info searchBtn" type="button"><span class="glyphicon glyphicon-search "></span></button>
                </span>
        </div>

</div>




    <div class="row "  style="">


        <div class="col-sm-12">
            <div class="box hidden box-primary">
                <div class="box-body box-profile">
                    <div class="list-group list-group-unbordered">
                        <li class="list-group-item">
                            <h4 class="list-group-item-heading">
                                运力申请
                                <span class="small pull-right" style="padding-top:.2em">换一批&nbsp;&nbsp;更多&gt;</span>
                            </h4>
                        </li>




                    </div>
                </div>
            </div>

            <div class="tab-box ">

                <ul class="nav nav-tabs add-tabs" id="ajaxTabs" role="tablist">
                    <li class="active"><a href="#companies" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false">公司 <span class="badge"></span></a></li>
                </ul>
                <div class="tab-filter">
                    <div class="" tabindex="0">
                        <select class="selectpicker " data-style="btn-select" data-width="auto" tabindex="-1">
                        <option value="Short by">Short by</option>
                        <option value="Price: Low to High">价格: 低 to 高</option>
                        <option value="Price: High to Low">价格: 高 to 低</option>
                    </select>

                    </div>
                </div>
            </div>
            <div class="listing-filter">
                <div class="pull-left col-xs-6">
                    <div class="breadcrumb-list hidden"> <a href="#" class="current"> <span>All ads</span></a> in New York <a href="#selectRegion" id="dropdownMenu1" data-toggle="modal"> <span class="caret"></span> </a> </div>
                </div>
                <div class="pull-right col-xs-6 text-right listing-view-action"> <span class="list-view active"><i class="  icon-th"></i></span> <span class="compact-view"><i class=" icon-th-list  "></i></span> <span class="grid-view"><i class=" icon-th-large "></i></span> </div>
                <div style="clear:both"></div>
            </div>
             <div  class="tab-content">
                 <div id="toolbar" class="btn-group" style="padding-top: 10px;padding-bottom: 10px">

                     <button id="viewCapacityBtn" type="button" class="btn btn-success">
                         <i class="">查看详情</i>
                     </button>
                     <button id="deleteBtn_" type="button" class="btn btn-primary" >
                         添加
                     </button>


                     <button id="editBtn" type="button" class="btn btn-primary" >
                         修改
                     </button>

                     <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                         添加
                     </button>

                     <script type="text/javascript">


                         function refresh() {
                             $('#station-table').bootstrapTable('refresh');
                         }

                         function selectedRow_() {
                             var row =  $('#station-table').bootstrapTable('getSelections');
                             return row;
                         }


                         $("#editBtn").click(function() {
                             var row = selectedRow_();

                             if (row != '') {
                                 $('#addStationModal').modal();
                                 alert(JSON.stringify(row[0]));
                                 $('#addStationModalForm .companyId').val(row[0].id);

                             }
                         });



                     </script>


                 </div>


                    <div class="tab-pane active" id="companies">
                        <table class=" table-striped" id="companies-table" data-url="${stationsUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
                               data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
                               data-query-params-type="unlimit"
                               data-query-params="queryParams_company"
                               data-response-handler="handleResponse"
                               data-pagination="true"
                               data-side-pagination="server"
                               data-page-number="1"
                               data-page-list="[10]"
                               data-page-size="10"
                               data-click-to-select="true"
                               data-single-select="true">
                            <thead>
                            <tr>



                                <th data-field="lineName">名称</th>

                                <th data-field="type">类型</th>
                                <th data-field="companyId">公司ID</th>
                                <th data-field="locationId">位置ID</th>
                                <th data-field="location">位置</th>

                                <th data-field="description">描述</th>

<#--
                                <th data-field="companyName | senderCompanyName"  data-formatter="companyInfoFormatter">发送者</th>
-->
                            </tr>
                            </thead>
                        </table>

                 </div>
             </div>


        </div>




    </div>


<div id="addLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加区域</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="well">

                            <form id="addLineModalForm"   novalidate="novalidate" action="${command_create_url}">
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId hidden" name="companyId" value=""  >








                                <div class="form-group">
                                    <label for="username" class="control-label">名称</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId form-control" name="lineName" value=""  >


                                    <span class="help-block"></span>
                                </div>


                                <div class="form-group">
                                    <label for="username" class="control-label">描述</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId form-control" name="description" value=""  >
                                    <span class="help-block"></span>
                                </div>



                                <div class="form-group">
                                    <label for="username" class="control-label">位置</label>

                                    <select class="selectpicker" <#--data-max-options="2" --> id="departureStation" name="departureStation" class="form-control" placeholder="特征">
                                    <#-- <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">-->

                                    <#if stations??>
                                        <#list stations as feature>
                                            <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                        </#list>
                                    </#if>

                                    </select>



                                    </select>
                                    <span class="help-block"></span>
                                </div>

                                <div class="form-group">
                                    <label for="username" class="control-label">位置</label>

                                    <select class="selectpicker" <#--data-max-options="2" --> id="arrivalStation" name="arrivalStation" class="form-control" placeholder="特征">
                                    <#-- <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">-->

                                    <#if stations??>
                                        <#list stations as feature>
                                            <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                        </#list>
                                    </#if>

                                    </select>



                                    </select>
                                    <span class="help-block"></span>
                                </div>

                                <button id="addLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                            </form>
                            <script  type="text/javascript">

                                $("#addLineModalFormBtn").click(function() {
                                    alert($('#addLineModalForm').serialize());

                                    var req = $.ajax({
                                        url:  $('#addLineModalForm').attr('action'),
                                        type: 'post',
                                        data:  $('#addLineModalForm').serialize(),
                                    });
                                    req.done(function (data) {
                                        if (data.status) {
                                            alert("成功:"+data.message);
                                            window.location.reload(true);
                                        } else {
                                            alert(data.message);
                                        }
                                    });
                                });
                            </script>
                        </div>


                    </div>
                </div>




            </div>
        </div>
    </div>
</div>

<div id="editLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加区域</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="well">

                            <form id="editLineModalForm"   novalidate="novalidate" action="${command_edit_url}">
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="id hidden" name="id" value=""  >

                                <div class="form-group">
                                    <label for="username" class="control-label">名称</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="name form-control" name="name" value=""  >


                                    <span class="help-block"></span>
                                </div>

                                <div class="form-group">
                                    <label for="username" class="control-label">邮编</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="postalCode form-control" name="postalCode" value=""  >
                                    <span class="help-block"></span>
                                </div>

                                <div class="form-group">
                                    <label for="username" class="control-label">描述</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="description form-control" name="description" value=""  >
                                    <span class="help-block"></span>
                                </div>



                                <div class="form-group">
                                    <label for="username" class="control-label">特征</label>

                                    <select class="selectpicker" data-max-options="2"  id="feature" name="feature" class="form-control" placeholder="特征">
                                    <#-- <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">-->

                                    <#if featuresEnum??>
                                        <#list featuresEnum as feature>
                                            <option value="${feature.id}" >${feature.id!''}--${feature.displayName!''}</option>

                                        </#list>
                                    </#if>

                                    </select>



                                    </select>
                                    <span class="help-block"></span>
                                </div>


                                <button id="editLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                            </form>
                            <script  type="text/javascript">

                                $("#editLineModalFormBtn").click(function() {
                                    alert($('#editLineModalForm').serialize());

                                    var req = $.ajax({
                                        url:  $('#editLineModalForm').attr('action'),
                                        type: 'put',
                                        data:  $('#editLineModalForm').serialize(),
                                    });
                                    req.done(function (data) {
                                        if (data.status) {
                                            alert("成功:"+data.message);
                                            window.location.reload(true);
                                        } else {
                                            alert(data.message);
                                        }
                                    });
                                });
                            </script>
                        </div>


                    </div>
                </div>




            </div>
        </div>
    </div>
</div>

<#include "./common/page_foot_section.ftl">

<#include "./common/hotline_section.ftl">




</body>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>

<script>
    $(document).ready(function(){
    });
</script>
<script type="text/javascript">
function originToDestinationInfoFormatter(value, row, index) {



    return '<div class="">'  + row.origin  +
            '<hr style="margin-top: 0px;       margin-bottom: 0px;" >'   +'<span class="pull-right" style="   margin-bottom: 0px; padding-bottom: 0px; ">'+ row.destination  +'</span></div>';

}
    function queryParams_company(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;

        var sender = $.trim($("#search_param").val());

        if (sender) {
            params.q = sender;
        }
      //  alert(JSON.stringify(sender))
        return params;
    }

    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;

        var sender = $.trim($("#search_param").val());

        if (sender) {
            params.q = sender;
        }
        //alert(JSON.stringify(sender))
        return params;
    }
    $('#supplies-table').bootstrapTable({
        onLoadSuccess: function (data) {
            $('[data-trigger="hover"]').popover();

        }
    });



    function ompanyInfoFormatter(value, row, index) {


        return  ' <div class="img-comment-list">  <div  class="comment-img"  > <img class="" src="'+row.companyLogoUrl+'"/> </div>'+
                ' <div class="comment-text">'+
                '<strong><a href="'+ row.companyUrl + '">' + row.companyName  + '</a></strong>'+
                '<p class="">@'+ row.inventoryCounty + '</p> '+
                '</div>'+
                ' </div>';



    }

  /*  function companyInfoFormatter(value, row, index) {



        var inventories = "";
        $.each(row.inventories, function (n, value) {
            //  alert(n + ' ' + value);
            var trs = "";
            trs += "<a href='"+value.storageUrl+"'>" + value.storageName + "</a> 存 " + value.quantityOnHand + " 吨 ";
            inventories += trs;
        });

        var indicators = "";
        $.each(row.indicators, function (n, value) {
            //  alert(n + ' ' + value);
            var trs = "";
            trs += "" + value.symbol + " " + value.value + "  "+value.unit;
            indicators += trs;
        });

        return "    <div class='col-sm-3 no-padding photobox'>"+
        '                <div class=" carousel-row">'+
                ' <div class=" slide-row">'+
                ' <div id="carousel-1" class="carousel slide slide-carousel" data-ride="carousel">'+
                '  <!-- Indicators -->'+
        '  <ol class="carousel-indicators">'+
        '  <li data-target="#carousel-1" data-slide-to="0" class="active"></li>'+
        '  <li data-target="#carousel-1" data-slide-to="1"></li>'+
        '  <li data-target="#carousel-1" data-slide-to="2"></li>'+
        '  </ol>'+

        '      <!-- Wrapper for slides -->'+
        '   <div class="carousel-inner">'+
        '          <div class="item active">'+
        '           <img src="'+row.companyLogoUrl+'" alt="Image">'+
        '             </div>'+

        '  </div>'+
        '   </div>'+
        '    <div class="slide-content">'+
        '          <h4><a href=" '+ row.companyUrl + '">'+ row.companyName+'<a></h4>'+

        '  </div>'+
        '  </div>'+

        '    </div>'+
        '    </div>'+

        '    </div>'+

            //row.companyDesc+


    '<div class="col-sm-7 add-desc-box">'+
               ' <div class="add-details">'+
               ' <h4 class="add-title"> <a href="'+row.url+'"> '+ row.granularity+' </a> <small>'+  row.companyAddress+'</small> </h4>'+
    ' <span class="info-row"> <span class="add-type business-ads tooltipHere" data-toggle="tooltip" data-placement="right" title="Business Ads"> </span> <span class="date"><i class=" icon-clock"> </i> '+row.updateTime+' </span>  <span class="category"> </span> <span class="item-location"><i class="fa fa-map-marker"> '+   row.companyAddress+'</i>  </span> </span> </div>'+
       '<hr>'+
        inventories+'<br>'+indicators+'<br>'+


       ' </div>'+
        '  <div class="slide-footer hidden">'+
        '        <span class="pull-right buttons">'+
        '         <button class="btn btn-sm btn-default"><i class="fa fa-fw fa-eye"></i> Show</button>'+
        '    <button class="btn btn-sm btn-primary"><i class="fa fa-fw fa-shopping-cart"></i> Buy</button>'+
        '    </span>'+
        '    </div>';

    }

*/
    function supplyCompanyInfoFormatter(value, row, index) {


        var warehouseInfo = ""

        warehouseInfo = "堆场名称：" + row.warehouseStatistic.name +"\n" +
                "当前正在装车： " +row.warehouseStatistic.countShipmentsLoading + "\n" +
                "当前等待装车：" + row.warehouseStatistic.countShipmentsCreated+ "\n" ;



        return  '                <div class=" carousel-row" data-trigger="hover" title="'+row.companyDesc+ '" data-content="'+ warehouseInfo+'" >'+
                ' <div class=" slide-row">'+
                ' <div id="carousel-1" class="carousel slide slide-carousel" data-ride="carousel">'+
                '  <!-- Indicators -->'+
        '      <!-- Wrapper for slides -->'+

        '          <div class="item active">'+
        '           <img src="logo.png" alt="Image">'+
        '          </div>'+

        '   </div>'+
        '    <div class="slide-content">'+
        '          <h4><a href=" '+ row.companyUrl + '"> '+ row.companyName+'<a></h4>'+
        '    <p>'+

        '    </p>'+
        '  </div>'+

        '    </div>';

    }


    function supplyInfoFormatter(value, row, index) {




        var List = row.qualityItems;
        var personString = "";
        for(var student in List){ //第二层循环取list中的对象
            personString += "<strong>"+List[student].qualityItemName +" "+List[student].exp+ " "+List[student].value+"</strong> |";
        }


        return  " <h3><a class='' href='"+row.url+"'>"+row.coalCategory+" - "+row.granularity+"- <strong>￥"+row.price+"</strong></a></h3>" +
         "       <p class='muted'>地址：<strong>"+row.deliveryPlace+"</strong></p>"+
        "<p class='muted'>发布时间："+row.createdDateString+"<a href='#' class='underline'>Cars, Vans &amp; Motorbikes</a></p>"+
        "<p>"+row.qualityContent+"</p>"+

                "  <p class='ad-description'>"+
                personString +

                " </p>";

    }

    function refresh() {
      //  $('#role-table').bootstrapTable('refresh');
        // $('#capacity-table').bootstrapTable('refresh');
        $('#companies-table').bootstrapTable('refresh');


    }

    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
       // alert(JSON.stringify(original));
        return res;
    }

$(function(){

    $('.selectpicker').selectpicker();



    $('.searchBtn').bind('click', function(){
        refresh();

    });






})
</script>

</html>