<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>CSU-Guide</title>
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
    <link rel="shortcut icon" href="<c:url value="/pages/../assets/ico/favicon.ico"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/pages/../assets/ico/apple-touch-icon-144-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/pages/../assets/ico/apple-touch-icon-114-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/pages/../assets/ico/apple-touch-icon-72-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" href="<c:url value="/pages/../assets/ico/apple-touch-icon-57-precomposed.png"/>">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header" style="padding-bottom:10px;">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a class="" href="index.html"><span class="navbar-brand"><img src="/pages/images/snail.png"> CSU-Guide administration</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right" style="padding-top:12px;">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> ${user.getLogin()}
                </a>

              <ul class="dropdown-menu">
                <li><a href="./">Мой аккаунт</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Панель управления</li>
                <li><a href="./">Контент</a></li>
                <li><a href="./">Безопасность</a></li>
                <li><a tabindex="-1" href="./">О нас</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="sign-in.html">Выйти из системы</a></li>
              </ul>
            </li>
          </ul>

        </div>
      </div>
    </div>
    

    <div class="sidebar-nav">
    <ul>
    <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> Основные настройки<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href="index.html"><span class="fa fa-caret-right"></span> Главная страница</a></li>
            <li class="active"><a href="users.html"><span class="fa fa-caret-right"></span> Управление контентом</a></li>
            <li ><a href="media.html"><span class="fa fa-caret-right"></span> Фотографии</a></li>
            <li ><a href="calendar.html"><span class="fa fa-caret-right"></span> Календарь</a></li>
    </ul></li>

        <li><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-briefcase"></i> Управление аккаунтом</a></li>
        <li><ul class="accounts-menu nav nav-list collapse">
            <li ><a href="sign-in.html"><span class="fa fa-caret-right"></span> Войти в систему</a></li>
            <li ><a href="sign-up.html"><span class="fa fa-caret-right"></span> Выйти из системы</a></li>
            <li ><a href="reset-password.html"><span class="fa fa-caret-right"></span> Сбросить пароль</a></li>
    </ul></li>

        <li><a href="help.html" class="nav-header"><i class="fa fa-fw fa-question-circle"></i> Помощь</a></li>
            </ul>
    </div>

    <div class="content">
        <div class="header">
            
            <h1 class="page-title">Управление контентом</h1>
                    <ul class="breadcrumb">
            <li><a href="index.html">Главная страница</a> </li>
            <li class="active">Управление контентом</li>
        </ul>

        </div>
        <div class="main-content">
            
<div class="btn-toolbar list-toolbar">
	<div class="form-group" style="margin-left:4px;">
            <label>Выберите контент, необходимый для редактирования: </label>
            <select name="DropDownTimezone" id="DropDownTimezone" class="form-control">
              <option value="-12.0">Сотрудники</option>
			  <option value="-13.0">Справочник</option>
			  <option value="-14.0">Расписание</option>
			  <option value="-15.0">Навигация</option>
			  <option value="-16.0">Администраторы</option>
			  <option value="-17.0">...</option>
			  <option value="-18.0">...</option>
			  <option value="-19.0">...</option>			  
            </select>
    </div>
		  
	<div class="search-well" style="margin-left:4px;">
                <form class="form-inline" style="margin-top:0px;">
                    <input class="input-xlarge form-control" placeholder="Введите данные для поиска..." id="appendedInputButton" type="text">
                    <button class="btn btn-default" type="button"><i class="fa fa-search"></i> Найти</button>
                </form>
    </div>
    <button class="btn btn-bordo"><i class="fa fa-plus"></i> Добавить запись</button>
  <div class="btn-group">
  </div>
</div>
<table class="table">
  <thead>
    <tr>
      <th>#</th>
      <th>Фамилия</th>
      <th>Имя</th>
	  <th>Отчество</th>
      <th>Email</th>
      <th style="width: 3.5em;"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Петриченко</td>
      <td>Юлия</td>
	  <td>Владимировна</td>
      <td>yulia-c@yandex.ru</td>
      <td>
          <a href="user.html"><i class="fa fa-pencil"></i></a>
          <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
      </td>
    </tr>
    <tr>
      <td>2</td>
      <td>Мельников</td>
      <td>Андрей</td>
      <td>Витальевич</td>
	  <td>mav@csu.ru</td>
      <td>
          <a href="user.html"><i class="fa fa-pencil"></i></a>
          <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
      </td>
    </tr>
    <tr>
      <td>3</td>
      <td>Мельников</td>
      <td>Виталий</td>
      <td>Андреевич</td>
	  <td>protei300@gmail.com</td>
      <td>
          <a href="user.html"><i class="fa fa-pencil"></i></a>
          <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
      </td>
    </tr>
    <tr>
      <td>4</td>
      <td>Скрипов</td>
      <td>Сергей</td>
      <td>Александрович</td>
	  <td>skripov@csu.ru</td>
      <td>
          <a href="user.html"><i class="fa fa-pencil"></i></a>
          <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
      </td>
    </tr>
    <tr>
      <td>5</td>
      <td>Косенко</td>
      <td>Максим</td>
      <td>Юрьевич</td>
	  <td>kosenko@csu.ru</td>
      <td>
          <a href="user.html"><i class="fa fa-pencil"></i></a>
          <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
      </td>
    </tr>
    <tr>
      <td>6</td>
      <td>Митянина</td>
      <td>Анастасия</td>
      <td>Владимировна</td>
	  <td>mityanina@csu.ru</td>
      <td>
          <a href="user.html"><i class="fa fa-pencil"></i></a>
          <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
      </td>
    </tr>
  </tbody>
</table>

<ul class="pagination">
  <li><a href="#">&laquo;</a></li>
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">&raquo;</a></li>
</ul>

<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Delete Confirmation</h3>
        </div>
        <div class="modal-body">
            <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the user?<br>This cannot be undone.</p>
        </div>
        <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
            <button class="btn btn-danger" data-dismiss="modal">Delete</button>
        </div>
      </div>
    </div>
</div>


            <footer>
                <hr>

                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                <p>© 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            </footer>
        </div>
    </div>


    <script src="/pages/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
