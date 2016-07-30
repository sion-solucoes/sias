<%-- 
    Document   : familiaForm
    Created on : 29/08/2015, 11:27:10
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

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

    </head>

    <body class="background-color title-margin">
        <%@include file="header.jsp" %>
        <div class="container">
            <input id="txtId" type="number" hidden="true" name="id" value="${familia.id}">
            <h2>Cadastro de Família</h2>
            <hr>
            <form method="post" role="form">
                <%@include file="familiaFormPanDadosBasicos.jsp" %>
                <%@include file="familiaFormPanComposicaoFamiliar.jsp" %>
                <%@include file="familiaFormPanCondicoesHabitacionais.jsp" %>
                <div class="row clearfix margem">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <a id="btnConfirmar" type="submit" class="btn btn-primary sias-default buttons hvr-bob">
                            <img alt="" src="<c:url value="/img/icon-confirm.png"/>" class="img-rounded" />
                            Confirmar
                        </a>
                    </div>
                    <div class="col-md-4"></div>
                </div>
                <div class="row clearfix">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <a href="<c:url value = "/controleFamiliar/familia"/>" class="btn btn-primary sias-default buttons hvr-bob">
                            <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                            Voltar
                        </a>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </form>
        </div>

        <script type="text/javascript" src="<c:url value="/js/familiaController.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/familiaDadosBasicosController.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/familiaComposicaoFamiliarController.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/familiaEnderecoController.js"/>"></script>

    </body>
</html>
