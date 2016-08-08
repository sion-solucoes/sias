<%-- 
    Document   : condicaoOcupacaoList
    Created on : 01/09/2015, 19:59:16
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Condi��o de Trabalho ou Ocupa��o</h2>
                </div>
                <div class="pull-right">
                    <a type="button" class="btn bgm-blue" href="<c:url value="/controleFamiliar/condicaoOcupacao/novo"/>">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="codigo">Codigo</th>
                            <th data-column-id="descricao">Descri��o</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">A��es</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty condicaoOcupacaoList}">
                            <c:forEach var="condicaoOcupacao" items="${condicaoOcupacaoList}">
                                <tr>
                                    <td>
                                        ${condicaoOcupacao.codigo}
                                    </td>
                                    <td>
                                        ${condicaoOcupacao.descricao}
                                    </td>
                                    <!--<td>
                                        <a href="<c:url value="/controleFamiliar/condicaoOcupacao/${condicaoOcupacao.id}/excluir"/>">
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