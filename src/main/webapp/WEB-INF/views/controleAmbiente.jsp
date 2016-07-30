<%-- 
    Document   : controleAmbiente
    Created on : 29/08/2015, 11:24:28
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
                <div class="col-md-12 column">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleAmbiente/unidadeAtendimento"/>">
                        <img alt="" src="<c:url value="/img/icon-menu.png"/>" class="img-rounded" />
                        Cadastro de Unidade de Atendimento
                    </a>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleAmbiente/usuario"/>">
                        <img alt="" src="<c:url value="/img/icon-user.png"/>" class="img-rounded" />
                        Cadastro de Usuário
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
