<%-- 
    Document   : index
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
        <link href="<c:url value="/css/owl.theme.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/owl.carousel.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/jquery.vegas.min.css"/>" rel="stylesheet">

        <!-- css template -->
        <link href="<c:url value="/css/animate.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/material-design-iconic-font.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/app_1.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/app_2.css"/>" rel="stylesheet" type="text/css"/>
        <!-- / css template -->

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">
    </head>

    <body>
        <!--
            <center style="margin-top: 80px; position: relative;">
                <img alt="" class="animated flip" src="<c:url value="/img/logo.png"/>"/>
            </center>-->

        <div class="login-content">

            <!-- Login -->
            <form class="lc-block toggled" id="formLogin">

                <div class="lcb-form">

                    <center style="margin-bottom: 30px;">
                        <img alt="" class="animated flip" src="<c:url value="/img/logo.png"/>"/>
                    </center>

                    <div class="input-group m-b-20">
                        <span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
                        <div class="fg-line">
                            <input type="email" class="form-control" placeholder="E-mail" name="email" id="txtEmail" value="${email}">
                        </div>
                    </div>

                    <div class="input-group m-b-20">
                        <span class="input-group-addon"><i class="zmdi zmdi-lock"></i></span>
                        <div class="fg-line">
                            <input type="password" class="form-control" placeholder="Senha" name="senha" id="txtSenha">
                        </div>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="">
                            <i class="input-helper"></i>
                            Mantenha-me conectado
                        </label>
                    </div>

                    <button type="submit" id="btnEntrar" class="btn btn-login btn-primary btn-float"><i class="zmdi zmdi-arrow-forward"></i></button>
                </div>

                <div class="lcb-navigation">
                    <a href="" data-ma-action="login-switch" data-ma-block="#l-register"><i class="zmdi zmdi-plus"></i> <span>Cadastrar</span></a>
                    <a href="" data-ma-action="login-switch" data-ma-block="#l-forget-password"><i>?</i> <span>Redefinir senha</span></a>
                </div>
            </form>

            <center>
                <footer id="footer">
                    Copyright © 2015-2016 SioN Soluções
                </footer>
            </center>


        </div>

        <!-- Modal Small -->
        <div id="dlgSeguranca" class="modal fade" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="dlgSeguranca">
            <form method="POST" id="formSeguranca">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">  
                            <label id="lblSeguranca"></label>
                        </div>
                        <div class="modal-body">
                            <div class="input-group m-b-20">
                                <span class="input-group-addon"><i class="zmdi zmdi-lock"></i></span>
                                <div class="fg-line">
                                    <input type="hidden" id="txtNumeroSeguranca">
                                    <input class="form-control" id="txtCodigoSeguranca">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" id="btnConfirmar">Confirmar</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <script src="<c:url value="/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/js/owl.carousel.min.js"/>"></script>
        <script src="<c:url value="/js/jquery.vegas.min.js"/>"></script>
        <script src="<c:url value="/js/zerif.js"/>"></script>
        <script src="<c:url value="/js/loginController.js"/>"></script>
        <!-- js template -->
        <script src="<c:url value="/js/waves.min.js"/>" type="text/javascript"></script>
        <!--<script src="<c:url value="/js/bootstrap-growl.min.js"/>" type="text/javascript"></script>-->
        <script src="<c:url value="/js/app.js"/>" type="text/javascript"></script>
    </body>
</html>

