<%-- 
    Document   : loginError
    Created on : 21/05/2015, 19:03:54
    Author     : Fernando Laranjo
--%>

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
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/animate.css"/>" rel="stylesheet">

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

    </head>

    <body class="background-color title-margin">
        <div class="container">
            <div class="row clearfix margem">
                <div class="col-md-6 column">
                    <img alt="" src="<c:url value="/img/logo.png"/>" class="img-rounded centro-panel" />
                </div>
                <div class="col-md-6 column margem">
                </div>
            </div>
            <div class="row clearfix margem">
                <form action="<c:url value="/home"/>" method="post" class="form- margem" role="form">
                    <h3>E-mail, Senha ou Código de Segurança inválidos!</h3>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-user"></i>
                            </span>
                            <input type="email" placeholder="E-mail" name="email" class="form-control sias-default" id="txtEmail" value="${email}"/>    
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-lock"></i>
                            </span>
                            <input type="password" placeholder="Senha" name="senha" class="form-control sias-default" id="txtSenha" />
                        </div>
                    </div>
                    <a id="btnEntrar" class="btn btn-primary sias-default buttons hvr-bob">
                        <img alt="" src="<c:url value="/img/icon-login.png"/>" class="img-rounded" />
                        Entrar
                    </a>
                </form>
            </div>
        </div>

        <div id="dlgSeguranca" class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="dlgSeguranca">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="row clearfix">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <label id="lblSeguranca"></label>
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </span>
                                <input id="txtNumeroSeguranca" hidden="true"/>    
                                <input id="txtCodigoSeguranca" class="form-control sias-default"/>    
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <a id="btnConfirmar" class="btn btn-primary sias-default buttons hvr-bob">
                                <img alt="" src="<c:url value="/img/icon-login.png"/>" class="img-rounded" />
                                Confirmar
                            </a>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                </div>
            </div>
        </div>

        <script src="<c:url value="/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/js/loginController.js"/>"></script>
    </body>
</html>

