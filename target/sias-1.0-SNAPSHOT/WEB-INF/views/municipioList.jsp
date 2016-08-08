<%-- 
    Document   : municipioList
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
                    <h2>Listagem de Munic�pios</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value="/cadastrosBasicos/municipio/novo"/>" type="button" class="btn bgm-blue">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="descricao">Descri��o</th>
                            <th data-column-id="codigo">C�digo(IBGE)</th>
                            <th data-column-id="uf">Unidade Federa��o</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">A��es</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty municipioList}">
                            <c:forEach var="municipio" items="${municipioList}">
                                <tr>
                                    <td>
                                        ${municipio.descricao}
                                    </td>
                                    <td>
                                        ${municipio.codigoIBGE}
                                    </td>
                                    <td>
                                        ${municipio.unidadeFederacao.sigla} - ${municipio.unidadeFederacao.descricao}
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

    

