<%-- 
    Document   : especificidadeSocialList
    Created on : 29/08/2015, 11:26:40
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de Especificidade Social</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value="/controleFamiliar/especificidadeSocial/novo"/>" type="button" class="btn bgm-blue">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="descricao">Descrição</th>
                            <th data-column-id="indigena">Indígena</th>
                            <th data-column-id="povo">Povo/Etnia</th>
                            <th data-column-id="commands" data-formatter="commands" data-sorteable="false">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty especificidadeSocialList}">
                            <c:forEach var="especificidadeSocial" items="${especificidadeSocialList}">
                                <tr>
                                    <td>
                                        ${especificidadeSocial.descricao}
                                    </td>
                                    <td>
                                        <c:if test="${especificidadeSocial.indigena}" >
                                            Sim
                                        </c:if>
                                        <c:if test="${!especificidadeSocial.indigena}" >
                                            Não
                                        </c:if>
                                    </td>
                                    <td>
                                        ${especificidadeSocial.povoEtnia}
                                    </td>
                                    <!--<td>
                                        <a href="<c:url value="/controleFamiliar/especificidadeSocial/${especificidadeSocial.id}/excluir"/>">
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

        