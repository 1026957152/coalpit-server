<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>榆林煤 集装箱站台</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.css" rel="stylesheet">
    <style type="text/css">
        .target-fix {
            padding-top: 100px;
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
        .list-group-unbordered>.list-group-item {
            border-left: 0;
            border-right: 0;
            border-radius: 0;
            padding-left: 0;
            padding-right: 0;
        }
        .profile-user-img {
            margin: 0 auto;
            width: 100px;
            padding: 3px;
            border: 3px solid #d2d6de;
        }
        .box-header {
            color: #444;
            display: block;
            padding: 10px;
            position: relative;
        }
        .box-header .box-title {
            display: inline-block;
            font-size: 18px;
            margin: 0;
            line-height: 1;
        }


    </style>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

    <#if wxConfig.appId??>

    <script>
        //alert(location.href.split('#')[0]);

        wx.config({
            debug: false,// 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。移动端会通过弹窗来提示相关信息。如果分享信息配置不正确的话，可以开了看对应报错信息
            appId: '${wxConfig.appId}',
            timestamp: '${wxConfig.timestamp}',
            nonceStr: '${wxConfig.nonceStr}',
            signature: '${wxConfig.signature}',
            jsApiList: [//需要使用的JS接口列表,分享默认这几个，如果有其他的功能比如图片上传之类的，需要添加对应api进来
                'checkJsApi',
                'onMenuShareTimeline',//
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo'
            ]
        });
    </script>

    <script>
        window.share_config = {
            "share": {
                "imgUrl": "http://yulinmei.cn/yulinmeilogo.png",//分享图，默认当相对路径处理，所以使用绝对路径的的话，“http://”协议前缀必须在。


                "desc" : "榆林煤 ",//摘要,如果分享到朋友圈的话，不显示摘要。
                "title" : '榆林煤 横山区 在产 11家',//分享卡片标题
                "link": window.location.href,//分享出去后的链接，这里可以将链接设置为另一个页面。
                "success":function(){//分享成功后的回调函数
                },
                'cancel': function () {
                    // 用户取消分享后执行的回调函数
                }
            }
        };
        wx.onMenuShareTimeline({
            title: '分享标题', // 分享标题
            link:"分享的url,以http或https开头",
            imgUrl: "分享图标的url,以http或https开头" // 分享图标
        });


        wx.ready(function () {
            wx.onMenuShareAppMessage(share_config.share);//分享给好友
            wx.onMenuShareTimeline(share_config.share);//分享到朋友圈
            wx.onMenuShareQQ(share_config.share);//分享给手机QQ
        });
    </script>
    </#if>


    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${rc.contextPath}/js/lazyload.js"></script>


    <script type="text/javascript">

        LazyLoad.js(['${rc.contextPath}/js/highcharts.js'], function () {



            var req = $.ajax({
                url: '{averagePriceTrendByGranularityByDistrictUrl}',
                type: 'post',
                data: {
                }
            });
            req.done(function (data) {
                getData = data;
                splineIrregularTime();
            });

            var splineIrregularTime = function () {

                var chart1;
                chart1 = new Highcharts.Chart({

                    chart: {
                        renderTo: 'priceByGranularityContainer', //图表放置的容器，DIV
                        zoomType: 'x',///   //x轴方向可以缩放
                        type: 'spline'
                    },
                    title: {
                        text: '区域均价统计'
                    },
                    subtitle: {
                        text: ''
                    },
                    xAxis: {
                        type: 'datetime',
                        dateTimeLabelFormats: { // don't display the dummy year

                            year: '%b',
                            month: '%b. %e  ',
                            month: '%Y-%m',
                            year: '%Y'
                        },
                        title: {
                            text: '时间',
                            style: {
                                display: 'none'
                            }
                        }
                    },
                    yAxis: {
                        title: {
                            text: '元/吨'
                        },
                        min: 0
                    },
                    tooltip: {

                        shared: true,
                        useHTML: true,
                        headerFormat: '<small>{series.name}:</small><table>',
                        pointFormat: '<tr><td ">均值：<b>{point.y}</b> </td>' +
                                '<td style="text-align: right"><b>报价企业：<b>{point.count}</b> 个</td></tr>' +
                                '<tr><td ">最小：<b>{point.min} </b></td>' +
                                '<td style="text-align: right">最大：<b>{point.max}</b> 个</td></tr>',
                        footerFormat: '</table>',

                        valueDecimals: 2

                    },


                    plotOptions: {
                        spline: {
                            marker: {
                                enabled: true
                            }
                        }
                    },

                    series: getData
                });
            };
            $(window).trigger("resize");
            //  $("img").slideUp(1000);
        });


    function refresh() {
        $('#application-table').bootstrapTable('refresh');
    }
    var  sortParam;

    $('input[name="order"]').change( function() {
        sortParam=   $(this).val();

        alert(sortParam);
    })
    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;


        var St = $.trim($("#St").val());
        var oreDistricts = $.trim($("#oreDistricts").val());
        var personName = $.trim($("#personName").val());
        var granularity = $.trim($("#granularity").val());
        var status = $.trim($("#status").val());
        var catoaries = $.trim($("#catoaries").val());



        var place_of_departure = $.trim($("#place_of_departure").val());


        var qnetar = $.trim($("#qnetar").val());
        var qgrad = $.trim($("#qgrad").val());
        var aar = $.trim($("#aar").val());
        var sort = $.trim($("#sort").val());

        var sortParam = $.trim($("#sortParam").val());


        alert(JSON.stringify(params));
        return params;
    }
    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
        return res;
    }

    function capacityInfoFormatter(value, row, index) {

        var orderUrl
        if (row.orderUrl != null) {
            orderUrl = '关联订单：<a href="' + row.orderUrl + '">' + row.orderNo + '</a><br>'
        } else {

        }
    }
        function trendFormatter(value, row, index) {



        return '<i class="icon-align-left"></i>'+


                '</div>';

    }
    function operationFormatter(value, row, index) {



        return '<div class=""><a href="'+row.url+'">查看</a></div>';

    }

    function avatarFormatter_(value, row, index) {
        return  '         <div class="avatar"> <a href="/company?companyId='+row.companyId+'" ><img src="'+row.smallImage+'"/> </a><br> '+row.companyName+'</div> ';

    }

    function avatarFormatter(value, row, index) {

        return  ' <div class="img-comment-list">  <div  class="comment-img"  > <img class="" src="'+row.smallImage+'"/> </div>'+
                ' <div class="comment-text">'+
                '<strong><a href="/person?id=" '+ row.targetLogisticsCompanyId + '>' + row.companyName  + '</a></strong>'+
                '<p class="">'+ row.emailAddress + '</p> '+
                '</div>'+
                ' </div>';

    }
    </script>
