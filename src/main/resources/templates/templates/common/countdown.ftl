
<style type="text/css">


    @import url('https://fonts.googleapis.com/css?family=Lobster');

    #days {
        font-size: 50px;
        color: #db4844;
    }
    #hours {
        font-size: 50px;
        color: #f07c22;
    }
    #minutes {
        font-size: 50px;
        color: #f6da74;
    }
    #seconds {
        font-size: 50px;
        color: #abcd58;
    }

    #timer div {
        display: inline-block;
        line-height: 1;
        padding: 20px;
        font-size: 40px;
    }

    #timer span {
        display: block;
        font-size: 20px;
      /*  color: white;*/
    }




</style>

<div class="container">
    <div class="row">
        <div id="timer">
            <div id="days"></div>
            <div id="hours"></div>
            <div id="minutes"></div>
            <div id="seconds"></div>
        </div>
    </div>

</div>


<script type="text/javascript">

    function makeTimer() {

        var endTime = new Date("${quotationPlan.triggerDate!''}");
        var endTime = (Date.parse(endTime)) / 1000;

        var now = new Date();
        var now = (Date.parse(now) / 1000);

        var timeLeft = endTime - now;

        var days = Math.floor(timeLeft / 86400);
        var hours = Math.floor((timeLeft - (days * 86400)) / 3600);
        var minutes = Math.floor((timeLeft - (days * 86400) - (hours * 3600 )) / 60);
        var seconds = Math.floor((timeLeft - (days * 86400) - (hours * 3600) - (minutes * 60)));

        if (hours < "10") { hours = "0" + hours; }
        if (minutes < "10") { minutes = "0" + minutes; }
        if (seconds < "10") { seconds = "0" + seconds; }

        $("#days").html(days + "<span>天</span>");
        $("#hours").html(hours + "<span>时</span>");
        $("#minutes").html(minutes + "<span>分</span>");
        $("#seconds").html(seconds + "<span>秒</span>");

    }

    setInterval(function() { makeTimer(); }, 1000);
</script>