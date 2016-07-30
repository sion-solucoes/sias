<%-- 
    Document   : defienciaForm
    Created on : 01/09/2015, 20:33:10
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
            <h2>Cadastro de Deficiência</h2>
            <hr>
            <div class="row clearfix">
                <form method="post" role="form">
                    <div class="row clearfix">
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="txtCodigo">Código</label>
                                <input type="number" placeholder="Código" max="100" min="0" name="codigo" class="form-control sias-default" id="txtCodigo" value="${deficiencia.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label for="txtDescricao">Descrição</label>
                                <input placeholder="Descrição" maxlength="50" name="descricao" class="form-control sias-default" id="txtDescricao" value="${deficiencia.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-primary sias-default buttons hvr-bob margem">
                                <img alt="" src="<c:url value="/img/icon-confirm.png"/>" class="img-rounded" />
                                Confirmar
                            </button>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <a href="<c:url value = "/controleFamiliar/deficiencia"/>" class="btn btn-primary sias-default buttons hvr-bob">
                                <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                                Voltar
                            </a>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                </form>
            </div>
        </div>

        
        
    </body>
</html>