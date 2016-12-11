<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Вход в CSU-Guide</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="<c:url value="/pages/lib/bootstrap/css/bootstrap.css"/>" >
    <link rel="stylesheet" href="<c:url value="/pages/lib/font-awesome/css/font-awesome.css"/>" >

    <script src="/pages/lib/jquery-1.11.1.min.js" type="text/javascript"></script>

    

    <link rel="stylesheet" type="text/css" href="<c:url value="/pages/stylesheets/theme.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/pages/stylesheets/premium.css"/>" >

</head>
<body class=" theme-blue">

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });

        function checkParams() {
            var login = $('#login').val();
            var password = $('#password').val();

            if(login.length != 0 && password.length != 0) {
                $('#button').removeAttr('disabled');
            } else {
                $('#button').attr('disabled', 'disabled');
            }
        }

        function animateDiv(){
            /*$('#warning').animate({
                "hidden": "toggle"
            }, "false" );*/
            $('#warning').style.display = "block";
        }

    </script>

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header" style="padding-bottom:10px;">
          <a class="" href="index.html"><span class="navbar-brand"><img src="/pages/images/snail.png"> CSU-Guide administration</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>
    </div>
    


        <div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading panel-heading-bordo no-collapse">Вход в систему</p>
        <div class="panel-body">
            <form action="/login" role="form" method="post">
                <div class="form-group">
                    <label>Логин</label>
                    <input id="login" name="login" type="text" class="form-control form-control-seventy span12" onkeyup="checkParams()" placeholder="Введите логин..." >
                </div>
                <div class="form-group">
                <label>Пароль</label>
                    <input id="password" name="password" type="password" class="form-control form-control-seventy span12" onkeyup="checkParams()" placeholder="Введите пароль..." >
                </div>
                <input id="button" class="btn pull-right btn-bordo" type="submit" value="Войти" role="button" onclick="animateDiv();" disabled />
                <label class="remember-me"><input type="checkbox"> Запомнить мои данные</label>
                <div class="clearfix"></div>
            </form>

            <div class="bs-callout bs-callout-right bs-callout-warning" id="warning" style="display: none;" >
                <p>${warning}</p>
            </div>
        </div>
    </div>
    <p class="pull-right" style=""><a href="http://www.csu.ru" target="blank" style="font-size: .75em; margin-top: .25em;">CSU-Guide</a></p>
    <p><a href="reset-password.html">Забыли свой пароль?</a></p>
</div>



    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
