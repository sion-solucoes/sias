<%-- 
    Document   : cepList
    Created on : 29/08/2015, 11:23:57
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
            <h2>Listagem de CEP</h2>
            <hr>
            <div class="row clearfix">
                <div class="col-md-2 column margem">
                    <a type="button" class="btn btn-primary buttons hvr-bob sias-default" href="<c:url value="/cadastrosBasicos/cep/novo"/>">
                        <img alt="" src="<c:url value="/img/icon-add.png"/>" class="img-rounded" />
                        Novo
                    </a>
                </div>
                <div class="col-md-2 column margem">
                    <a type="button" class="btn btn-primary buttons hvr-bob sias-default" href="<c:url value="/cadastrosBasicos"/>">
                        <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                        Voltar
                    </a>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12">
                    <table class="table table-striped" id="tabela">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Logradouro</th>
                                <th>Bairro</th>
                                <th>Município</th>
                                <th><span class="glyphicon glyphicon-trash"></span></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty cepList}">
                                <c:forEach var="cep" items="${cepList}">
                                    <tr>
                                        <td>
                                            <a href="<c:url value="/cadastrosBasicos/cep/${cep.id}/editar"/>">
                                                ${cep.codigo}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/cadastrosBasicos/cep/${cep.id}/editar"/>">
                                                ${cep.logradouro}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/cadastrosBasicos/cep/${cep.id}/editar"/>">
                                                ${cep.bairro}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/cadastrosBasicos/cep/${cep.id}/editar"/>">
                                                ${cep.municipio.descricao}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/cadastrosBasicos/cep/${cep.id}/excluir"/>">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#tabela').DataTable(DataTableConfig);
            });
        </script>

        <script type="text/javascript" src="<c:url value="/js/DataTableConfig.js"/>"></script>
        
        
        <script type="text/javascript" src="<c:url value="/js/jquery.dataTables.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/dataTables.bootstrap.min.js"/>"></script>
    </body>
</html>