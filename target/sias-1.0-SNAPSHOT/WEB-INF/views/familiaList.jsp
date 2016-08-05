<%-- 
    Document   : familiaList
    Created on : 29/08/2015, 11:27:49
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
            <h2>Listagem de Famílias</h2>
            <hr>
            <div class="row clearfix">
                <div class="col-md-2 column margem">
                    <a type="button" class="btn btn-primary buttons hvr-bob sias-default" href="<c:url value="/controleFamiliar/familia/novo"/>">
                        <img alt="" src="<c:url value="/img/icon-add.png"/>" class="img-rounded" />
                        Novo
                    </a>
                </div>
                <div class="col-md-2 column margem">
                    <a type="button" class="btn btn-primary buttons hvr-bob sias-default" href="<c:url value="/controleFamiliar"/>">
                        <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                        Voltar
                    </a>
                </div>
            </div>
            <div class="col-md-12">
                <table class="table table-striped" id="tabela">
                    <thead>
                        <tr>
                            <th>Nome(pessoa de referência)</th>
                            <th>Endereço</th>
                            <th><span class="glyphicon glyphicon-trash"></span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty familiaList}">
                            <c:forEach var="familia" items="${familiaList}">
                                <tr>
                                    <td>
                                        <a href="<c:url value="/controleFamiliar/familia/${familia.id}/editar"/>">
                                            ${familia.nomePessoaReferencia}
                                        </a>
                                    </td>
                                    <td>
                                        <a href="<c:url value="/controleFamiliar/familia/${familia.id}/editar"/>">
                                            ${familia.logradouroEndereco}, ${familia.numeroEndereco}, ${familia.bairroEndereco}
                                        </a>
                                    </td>
                                    <td>
                                        <a href="<c:url value="/controleFamiliar/familia/${familia.id}/excluir"/>">
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

        <script type="text/javascript">
            $(document).ready(function () {
                $('#tabela').DataTable(DataTableConfig);
            });
        </script>

    </body>
</html>