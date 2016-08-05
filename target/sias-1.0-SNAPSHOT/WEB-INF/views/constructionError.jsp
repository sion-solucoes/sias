<%-- 
    Document   : constructionError
    Created on : 01/09/2015, 21:37:49
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>SIASWeb</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

    </head>

    <body class="background-color title-margin">
        <%@include file="header.jsp" %>
        <div class="container">
            <h1>Ops!</h1>
            <hr>
            <h3>Página em construção.</h3>
            <div class="row clearfix">
                <div class="col-md-12 center">
                    <img alt="" id="img" src="<c:url value="/img/icon-sad.png"/>" class="img-rounded" />
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 center">
                    <a id="btnIrParaComeco" href="<c:url value="/home"/>">
                        <h4>Ir para o começo.</h4>
                    </a>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="<c:url value="/js/authError.js"/>"></script>

    </body>
</html>


