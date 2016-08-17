<%-- 
    Document   : familiaList
    Created on : 29/08/2015, 11:27:49
    Author     : Fernando Laranjo
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Famílias</h2>
                </div>
                <div class="pull-right">
                    <a type="button" class="btn bgm-blue" href="<c:url value="/controleFamiliar/familia/novo"/>">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="pessoa_referencia">Nome(pessoa de referência)</th>
                            <th data-column-id="endereco">Endereço</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty familiaList}">
                            <c:forEach var="familia" items="${familiaList}">
                                <tr>
                                    <td>
                                        ${familia.nomePessoaReferencia}
                                    </td>
                                    <td>
                                        ${familia.logradouroEndereco}, ${familia.numeroEndereco}, ${familia.bairroEndereco}
                                    </td>
                                    <!--<td>
                                        <a href="<c:url value="/controleFamiliar/familia/${familia.id}/excluir"/>">
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

<!-- Data Table -->
<script type="text/javascript">
    $(document).ready(function () {

        //Command Buttons
        $("#data-table-command").bootgrid(bootgridConfig);
    });

</script>
