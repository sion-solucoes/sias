<%-- 
    Document   : documentoProvidenciavelList
    Created on : 29/08/2015, 11:25:35
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Documentos Providenci�veis</h2>
                </div>
            </div>
            <a type="button" class="btn btn-float bgm-blue m-btn" href="<c:url value="/controleFamiliar/documentoProvidenciavel/novo"/>"><i class="zmdi zmdi-plus"></i></a>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="codigo">C�digo</th>
                            <th data-column-id="descricao">Descri��o</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">A��es</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty documentoProvidenciavelList}">
                            <c:forEach var="documentoProvidenciavel" items="${documentoProvidenciavelList}">
                                <tr>
                                    <td>
                                        ${documentoProvidenciavel.codigo}
                                    </td>
                                    <td>
                                        ${documentoProvidenciavel.descricao}
                                    </td>
                                    <!--<td>
                                        <a href="<c:url value="/controleFamiliar/documentoProvidenciavel/${documentoProvidenciavel.id}/excluir"/>">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                    </td>-->
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

<script type="text/javascript">
    $(document).ready(function () {

        //Command Buttons
        $("#data-table-command").bootgrid(bootgridConfig);
    });


</script>

