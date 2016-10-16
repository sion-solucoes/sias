<%-- 
    Document   : familiaRequisicaoBeneficioEventualForm
    Created on : 16/10/2016, 11:33:18
    Author     : jaderhenrique
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Requisição de Benefício Eventual para família</h2>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" id="familiaBeneficioEventualForm">
                    <hr>
                    <div class="form-group p-l-15">
                        <div class="col-md-6">
                            <label for="comboFamilia" class="control-label">Família</label>
                            <select class="selectpicker" title="Selecione..." data-live-search="true" id="comboFamilia">
                                <c:if test="${not empty familiaList}">
                                    <c:forEach var="familia" items="${familiaList}">
                                        <option value="${familia.id}">${familia.nomePessoaReferencia} | Endereço: ${familia.logradouroEndereco}, ${familia.numeroEndereco}, ${familia.bairroEndereco}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group p-l-15">
                        <div class="col-md-6">
                            <label for="comboBeneficioEventual" class="control-label">Benefício Eventual</label>
                            <select class="selectpicker" title="Selecione..." data-live-search="true" id="comboBeneficioEventual">
                                <c:if test="${not empty beneficioEventualList}">
                                    <c:forEach var="beneficioEventual" items="${beneficioEventualList}">
                                        <option value="${beneficioEventual.id}">${beneficioEventual.codigo} - ${beneficioEventual.descricao}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group p-l-15">
                        <div class="col-md-6">
                            <label class="control-label">Data de solicitação</label>
                            <div class="dtp-container">
                                <input type="text" placeholder="Data de solicitação" name="dataSolicitacao" class="form-control date-picker" id="txtDataSolicitacao"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group p-l-15">
                        <div class="col-md-6">
                            <label class="control-label">Data de concessão</label>
                            <div class="dtp-container">
                                <input type="text" placeholder="Data de concessão" name="dataConcessao" class="form-control date-picker" id="txtDataConcessao"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group p-l-15">
                        <label class="control-label"></label>
                        <div class="col-md-4">
                            <button type="submit" class="btn bgm-blue" id="btnConfirmar">Confirmar</button>
                            <a href="<c:url value="/controleFamiliar/requisicaoBeneficio"/>" type="button" class="btn bgm-white m-l-15">Voltar</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

<script src="<c:url value="/js/familiaBeneficioEventualController.js"/>" type="text/javascript"></script>


