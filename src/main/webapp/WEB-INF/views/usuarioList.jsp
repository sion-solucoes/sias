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
                    <h2>Listagem de Usuários</h2>
                </div>
            </div>
            <a type="button" class="btn btn-float bgm-blue m-btn" href="<c:url value="/controleAmbiente/usuario/novo"/>"><i class="zmdi zmdi-plus"></i></a>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle table-bootgrid">
                    <thead>
                        <tr>
                            <th data-column-id="id" data-visible="false">ID</th>
                            <th data-column-id="nome">Nome</th>
                            <th data-column-id="email">Email</th>
                            <th data-column-id="tipo" data-order="desc">Tipo</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty usuarioList}">
                            <c:forEach var="usuario" items="${usuarioList}">
                                <tr>
                                    <td>${usuario.id}</td>
                                    <td>${usuario.nome}</td>
                                    <td>${usuario.email}</td>
                                    <td><c:if test="${usuario.tipo == 1}">Master</c:if><c:if test="${usuario.tipo == 2}">Técnico</c:if> <c:if test="${usuario.tipo == 3}">Administrativo</c:if></td>
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


