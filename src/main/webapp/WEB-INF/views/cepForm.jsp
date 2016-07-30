<%-- 
    Document   : cepForm
    Created on : 29/08/2015, 11:23:19
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
            <h2>Cadastro de CEP</h2>
            <hr>
            <div class="row clearfix">
                <form method="post" role="form">
                    <div class="row clearfix">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="txtCodigo">Código</label>
                                <input placeholder="Código" maxlength="10" onkeypress="formatCEP(codigo);" name="codigo" class="form-control sias-default" id="txtCodigo" value="${cep.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="txtLogradouro">Logradouro</label>
                                <input placeholder="Logradouro" maxlength="255" name="logradouro" class="form-control sias-default" id="txtLogradouro" value="${cep.logradouro}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="txtBairro">Bairro</label>
                                <input placeholder="Bairro" maxlength="100" name="bairro" class="form-control sias-default" id="txtBairro" value="${cep.bairro}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-12">
                            <div class="btn-group">
                                <label for="comboMunicipio">Município</label>
                                <select class="form-control" name="municipio.id" id="comboMunicipio">
                                    <option></option>    
                                    <c:if test="${not empty municipioList}">
                                        <c:forEach var="municipio" items="${municipioList}">
                                            <c:if test="${cep.municipio.id == municipio.id}">
                                                <option selected="true" value="${municipio.id}">${municipio.descricao}</option>    
                                            </c:if>
                                            <c:if test="${cep.municipio.id != municipio.id}">
                                                <option value="${municipio.id}">${municipio.descricao}</option>    
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </select>
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
                            <a href="<c:url value = "/cadastrosBasicos/cep"/>" class="btn btn-primary sias-default buttons hvr-bob">
                                <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                                Voltar
                            </a>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                </form>
            </div>
        </div>

        <script type="text/javascript" src="<c:url value="/js/Formatter.js"/>"></script>
        
        
    </body>
</html>