</head>
<body>
<div class="container" style="margin-bottom:50px; margin-top:20px ;">

<ol class="breadcrumb">

    <li class="active">
        <a id="follow"  href="${homeUrl!''}"><span class="fa fa-plus-circle"></span> 首页 </a>
    </li>

    <li class="active">堆场排队</li>
<@security.authorize        access="isAuthenticated()">
    <a id="follow" class=" pull-right" href="${personalCenterUrl}"><span class="fa fa-plus-circle"></span> 我的中心 </a>
</@security.authorize>

    <div class="dropdown  pull-right">
        <button class="btn btn-xs btn-danger btn-dropdown-toggle" data-toggle="dropdown"> 更多</button>
        <ul class="dropdown-menu" >
            <li> <a id="follow" class=" pull-right" href="{shipmentUrl}"><span class="fa fa-plus-circle"></span> 运单验证 </a></li>

        </ul>
    </div>
</ol>







    <div id="myTabContent" class="tab-content">
    <#list stations as enterprise>
        <div class="tab-pane active" id="${enterprise.name!""}"  style="margin-top: 15px">


                <div class="panel

                        panel-success

                    " >
                    <div class="panel-heading">
                        <div class="row">

                            <div class="col-xs-12 col-md-12 h4">
                                <b><a href="${enterprise.companyUrl!''}" >${enterprise.note!''}</a> <small><a href="${enterprise.url!'--'}">${enterprise.name!''}</a></small>

                                    <span class="h6 ">

                                        </span>

                                     </span><br><span class="h6">${enterprise.address!''}</span>
                                </b>
                            </div>

                        </div>


                        <h3 class="panel-title"(${enterprise.status!''})</h3>

                    </div>


                </div>


        </div>
    </#list>

    </div>


<#include "./common/page_foot_section.ftl">


</body>
</html>