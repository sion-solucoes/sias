<%-- 
    Document   : familiaBeneficioEventualList
    Created on : 16/10/2016, 16:57:38
    Author     : jaderhenrique
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Lista de benefícios eventuais de famílias</h2>
                </div>
            </div>
            <a type="button" class="btn btn-float bgm-blue m-btn" href="<c:url value="/controleFamiliar/requisicaoBeneficio/novo"/>"><i class="zmdi zmdi-plus"></i></a>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle table-bootgrid">
                    <thead>
                        <tr>
                            <th data-column-id="id" data-visible="false">ID</th>
                            <th data-column-id="familia">Família</th>
                            <th data-column-id="beneficio">Benefício</th>
                            <th data-column-id="dataSolicitacao" data-formatter="date">Data de Solicitação</th>
                            <th data-column-id="dataConcessao" data-formatter="date">Data de Concessão</th>
                            <th data-column-id="commands" data-formatter="commands2" data-sortable="false"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty familiaBeneficioList}">
                            <c:forEach var="familiaBeneficio" items="${familiaBeneficioList}">
                                <tr>
                                    <td>${familiaBeneficio.id}</td>
                                    <td>${familiaBeneficio.familia.nomePessoaReferencia}</td>
                                    <td>${familiaBeneficio.beneficioEventual.descricao}</td>
                                    <td>${familiaBeneficio.dataSolicitacao}</td>
                                    <td>${familiaBeneficio.dataConcessao}</td>
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
