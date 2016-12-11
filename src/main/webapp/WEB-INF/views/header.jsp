<%-- 
    Document   : header
    Created on : 29/08/2015, 11:28:17
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="br">
    <head>
        <meta charset="utf-8">
        <title>SIASWeb</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/fullcalendar.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/fullcalendar.print.css"/>" media="print" rel="stylesheet">
        <link href="<c:url value="/css/jquery.dataTables.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/animate.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/hover.css"/>" rel="stylesheet">

        <!-- css template -->
        <link href="<c:url value="/css/sweetalert.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/material-design-iconic-font.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/jquery.mCustomScrollbar.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/jquery.bootgrid.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/bootstrap-select.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/bootstrap-datetimepicker-standalone.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/app_1.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/app_2.css"/>" rel="stylesheet" type="text/css"/>

        <!-- css implemented -->
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">


    </head>

    <body>

        <header id="header" class="clearfix" data-ma-theme="blue">
            <ul class="h-inner">
                <li class="hi-trigger ma-trigger" data-ma-action="sidebar-open" data-ma-target="#sidebar">
                    <div class="line-wrap">
                        <div class="line top"></div>
                        <div class="line center"></div>
                        <div class="line bottom"></div>
                    </div>
                </li>
                <li class="hi-logo hidden-xs">
                    <a href="<c:url value="/home"/>">
                        <img alt="" src="<c:url value="/img/logo-header.png"/>" class="logo" />
                    </a>
                </li>
                <li class="hi-logo hidden-xs">
                    <a href="<c:url value="/home"/>">SIASWeb</a>
                </li>
                <li class="pull-right">
                    <ul class="hi-menu">
                        <li data-ma-action="search-open">
                            <a href=""><i class="him-icon zmdi zmdi-search"></i></a>
                        </li>
                        <li class="dropdown">
                            <a data-toggle="dropdown" href="" aria-expanded="false">
                                <i class="him-icon zmdi zmdi-notifications"></i>
                                <i class="him-counts"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-lg pull-right">
                                <div class="list-group him-notification">
                                    <div class="lg-header">
                                        Notificações
                                        <ul class="actions">
                                            <li class="dropdown">
                                                <a href="" data-ma-action="clear-notification">
                                                    <i class="zmdi zmdi-check-all"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="lg-body">
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>

            <!-- Top Search Content -->
            <div class="h-search-wrap">
                <div class="hsw-inner" id="panComboBusca">
                    <i class="hsw-close zmdi zmdi-arrow-left" data-ma-action="search-close" id="busca"></i>
                    <input type="text" id="buscaValor" placeholder="Pesquise famílias por seus membros aqui..."/>
                </div>
            </div>

        </header>

        <section id="main">
            <jsp:include page="/WEB-INF/views/sidebar.jsp"/>