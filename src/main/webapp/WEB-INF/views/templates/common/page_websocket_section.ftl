
<script type="text/javascript">

$('.selectpicker').selectpicker();
$('.selectpicker').on('change', function(){
    var selected = $(this).find("option:selected").val();
    refresh();
});
function refresh() {
    $('#teamdeal-table').bootstrapTable('refresh');
}


var $result = $('#events-result');
var getData;
function storageInfoFormatter(value, row, index) {

    return '<div class="">' + row.city + ' '+ row.district + ' '  + row.street + '</div>';

}
function deliveryTimeFormatter(value, row, index) {

    return '<div class="">' + row.deliveryStartTime + ' '+ row.deliveryEndTime + '</div>';

}
function teamDealQuantityFormatter(value, row, index) {

    return '<div class="">' + row.amount + '/'+ row.estimatedProductivity + '</div>';

}

function capacityInfoFormatter(value, row, index) {



    return '<div class="">'  + row.loadingPrefecture +'  '+ row.loadingCounty   +'----'  + row.unloadingPrefecture + '  '+row.unloadingCounty  +'</div>';

}
function queryParams(params) {
    params.page = params.pageNumber - 1;
    params.size = params.pageSize;
    var status = $.trim($("#status").val());
    var shipmentNo = $.trim($("#shipmentNo").val());
    var personName = $.trim($("#personName").val());
    var phone = $.trim($("#phone").val());
    var status = $.trim($("#status").val());
    var shipmentNo = $.trim($("#shipmentNo").val());


    if (status) {
        params.status = status;
    }
    if (shipmentNo) {
        params.lpn = lpn;
    }
    if (status) {
        params.phone = phone;
    }
    if (shipmentNo) {
        params.truckLoad = truckLoad;
    }
    return params;
}
function capacityQueryParams(params) {
    params.page = params.pageNumber - 1;
    params.size = params.pageSize;
    var status = $.trim($("#status").val());
    var companyId = $.trim($("#companyId").val());

    if (companyId) {
        params.companyId = companyId;
    }
    return params;
}


function prodectInfoFormatter(value, row, index) {

    return '<div class=""><a href="'+row.url+'">'+row.coalType+'--' + row.granularity+'</a></div>';

}

function productInfoFormatter(value, row, index) {

    return '<div class=""><a href="'+row.url+'">'+row.coalType+'--' + row.granularity+'</a></div>';

}


function productOperationInfoFormatter(value, row, index) {

    return '<div class=""><a href="'+row.url+'">查看</a></div>';

}
function storageOperationFormatter(value, row, index) {

    return '<div class=""><a href="'+row.homeUrl+'">查看</a></div>';

}


function capacityOperationFormatter(value, row, index) {

    return '<div class=""><a href="'+row.uri+'">查看</a></div>';

}
function followerOperationFormatter(value, row, index) {

    return '<a href="'+row.url+'">查看</a>';

}

function stateFormatter(value, row, index) {
    console.log(row.deliveryStartDate);
    console.log(row.deliveryEndDate);
    return '<span> '+ row.deliveryStartDate +'<br>'+ row.deliveryEndDate + '</span>';

}
function deliveryFormatter(value, row, index) {

    return '<span> '+ row.prefecture +' '+row.county  +' '+row.township + '</span>';

}

function supplyStateFormatter(value, row, index) {

    if(row.status== 'Invalid'){
        return '失效 ';

    }else{
        return '<a href="'+row.url+'">'+ row.status+'</>';
    }
}

function handleResponse(original) {
    var res = {};
    res.rows = original.content;
    res.total = original.totalElements;
    return res;
}

$('#supply-table').bootstrapTable({
    onClickRow: function (row) {
        var companyType = $("#companyType").val();
        var url;
        if(companyType == "seller") {
            url = '/supplypromotionList';
            item =  '/homepage/supplyDtl?id=';
        }

        else if(companyType == "buyer"){
            url = '/homepage/demandList';
            item =  '/homepage/demandDtl?id=';
        }

        window.location.href = item+row.id;
        $result.text('Event: onClickRow, data: ' + JSON.stringify(row));
    },
})

