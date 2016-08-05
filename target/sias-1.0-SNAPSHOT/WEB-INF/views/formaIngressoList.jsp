<%-- 
    Document   : formaIngressoList
    Created on : 11/07/2016, 20:55:36
    Author     : jaderhenrique
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<style>
    #data-table-command tbody tr td {
        max-width: 300px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Formas de Ingresso</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value="/controleFamiliar/formaIngresso/novo"/>" type="button" class="btn bgm-blue">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="codigo">Código</th>
                            <th data-column-id="descricao">Descrição</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty formaIngressoList}">
                            <c:forEach var="formaIngresso" items="${formaIngressoList}">
                                <tr>
                                    <td>
                                        ${formaIngresso.id}
                                    </td>
                                    <td>
                                        ${formaIngresso.descricao}
                                    </td>
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
