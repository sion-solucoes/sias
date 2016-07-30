<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Unidade de Atendimento</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value="/controleAmbiente/unidadeAtendimento/novo"/>" type="button" class="btn bgm-blue">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="codigo">Código</th>
                            <th data-column-id="sender">Descrição</th>
                            <th data-column-id="received" data-order="desc">Tipo</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty unidadeAtendimentoList}">
                            <c:forEach var="unidadeAtendimento" items="${unidadeAtendimentoList}">
                                <tr>
                                    <td>
                                        ${unidadeAtendimento.codigo}
                                    </td>
                                    <td>
                                        ${unidadeAtendimento.descricao}
                                    </td>
                                    <td>
                                        <c:if test="${unidadeAtendimento.tipo == 1}">
                                            CRAS
                                        </c:if>     
                                        <c:if test="${unidadeAtendimento.tipo == 2}">
                                            CREAS
                                        </c:if>
                                    </td>
                                    <!--
                                    <td>
                                        <a href="<c:url value="/controleAmbiente/unidadeAtendimento/${unidadeAtendimento.id}/editar"/>" type="button" class="btn btn-icon waves-effect waves-circle">
                                            <span class="zmdi zmdi-edit"></span>
                                        </a>
                                        <a href="<c:url value="/controleAmbiente/unidadeAtendimento/${unidadeAtendimento.id}/excluir"/>" type="button" class="btn btn-icon waves-effect waves-circle">
                                            <span class="zmdi zmdi-delete"></span>
                                        </a>
                                    </td>
                                    -->
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