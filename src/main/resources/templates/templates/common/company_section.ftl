
<div id="section6" class="" style="margin-bottom: 20px;">


    <div class="box box-primary">
        <div class="box-body box-profile" style="padding: 10px">

            <input id="companyId" value="${company.mainBusiness!''}" class="hidden">

            <a href="${company.url!''}">
                <img class="profile-user-img img-responsive img-circle" src="${company.smallImage!''}" alt="User profile picture">
            </a>

            <h3 class="profile-username text-center"> ${company.name!''}<span class="h5">${company.businessStatus!''}</span></h3>
            <p class="text-muted text-center">
            ${company.type!''}（<#if company.verified?? && company.verified ><strong class="text-success">认证企业</strong>
            <#else>
                <span class="text-danger ">未认证</span>
            </#if>）</p>
            <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                    <b>关注者</b> <a class="pull-right">${follows}</a>
                </li>

            </ul>
        <@security.authorize        access="isAuthenticated()">
            <#if  isFollowing>
                <button id="unFollow" class="btn btn-success btn-block" value="${company.id}"><span class="fa fa-plus-circle"></span> 取消关注 </button>
            <#else>
                <button id="follow" class="btn btn-success btn-block" value="${company.id}"><span class="fa fa-plus-circle"></span> 关注 </button>

            </#if>
            <script type="text/javascript">


                $("#follow").click(function () {

                    var req = $.ajax({
                        url: '${commandFollow}',
                        type: 'post',
                        data: {
                            companyId: this.value
                        }
                    });
                    req.done(function (data) {
                        //alert(JSON.stringify(data));
                        if (data.STATUS) {
                            window.location.reload()

                        }
                    });
                });

                $("#unFollow").click(function () {

                    var req = $.ajax({
                        url: '${commandUnFollow}',
                        type: 'post',
                        data: {
                            companyId: this.value
                        }
                    });
                    req.done(function (data) {
                        //alert(JSON.stringify(data));
                        if (data.STATUS) {
                            window.location.reload()
                        }
                    });
                });

            </script>

        </@security.authorize>
        <@security.authorize        access="isAnonymous()">


            <a class="btn btn-primary btn-block  popover-top" href="${signinUrl}" data-trigger="hover"  data-placement="bottom"  title="价格走势图" data-content="关注后，移动端将推送企业最新发布信息" > <span class="fa fa-plus-circle"></span><i class="fa fa-certificate"></i><b>登陆后关注企业</b>  </a>

        </@security.authorize>
        </div>

    </div>




</div>

<div id="section6" class="" style="margin-bottom: 20px;">


    <div class="box box-primary">
        <div class="box-body box-profile">


                <img class=" img-responsive " src="/qrcode (2).png" alt="User profile picture">

            <h3 class="profile-username text-center"> 长按二维码关注榆林煤</h3>


        </div>

    </div>




</div>