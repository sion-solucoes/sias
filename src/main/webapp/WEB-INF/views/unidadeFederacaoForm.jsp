<%-- 
    Document   : unidadeFederacaoForm
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
            <h2>Cadastro de Unidade Federação(UF)</h2>
            <hr>
            <div class="row clearfix">
                <form method="post" role="form">
                    <div class="row clearfix">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="txtSigla">Sigla</label>
                                <input placeholder="Sigla" maxlength="2" name="sigla" class="form-control sias-default" id="txtSigla" value="${unidadeFederacao.sigla}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="txtDescricao">Descrição</label>
                                <input placeholder="Descrição" maxlength="50" name="descricao" class="form-control sias-default" id="txtDescricao" value="${unidadeFederacao.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="txtCodigoIBGE">Código(IBGE)</label>
                                <input placeholder="Código(IBGE)" name="codigoIBGE" class="form-control sias-default" id="txtCodigoIBGE" value="${unidadeFederacao.codigoIBGE}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-12">
                            <div class="btn-group">
                                <label for="comboPais">País</label>
                                <select class="form-control" name="pais.id" id="comboPais">
                                    <option></option>
                                    <c:if test="${not empty paisList}">
                                        <c:forEach var="pais" items="${paisList}">
                                            <c:if test="${unidadeFederacao.pais.id == pais.id}">
                                                <option selected value="${pais.id}">${pais.sigla} - ${pais.descricao}</option>
                                            </c:if>
                                            <c:if test="${unidadeFederacao.pais.id != pais.id}">
                                                <option value="${pais.id}">${pais.sigla} - ${pais.descricao}</option>
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
                            <a href="<c:url value = "/cadastrosBasicos/unidadeFederacao"/>" class="btn btn-primary sias-default buttons hvr-bob">
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


