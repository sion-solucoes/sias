<%-- 
    Document   : beneficioEventualList
    Created on : 12/07/2016, 20:40:26
    Author     : jaderhenrique
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
        <link href="<c:url value="/css/jquery.dataTables.min.css"/>" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

    </head>

    <body class="background-color title-margin">
        <%@include file="header.jsp" %>
        <div class="container">
            <h2>Listagem de Beneficios Eventuais</h2>
            <hr>
            <div class="row clearfix">
                <div class="col-md-2 column margem">
                    <a type="button" class="btn btn-primary buttons hvr-bob sias-default" href="<c:url value="/controleFamiliar/beneficioEventual/novo"/>">
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
            <div class="row clearfix">
                <div class="col-md-12">
                    <table class="table table-striped" id="tabela">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Descrição</th>
                                <th><span class="glyphicon glyphicon-trash"></span></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty beneficioEventualList}">
                                <c:forEach var="beneficioEventual" items="${beneficioEventualList}">
                                    <tr>
                                        <td>
                                            <a href="<c:url value="/controleFamiliar/beneficioEventual/${beneficioEventual.id}/editar"/>">
                                                ${beneficioEventual.codigo}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/controleFamiliar/beneficioEventual/${beneficioEventual.id}/editar"/>">
                                                ${beneficioEventual.descricao}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/controleFamiliar/beneficioEventual/${beneficioEventual.id}/excluir"/>">
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
