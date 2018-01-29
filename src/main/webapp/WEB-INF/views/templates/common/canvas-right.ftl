<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<div class="page__off-canvas--right overthrow">
    <div class="off-canvas-right">
    <@security.authorize        access="isAuthenticated()">

        <div class="off-canvas-right__top">
          <div class="media">
                <a href="http://themeforest.net/user/zhaoyuan" class="media__item"><img alt="zhaoyuan" class="off-canvas-right__avatar" src="${user.thumbPersonImage!'asserts/default-user.jpg'}"></a>

                <div class="media__body">
                    <a href="http://themeforest.net/user/zhaoyuan" class="off-canvas-right__username"><@security.authentication property="principal.userName" /> </a>
                    <br>
      <span class="off-canvas-right__balance">
        $0.00
      </span>
                </div>
            </div>

            <div class="off-canvas-right__cart">
                <a href="/mobile/cart">
                    <div class="shopping-cart-summary " data-view="cartCount">
                        <i class="e-icon -icon-cart"></i>
                        <span class="js-cart-summary-count shopping-cart-summary__count">3</span>
                    </div>
                </a>  </div>
        </div>


        <strong class="off-canvas-right__section-heading">账户</strong>
        <ul>
            <li>
                <a href="http://themeforest.net/user/zhaoyuan" class="off-canvas-right__link">
                    简介
                    <i class="e-icon -icon-person -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="https://account.envato.com" class="off-canvas-right__link">
                    找煤 账号
                    <i class="e-icon -icon-envato -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/user/zhaoyuan/personal_information/edit" class="off-canvas-right__link">
                    设置
                    <i class="e-icon -icon-cog -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/downloads" class="off-canvas-right__link">
                    下载
                    <i class="e-icon -icon-download -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/favorites" class="off-canvas-right__link">
                    喜欢Favorites
                    <i class="e-icon -icon-favorite -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/collections/manage" class="off-canvas-right__link">
                    收藏Collections
                    <i class="e-icon -icon-folder-open -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/follow_feed" class="off-canvas-right__link">
                    关注Follow Feed
                    <i class="e-icon -icon-people -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/user/zhaoyuan/statement" class="off-canvas-right__link">
                    声明Statement
                    <i class="e-icon -icon-document-filled -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/deposit/start" class="off-canvas-right__link">
                    提现Make a Deposit
                    <i class="e-icon -icon-dollar -size-medium -color-grey-dark"></i>
                </a>      </li>
        </ul>
        <strong class="off-canvas-right__section-heading">author</strong>
        <ul>
            <li>
                <a href="http://themeforest.net/become_an_author" class="off-canvas-right__link">
                    成为公司Become an Author
                    <i class="e-icon -icon-moneybag -size-medium -color-grey-dark"></i>
                </a>      </li>
        </ul>
        <strong class="off-canvas-right__section-heading">author</strong>
        <ul>
            <li>
                <a href="http://themeforest.net/author_dashboard" class="off-canvas-right__link">
                    Author Dashboard
                    <i class="e-icon -icon-gauge -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/upload" class="off-canvas-right__link">
                    Upload
                    <i class="e-icon -icon-upload -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/user/zhaoyuan/earnings" class="off-canvas-right__link">
                    Earnings
                    <i class="e-icon -icon-moneybag -size-medium -color-grey-dark"></i>
                </a>      </li>
            <li>
                <a href="http://themeforest.net/accounts/withdrawal/new?username=zhaoyuan" class="off-canvas-right__link">
                    Withdrawals
                    <i class="e-icon -icon-withdrawal -size-medium -color-grey-dark"></i>
                </a>      </li>
        </ul>
        <ul>
            <li>
                <a href="https://account.envato.com/sign_out?to=themeforest" class="off-canvas-right__link--logout" data-method="post" id="sign-out-button">
                    Sign out
                    <i class="e-icon -icon-logout -size-medium -color-white"></i>
                </a>  </li>
        </ul>


        <li><button><a href="/usercenter/dashboard">用户中心</a></button></li>
        logged in as
    </@security.authorize>

    <@security.authorize access="! isAuthenticated()">

        <a href="/mobile/cart" class="off-canvas-right__link--cart">
            购物车Guest Cart
            <div class="shopping-cart-summary " data-view="cartCount">
                <span class="js-cart-summary-count shopping-cart-summary__count">1</span>
                <i class="e-icon -icon-cart"></i>
            </div>
        </a>
        <a href="/sign_up" class="off-canvas-right__link">
            新建找煤账号
            <i class="e-icon -icon-envato"></i>
        </a>
        <a href="/mobile/sign_in" class="off-canvas-right__link" rel="nofollow">
            登入
            <i class="e-icon -icon-login"></i>
        </a>
    </@security.authorize>
    <#if (Session.SESSION_CONTEXT.userType)?has_content && Session.SESSION_CONTEXT.userType?upper_case == 'USER'>

    <#elseif (Session.SESSION_CONTEXT.userType)?has_content && Session.SESSION_CONTEXT.userType?upper_case == 'ADMIN'>
        <li><a href="/admin/dashboard">管理中心</a></li>
    <#else>
    </#if>

    </div>




</div>
