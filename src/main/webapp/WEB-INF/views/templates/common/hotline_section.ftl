<style type="text/css">
    .material-button-anim {
        position: relative;
       /* padding: 12px 15px 27px;*/
        text-align: center;
        max-width: 320px;
        margin: 0 auto 20px;
    }
    .navbar-fixed-bottom_{
        position: fixed;
        right: 0;
        left: 0;
        z-index: 1030;
        bottom: 0;
        margin-bottom: 0;
        border-width: 1px 0 0;
    }
    .material-button {
        position: relative;
        top: 0;
        z-index: 1;
        width: 70px;
        height: 70px;
        font-size: 1.5em;
        color: #fff;
        background: #2C98DE;
        border: none;
        border-radius: 50%;
        box-shadow: 0 3px 6px rgba(0,0,0,.275);
        outline: none;
    }
    .material-button-toggle {
        z-index: 3;
        width: 50px;
        height: 50px;
        margin: 0 auto;
    }
    .material-button-toggle span {
        -webkit-transform: none;
        transform:         none;
/*        -webkit-transition: -webkit-transform .175s cubic-bazier(.175,.67,.83,.67);
        transition:         transform .175s cubic-bazier(.975,.167,.183,.167);*/

        -webkit-transition: -webkit-transform .175s cubic-bazier(.875,.867,.883,.867);
        transition:         transform .175s cubic-bazier(.975,.867,.883,.867);
    }
    .material-button-toggle.open {
        -webkit-transform: scale(1.3,1.3);
        transform:         scale(1.3,1.3);
        -webkit-animation: toggleBtnAnim .175s;
        animation:         toggleBtnAnim .175s;
    }
    .material-button-toggle.open span {
        -webkit-transform: rotate(45deg);
        transform:         rotate(45deg);
        -webkit-transition: -webkit-transform .175s cubic-bazier(.175,.67,.83,.67);
        transition:         transform .175s cubic-bazier(.175,.67,.83,.67);
    }

    #options {
        height: 70px;
    }
    .option {
        position: relative;
    }
    .option .option1,
    .option .option2,
    .option .option3 {
        filter: blur(5px);
        -webkit-filter: blur(5px);
        -webkit-transition: all .175s;
        transition:         all .175s;
    }
    .option .option1 {
        -webkit-transform: translate3d(90px,180px,0) scale(.8,.8);
        transform:         translate3d(90px,180px,0) scale(.8,.8);
       /* transform:         translate3d(90px,90px,0) scale(.8,.8);*/
    }
    .option .option2 {
        -webkit-transform: translate3d(0,180px,0) scale(.8,.8);
        transform:         translate3d(0,180px,0) scale(.8,.8);
      /*  transform:         translate3d(0,90px,0) scale(.8,.8);*/
    }
    .option .option3 {
        -webkit-transform: translate3d(90px,90px,0) scale(.8,.8);
        transform:         translate3d(90px,90px,0) scale(.8,.8);
       /* transform:         translate3d(-90px,90px,0) scale(.8,.8);*/
    }
    .option.scale-on .option1,
    .option.scale-on .option2,
    .option.scale-on .option3 {
        filter: blur(0);
        -webkit-filter: blur(0);
        -webkit-transform: none;
        transform:         none;
        -webkit-transition: all .175s;
        transition:         all .175s;
    }
    .option.scale-on .option2 {
        -webkit-transform: translateX(-180px) translateZ(0);
        transform:         translateX(-180px) translateZ(0);
        -webkit-transition: all .175s;
        transition:         all .175s;
    }
    .option.scale-on .option3 {
        -webkit-transform: translateX(-90px) translateZ(0);
        transform:         translateX(-90px) translateZ(0);
        -webkit-transition: all .175s;
        transition:         all .175s;
    }
    @keyframes toggleBtnAnim {
        0% {
            -webkit-transform: scale(1,1);
            transform:         scale(1,1);
        }
        25% {
            -webkit-transform: scale(1.4,1.4);
            transform:         scale(1.4,1.4);
        }
        75% {
            -webkit-transform: scale(1.2,1.2);
            transform:         scale(1.2,1.2);
        }
        100% {
            -webkit-transform: scale(1.3,1.3);
            transform:         scale(1.3,1.3);
        }
    }
    @-webkit-keyframes toggleBtnAnim {
        0% {
            -webkit-transform: scale(1,1);
            transform:         scale(1,1);
        }
        25% {
            -webkit-transform: scale(1.4,1.4);
            transform:         scale(1.4,1.4);
        }
        75% {
            -webkit-transform: scale(1.2,1.2);
            transform:         scale(1.2,1.2);
        }
        100% {
            -webkit-transform: scale(1.3,1.3);
            transform:         scale(1.3,1.3);
        }
    }


</style>


<div id="section6" class="" style="margin-bottom: 20px;">


    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />

    <div class="navbar-fixed-bottom_">

        <div class="pull-right">
            <div class="material-button-anim">
                <ul class="list-inline" id="options">
                    <li class="option">
                        <button class="material-button option1" type="button">
                            <a href="tel:${hotline!'--'}"><span class="fa fa-phone" aria-hidden="true"> </span></a>
                        </button>
                    </li>
                    <li class="option">
                        <button class="material-button option2" type="button">
                            <span class="fa fa-envelope-o" aria-hidden="true"></span>
                        </button>
                    </li>
                    <li class="option">
                        <button class="material-button option3" type="button">
                            <span class="fa fa-pencil" aria-hidden="true"></span>
                        </button>
                    </li>
                </ul>
                <button class="pull-right material-button material-button-toggle" type="button">
                    <span class="fa fa-plus" aria-hidden="true"></span>
                </button>
            </div>
        </div>
        <script type="text/javascript">

            $(document).ready(function () {
                $('.material-button-toggle').on("click", function () {
                    $(this).toggleClass('open');
                    $('.option').toggleClass('scale-on');
                });
            });
        </script>
        </div>

</div>