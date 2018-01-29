<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />


<!DOCTYPE html>
<html>
<head>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.css" rel="stylesheet">
<link href="${rc.contextPath}/components/bootstrap_datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">


    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <style type="text/css">

        .first {
            width: 10%;
        }

        .second {
            width: 20%;
        }
        .third {
            width: 10%;
        }

        .forth {
            width: 10%;
        }

        .img-comment-list  > div {
            display:table-cell;
        }

        .img-comment-list img {
            border-radius:8%;
            width: 100px;
            height: 100px;
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
    </style>


</head>
<body>


<div class="container" style="margin-bottom:50px; margin-top:10px">

<#include "./common/front_page_header_section.ftl">

<h1 class="page-header">
    <small>位置信息</small>

</h1>
<ol class="breadcrumb">
    <li class="active">账户信息</li>
    <li class="active">公司详情</li>
</ol>


<div class="row col-lg-12" >
<a href="{frontUrl}">首页详情页面</a>



<div role="" class="" id="">

    <ul class="nav nav-tabs" style="margin-bottom: 15px" id="myTab">
        <li class="active"><a name="map_current" href="#map_current" role="tab" data-toggle="tab">当前</a></li>


        <li><a name="map_update" href="#map_update" role="tab" data-toggle="tab">更新</a></li>


    </ul>
    <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="map_current">
        <div class="form-group">
            <input id="" class="form-control " value="${location.longitude!''}, ${location.latitude!''}"/>
        </div>


        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SHgVOH45YkrihCytDtHSEx2g"></script>
        <div id="allmap" style="width:100%;height:500px;">

        </div>


        <script type="text/javascript">
            var map = new BMap.Map("allmap");
            var point ;// 创建地图实例


            <#if location.longitude??>
            point = new BMap.Point(${location.longitude},${location.latitude});  // 创建点坐标
            var marker = new BMap.Marker(point);        // 创建标注
            map.addOverlay(marker);
            map.centerAndZoom(point, 14);                 // 初始化地图，设置中心点坐标和地图级别
            map.panBy(305,165);
            <#else>
            point = new BMap.Point(116.404, 39.915);  // 创建点坐标
            map.centerAndZoom(point, 10);                 // 初始化地图，设置中心点坐标和地图级别
            var marker = new BMap.Marker(point);        // 创建标注
            map.addOverlay(marker);
            </#if>


            //map.addControl(new BMap.NavigationControl(opts));
            map.addControl(new BMap.NavigationControl());
            map.addControl(new BMap.ScaleControl());
            var opts = {
                //width : 250,     // 信息窗口宽度
                //height: 100,     // 信息窗口高度
                title : "详细地址" , // 信息窗口标题
                title : "详细地址"  // 信息窗口标题
            }
          //  var infoWindow = new BMap.InfoWindow('{company.location!''}', opts);  // 创建信息窗口对象
          //  map.openInfoWindow(infoWindow, map.getCenter());
        </script>

    </div>
    <div role="tabpanel" class="tab-pane " id="map_update">

        <form id="longitudeLatitudeForm" class="navbar-form" role="search" action="${updateLongitudeLatitudeUrl}">

            <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}"/>

            <div class="form-group">
                <input type="text" class="form-control" name="longitudeLatitude" placeholder="longitude 经度,latitude 纬度" value="<#if location.longitude??>${location.longitude!''},${location.latitude!''}<#else></#if>">
            </div>
<#--            <div class="form-group">
                <input type="text" class="form-control" name="latitude" placeholder="latitude 纬度" value="${destinationLatAndLng.bd09Lat!''}">
            </div>-->
            <button id="longitudeLatitudeFormFormBtn" type="button" class="btn btn-primary  btn-lg">更新</button>

            <script  type="text/javascript">

                $("#longitudeLatitudeFormFormBtn").click(function() {
                    alert($('#longitudeLatitudeForm').serialize());
                    var req = $.ajax({
                        url:  $('#longitudeLatitudeForm').attr('action'),
                        type: 'POST',
                        data:  $('#longitudeLatitudeForm').serialize(),
                    });
                    req.done(function (data) {
                        alert("成功:"+data.message);

                        if (data.status) {
                            alert("成功:"+data.message);

                            window.location.href = data.link;
                        } else {
                            alert(data.message);
                        }
                    });
                });
            </script>
        </form>
        <iframe src="http://api.map.baidu.com/lbsapi/getpoint/index.html" frameborder="0" width="1100" scrolling="No" height="1000" leftmargin="0" topmargin="0"></iframe>

    </div>
    </div>

</div>








</div>



</div>
<div>


<script type="text/javascript" src="${rc.contextPath}/components/jquery/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/jquery/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_datepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_datepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/uc/company.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/jquery.cxselect.min.js"></script>
<script>
    $.cxSelect.defaults.url = '${rc.contextPath}/js/cityData.min.json';

    $('#city_china').cxSelect({
        selects: ['province', 'city', 'area']
    });
    $('#destination_city_china').cxSelect({
        selects: ['province', 'city', 'area']
    });


    $('#city_china_val').cxSelect({
        selects: ['province', 'city', 'area'],
        nodata: 'none'
    });
