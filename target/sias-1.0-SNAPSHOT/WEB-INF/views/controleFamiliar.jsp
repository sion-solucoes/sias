<%-- 
    Document   : controleFamiliar
    Created on : 29/08/2015, 11:24:57
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
            <h2>Cadastros Principais</h2>
            <hr>
            <div class="row clearfix margem">
                <div class="col-md-6">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/familia"/>">
                        <img alt="" src="<c:url value="/img/icon-home-64.png"/>" class="img-rounded" />
                        Cadastro de Família
                    </a>
                </div>
                <div class="col-md-6">
                    <a class="btn btn-primary sias-default buttons hvr-bob" href="<c:url value="/controleFamiliar/visita"/>">
                        <img alt="" src="<c:url value="/img/icon-calendar-64.png"/>" class="img-rounded" />
                        Agendamento de Visita
                    </a>
                </div>
            </div>
            <div class="row clearfix margem">
                <div class="col-md-6">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/acompanhamento"/>">
                        <img alt="" src="<c:url value="/img/icon-edit-64.png"/>" class="img-rounded" />
                        Acompanhamento
                    </a>
                </div>
                <div class="col-md-6 column">
                    <a class="btn btn-primary sias-default buttons hvr-bob" href="<c:url value="/controleFamiliar/relatorio"/>">
                        <img alt="" src="<c:url value="/img/icon-gift-request-64.png"/>" class="img-rounded" />
                        Requisição de Benefício Eventual
                    </a>
                </div>
            </div>

            <h2>Cadastros Auxiliares</h2>
            <hr>
            <div class="row clearfix margem">
                <div class="col-md-4">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/formaIngresso"/>">
                        <img alt="" src="<c:url value="/img/icon-share-64.png"/>" class="img-rounded" />
                        Cadastro de Forma de Ingresso
                    </a>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/beneficioEventual"/>">
                        <img alt="" src="<c:url value="/img/icon-gift-64.png"/>" class="img-rounded" />
                        Cadastro de Benefício Eventual
                    </a>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/especificidadeSocial"/>">
                        <img alt="" src="<c:url value="/img/icon-chat-64.png"/>" class="img-rounded" />
                        Cadastro de Especificidade Social
                    </a>
                </div>
            </div>
            <div class="row clearfix margem">
                <div class="col-md-6">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/grauParentesco"/>">
                        <img alt="" src="<c:url value="/img/icon-list-64.png"/>" class="img-rounded" />
                        Cadastro de Grau de Parentesco
                    </a>
                </div>
                <div class="col-md-6">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/documentoProvidenciavel"/>">
                        <img alt="" src="<c:url value="/img/icon-folder-64.png"/>" class="img-rounded" />
                        Cadastro de Documento Providenciável
                    </a>
                </div>
            </div>
            <div class="row clearfix margem">
                <div class="col-md-4">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/escolaridade"/>">
                        <img alt="" src="<c:url value="/img/icon-font-64.png"/>" class="img-rounded" />
                        Cadastro de Escolaridade
                    </a>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/condicaoOcupacao"/>">
                        <img alt="" src="<c:url value="/img/icon-wrench-64.png"/>" class="img-rounded" />
                        Cadastro de Condição de Ocupação
                    </a>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-primary sias-default buttons hvr-bob " href="<c:url value="/controleFamiliar/deficiencia"/>">
                        <img alt="" src="<c:url value="/img/icon-hearth-64.png"/>" class="img-rounded" />
                        Cadastro de Deficiência
                    </a>
                </div>
            </div>
            <div class="row clearfix">
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
