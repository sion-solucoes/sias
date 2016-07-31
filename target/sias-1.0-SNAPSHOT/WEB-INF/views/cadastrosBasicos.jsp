<%-- 
    Document   : cadastrosBasicos
    Created on : 29/08/2015, 11:22:31
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

    </head>

    <body class="background-color title-margin">
        <%@include file="header.jsp" %>
        <div class="container-fluid">
            <div class="row clearfix margem">
                <div class="col-md-12">
                    <a id="btnPais" class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/cadastrosBasicos/pais"/>">
                       <!--<img alt="" src="<c:url value="/img/icon-agenda.png"/>" class="img-rounded" />-->
                        Cadastro de País
                    </a>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/cadastrosBasicos/unidadeFederacao"/>">
                       <!--<img alt="" src="<c:url value="/img/icon-agenda.png"/>" class="img-rounded" />-->
                        Cadastro de Unidade Federação(UF)
                    </a>
                </div>
            </div>
            <div class="row clearfix margem">
                <div class="col-md-12">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/cadastrosBasicos/municipio"/>">
                       <!--<img alt="" src="<c:url value="/img/icon-agenda.png"/>" class="img-rounded" />-->
                        Cadastro de Município
                    </a>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/cadastrosBasicos/cep"/>">
                       <!--<img alt="" src="<c:url value="/img/icon-agenda.png"/>" class="img-rounded" />-->
                        Cadastro de CEP
                    </a>
                </div>
            </div>
            <div class="row clearfix margem">
                <div class="col-md-12">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/home"/>">
                        <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                        Voltar
                    </a>
                </div>
            </div>
        </div>
    </div>


</body>
</html>


