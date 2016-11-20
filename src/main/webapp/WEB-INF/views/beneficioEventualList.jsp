<%-- 
    Document   : beneficioEventualList
    Created on : 12/07/2016, 20:40:26
    Author     : jaderhenrique
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Benefícios Eventuais</h2>
                </div>
            </div>
            <a type="button" class="btn btn-float bgm-blue m-btn" href="<c:url value="/cadastrosBasicos/beneficioEventual/novo"/>"><i class="zmdi zmdi-plus"></i></a>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle table-bootgrid">
                    <thead>
                        <tr>
                            <th data-column-id="id" data-visible="false">ID</th>
                            <th data-column-id="codigo">Código</th>
                            <th data-column-id="descricao">Descrição</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty beneficioEventualList}">
                            <c:forEach var="beneficioEventual" items="${beneficioEventualList}">
                                <tr>
                                    <td>${beneficioEventual.id}</td>
                                    <td>${beneficioEventual.codigo}</td>
                                    <td>${beneficioEventual.descricao}</td>
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

