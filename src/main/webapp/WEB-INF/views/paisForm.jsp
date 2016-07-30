<%-- 
    Document   : paisForm
    Created on : 12/06/2015, 22:37:07
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
            <h2>Cadastro de País</h2>
            <hr>
            <div class="row clearfix">
                <form method="post" role="form">
                    <div class="row clearfix">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="txtSigla">Sigla</label>
                                <input placeholder="Sigla" maxlength="3" name="sigla" class="form-control sias-default" id="txtSigla" value="${pais.sigla}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4">
                                <label for="txtDescricao">Descrição</label>
                                <input placeholder="Descrição" maxlength="100" name="descricao" class="form-control sias-default" id="txtDescricao" value="${pais.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="txtCodigoBACEN">Código(BACEN)</label>
                                <input placeholder="Código(BACEN)" name="codigoBACEN" class="form-control sias-default" id="txtCodigoBACEN" value="${pais.codigoBACEN}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <button id="btnConfirmar" type="submit" class="btn btn-primary sias-default buttons hvr-bob margem">
                                <img alt="" src="<c:url value="/img/icon-confirm.png"/>" class="img-rounded" />
                                Confirmar
                            </button>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <a href="<c:url value = "/cadastrosBasicos/pais"/>" class="btn btn-primary sias-default buttons hvr-bob">
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


