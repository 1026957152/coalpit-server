<div class=" ">

    <select class="selectpicker" id="" name = "" class="form-control" placeholder="">

    <#list transitionActions as status>
        <option value="${status.id}" >${status.actionName}   ${status.currentState} ${status.nextState}</option>
    </#list>
    </select>



    <select class="selectpicker" id="" name = "" class="form-control" placeholder="">

    <#list roleTransitionActions as status>
        <option value="${status.id}" >${status.actionName}   ${status.currentState} ${status.nextState}</option>
    </#list>
    </select>

    <select class="selectpicker" id="action" name = "action" class="form-control" placeholder="">

    <#list intersectionActions as status>
        <option value="${status.id}" >${status.actionName} ${status.currentState} ${status.nextState}</option>
    </#list>
    </select>
    <button id="cancelCanvassingBtn" type=""  class="btn btn-primary "  data-toggle="modal" data-target="#cancelModal"> 执行</button>
    <div id="cancelModal" class="modal fade" role="dialog">
        <div id="login-overlay" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">执行</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="well">
                                <div id="loginForm"   novalidate="novalidate">

                                    <input id="actionObjectId" >

                                    <button id="cancelModalBtn" ref="${commandUrl}" type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>



                                    <script type="text/javascript">

                                        $("#cancelModalBtn").click(function() {

                                            var applicationId = $("#actionObjectId").val();


                                           // var applicationId = {orderJsonView.id};//$("#applicationId").val();
                                            var transitionActionId = $("#action").val();//$("#applicationId").val();

                                            alert(transitionActionId);


                                            if(transitionActionId == "13"){
                                                window.location.href = "{createTransportOperationPageUrl}";
                                                return;
                                            }
                                            var req = $.ajax({
                                                url:  $(this).attr('ref'),
                                                type: 'post',
                                                data: {canvassingId:applicationId,transitionActionId:transitionActionId}
                                            });
                                            req.done(function (data) {
                                                if (data.status) {
                                                    alert(JSON.stringify(data));
                                                    window.location.href = data.link;
                                                    //    var applyId = $('.modelOrderId').html();
                                                    //window.location.href = "/usercenter/cargocanvassing/canvassing?id=" + $("#applicationId").val();<#-- $("#quotationId").val();-->

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
    </div>

</div>