<%-- 
    Document   : cepList
    Created on : 29/08/2015, 11:23:57
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Listagem de CEP</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value="/cadastrosBasicos/cep/novo"/>" type="button" class="btn bgm-blue">Novo</a>
                </div>
            </div>
            <div class="table-responsive">
                <table id="data-table-command" class="table table-striped table-vmiddle">
                    <thead>
                        <tr>
                            <th data-column-id="codigo">C�digo</th>
                            <th data-column-id="logradouro">Logradouro</th>
                            <th data-column-id="bairro">Bairro</th>
                            <th data-column-id="municipio">Munic�pio</th>
                            <th data-column-id="commands" data-formatter="commands" data-sortable="false">A��es</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty cepList}">
                            <c:forEach var="cep" items="${cepList}">
                                <tr>
                                    <td>
                                        ${cep.codigo}
                                    </td>
                                    <td>
                                        ${cep.logradouro}
                                    </td>
                                    <td>
                                        ${cep.bairro}
                                    </td>
                                    <td>
                                        ${cep.municipio.descricao}
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