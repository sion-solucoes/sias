<%-- 
    Document   : unidadeAtendimentoList
    Created on : 12/06/2015, 22:37:07
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Paises</h2>
                </div>
                <div class="pull-right">
                    <a type="button" class="btn bgm-blue" href="<c:url value="/cadastrosBasicos/pais/novo"/>">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="sigla">Sigla</th>
                            <th data-column-id="descricao">Descrição</th>
                            <th data-column-id="codigo">Código(BACEN)</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty paisList}">
                            <c:forEach var="pais" items="${paisList}">
                                <tr>
                                    <td>
                                        ${pais.sigla}
                                    </td>
                                    <td>
                                        ${pais.descricao}
                                    </td>
                                    <td>
                                        ${pais.codigoBACEN}
                                    </td>
                                    <!--<td>
                                        <a id="colExcluir" href="pais/${pais.id}/excluir">
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
 


