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
                    <h2>Listagem de Unidades Federativas (UF)</h2>
                </div>
            </div>
            <a type="button" class="btn btn-float bgm-blue m-btn" href="<c:url value="/cadastrosBasicos/unidadeFederacao/novo"/>"><i class="zmdi zmdi-plus"></i></a>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle table-bootgrid">
                    <thead>
                        <tr>
                            <th data-column-id="id" data-visible="false">ID</th>
                            <th data-column-id="sigla">Sigla</th>
                            <th data-column-id="descricao">Descrição</th>
                            <th data-column-id="codigo">Código(IBGE)</th>
                            <th data-column-id="pais">Pais</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty unidadeFederacaoList}">
                            <c:forEach var="unidadeFederacao" items="${unidadeFederacaoList}">
                                <tr>
                                    <td>${unidadeFederacao.id}</td>
                                    <td>${unidadeFederacao.sigla}</td>
                                    <td>${unidadeFederacao.descricao}</td>
                                    <td>${unidadeFederacao.codigoIBGE}</td>
                                    <td>${unidadeFederacao.pais.sigla} - ${unidadeFederacao.pais.descricao}</td>
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