</script>
<script type="text/javascript">

    function queryParams(params) {

        params.page = params.pageNumber - 1;
        params.size = params.pageSize;

        var imageName = "";
        var homepageImage = "";
        if (imageName) {
            params.imageName = imageName;
        }
        if (homepageImage) {
            params.homepageImage = homepageImage;
        }
        return params;
    }
    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
        return res;
    }

    function senderInfoFormatter(value, row, index) {

        return  ' <div class="img-comment-list">  <div  class="comment-img"  > <img class="" src="'+row.url+'"/> </div>'+
                ' <div class="comment-text">'+
                '<strong><a href="/person?id=" '+ row.imageTitle + '>' + row.imageTitle  + '</a></strong>'+
                '<p class="">'+ row.emailAddress + '</p> '+
                '</div>'+
                ' </div>';

    }
    function selectedRow() {
        var row = $('#zoneImages-table').bootstrapTable('getSelections');
        return row;
    }
    function refresh() {
        $('#homeImages-table').bootstrapTable('refresh');
    }



    $(function(){
        $(".form_date").datetimepicker({
            language:  'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: 1,
            minView: 2,
            weekStart: 1
        });


        $(".popover-top").popover({
        });

        var parseTruckStatus = function() {
            $('#pageData .rowContent').each(function() {
                var curTruckStatus = $(this).find(".truckStatus").text();
                var curTruckStatusTag = $(this).find(".truckStatus");
                if (curTruckStatus == 'available')
                    curTruckStatusTag.html('尚未发车');
                else
                    curTruckStatusTag.html('送货中');
            });

        }





        $("#basicInfoToggleMode").click(function(){
            $(this).addClass("hidden");
            $("#companyForm_basicInfo .form-group .hidden").each(function(){
                $(this).removeClass("hidden");
            });


            $("#companyForm_basicInfo .form-group .disabled").each(function(){
                $(this).removeClass("disabled");
            });
            $("#companyForm_basicInfo .btns .hidden").each(function(){
                $(this).removeClass("hidden");
            });
            $("#companyForm_basicInfo p[class='form-control-static']").each(function(){
                $(this).addClass("hidden");
            });
        });

        $("#bizInfoToggleMode").click(function(){
            $(this).addClass("hidden");
            $("#companyForm_bizInfo .form-group .hidden").each(function(){
                $(this).removeClass("hidden");
            });


            $("#companyForm_bizInfo .form-group .disabled").each(function(){
                $(this).removeClass("disabled");
            });
            $("#companyForm_bizInfo .btns .hidden").each(function(){
                $(this).removeClass("hidden");
            });
            $("#companyForm_bizInfo p[class='form-control-static']").each(function(){
                $(this).addClass("hidden");
            });
        });

        $("#regInfoToggleMode").click(function(){
            $(this).addClass("hidden");
            $("#companyForm_regInfo .form-group .hidden").each(function(){
                $(this).removeClass("hidden");
            });


            $("#companyForm_regInfo .form-group .disabled").each(function(){
                $(this).removeClass("disabled");
            });
            $("#companyForm_regInfo .btns .hidden").each(function(){
                $(this).removeClass("hidden");
            });
            $("#companyForm_regInfo p[class='form-control-static']").each(function(){
                $(this).addClass("hidden");
            });
        });




        $("#toggleMode").click(function(){
            $(this).addClass("hidden");
            $("#companyForm .form-group .hidden").each(function(){
                $(this).removeClass("hidden");
            });
            $("#companyForm .form-group .disabled").each(function(){
                $(this).removeClass("disabled");
            });
            $("#companyForm .btns .hidden").each(function(){
                $(this).removeClass("hidden");
            });
            $("#companyForm p[class='form-control-static']").each(function(){
                $(this).addClass("hidden");
            });
        });

/*        $(".nav-tabs a").bind('click', null, function(){
            $(".nav-tabs li").removeClass("active");
            $(this).closest('li').addClass("active");
            var tabName = $(this).attr("name");
            $("#companyForm_"+tabName+" div[class*=Info]").addClass("hidden");
            $("#companyForm_"+tabName+" ." + tabName).removeClass("hidden");
        });*/
    });
</script>
<script type="text/javascript">


    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    })
    $("#deleteModalBtn").click(function() {

    alert("ddddddd");
        var row = selectedRow();
        if (row == '') {

            return null;
        }

        var req = $.ajax({
            url:  $(this).attr('ref'),
            type: "POST",
            data:{ id: row[0].id}
        });
/*        req.done(refresh){
            $('#homeImages-table').bootstrapTable('refresh');
        };*/
    });
    $("#submit_regInfo").bind('click', function(e){
        alert($('#companyForm_regInfo').serialize());

      var req = $.ajax({
            url:  $('#companyForm_regInfo').attr('action'),
            type: 'post',
            data: $('#companyForm_regInfo').serialize(),
        });
        req.done(function (data) {

            alert("json" + JSON.stringify(data));

            if (data.status) {
              //  $('#pending-enter-table').bootstrapTable('refresh');

            } else {
                alert(data.message);
            }
        });
    });


    $("#submit_bizInfo").bind('click', function(e){
        alert($('#companyForm_bizInfo').serialize());

        var req = $.ajax({
            url:  $('#companyForm_bizInfo').attr('action'),
            type: 'post',
            data: $('#companyForm_bizInfo').serialize(),
        });
        req.done(function (data) {

            alert("json" + JSON.stringify(data));

            if (data.status) {



            } else {
                alert(data.message);
            }
        });
    });


</script>
</body>
</html>