$(".popover-top").popover({

});


$("#priceTrendBtn").bind('click', function () {

});

$(function () {











    $("#follow").click(function () {

        var req = $.ajax({
            url: '{commandFollow}',
            type: 'post',
            data: {
                companyId: this.value
            }
        });
        req.done(function (data) {
            //alert(JSON.stringify(data));
            if (data.status) {
                window.location.reload()

            }
        });
    });

    $("#unFollow").click(function () {
        //alert(this.value);

        var req = $.ajax({
            url: '{commandUnFollow}',
            type: 'post',
            data: {
                companyId: this.value
            }
        });
        req.done(function (data) {
            //alert(JSON.stringify(data));
            if (data.status) {
                window.location.reload()
            }
        });
    });







});




function avatarFormatter(value, row, index) {

    return  '<div class="avatar"> <a href="'+row.personUrl+'" ><img src="'+row.companyLogoUrl+'"/> </a></div> '+
            '<strong><a href="'+row.companyUrl+'"'+ '>' + row.companyName  + '</a></strong>'+

            '</div>';

}


function capacityInfoFormatter(value, row, index) {


    return '<div class="">' +'产品名称：'+'<a href="'+row.productUrl+ '">' + row.productName+ '</a> '+
            '<br>' +'产品来源：'+  '<a href="'+row.productSourceUrl+ '">'+'' + row.productSource+ '</a> '+
            '<br>' +'原价格：'  + '<span class="h4"><del>'+  row.originalPrice +'</del> </span>'+ '元/吨'+
            '<br>' +'优惠<strong> '  + row.discount +'</strong> 当前价格：'  + '<span class="h4 text-danger">'+  row.currentPrice +' </span>'+ '元/吨'+



            '<br>' +'交付地：'  + row.prefecture + '  '+row.county  +' ' +row.township+
            '<br>' +'交付日期：'  + row.deliveryStartTime +'至  '+row.deliveryEndTime  +
            '<br>' +'团购结束日期：'  + row.groupEndTime +

            '<br>' +'当前团购总量/预估产量：'  + row.amount +'/'+row.estimatedProductivity  +
            '<br>' +'当前团购人数：'  + row.count +'家  '+
            '<br><strong class="h4"><a class="btn btn-primary" href="'+row.url+'">'+ row.status+'</strong></>'+
            '</div>';



}

</script>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
    </form>
</div>



<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script src="${rc.contextPath}/js/stomp.js" type="text/javascript"></script>
<script type="text/javascript">
    var stompClient = null;
    function setConnected(connected) {
        $("#connect").prop("disabled", connected);
        $("#disconnect").prop("disabled", !connected);
        if (connected) {
            $("#conversation").show();
        }
        else {
            $("#conversation").hide();
        }
        $("#greetings").html("");
    }

    function connect() {
        var socket = new SockJS('${websocket_url}');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('${websocket_topic}', function (greeting) {
                showGreeting(JSON.parse(greeting.body).content);
            });
        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
    }

    function showGreeting(message) {
        $("#greetings").append("<tr><td>" + message + "</td></tr>");
    }

    $(function () {
        $("form").on('submit', function (e) {
            e.preventDefault();
        });
        $( "#connect" ).click(function() { connect(); });
        connect();

        $( "#disconnect" ).click(function() { disconnect(); });
        $( "#send" ).click(function() { sendName(); });
    });









</script>

<script type="text/javascript" src="http://localhost:8085/Origami/websocket/sockjs-0.3.min.js"></script>
<script>
    var websocket;
    if ('WebSocket' in window) {
        websocket = new WebSocket("${websocket_url}");
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("${websocket_url}");
    } else {
        websocket = new SockJS("http://localhost:8085/Origami/sockjs/webSocketServer");
    }
    websocket.onopen = function (evnt) {
    };
    websocket.onmessage = function (evnt) {
        $("#msgcount").html("(<font color='red'>"+evnt.data+"</font>)")
    };
    websocket.onerror = function (evnt) {
    };
    websocket.onclose = function (evnt) {
    }

</script>