<%-- 
    Document   : municipioForm
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
                    <h2>Cadastro de Município</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value = "/cadastrosBasicos/municipio"/>" type="button" class="btn bgm-blue">Voltar</a>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST" id="municipioForm">
                    <div class="card-header">
                        <h4>Dados Básicos</h4>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="txtDescricao">Descrição</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Descrição" maxlength="50" name="descricao" class="form-control input-sm" id="txtDescricao" value="${municipio.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtCodigoIBGE" class="col-sm-2 control-label">Código(IBGE)</label>
                        <div class="col-md-2">
                            <div class="fg-line">
                                <input placeholder="Código(IBGE)" name="codigoIBGE" class="form-control input-sm" id="txtCodigoIBGE" value="${municipio.codigoIBGE}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="comboUnidadeFederacao" class="control-label col-sm-2">Unidade Federação</label>
                        <div class="col-md-4">
                            <select class="selectpicker" data-live-search="true" id="comboUnidadeFederacao" name="unidadeFederacao.id">
                                <option>Selecione o estado...</option>
                                <c:if test="${not empty unidadeFederacaoList}">
                                    <c:forEach var="unidadeFederacao" items="${unidadeFederacaoList}">
                                        <c:if test="${municipio.unidadeFederacao.id == unidadeFederacao.id}">
                                            <option selected value="${unidadeFederacao.id}">${unidadeFederacao.sigla} - ${unidadeFederacao.descricao}</option>    
                                        </c:if>
                                        <c:if test="${municipio.unidadeFederacao.id != unidadeFederacao.id}">
                                            <option value="${unidadeFederacao.id}">${unidadeFederacao.sigla} - ${unidadeFederacao.descricao}</option>    
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2"></label>
                        <div class="col-md-5">
                            <button type="submit" id="btnConfirmar" class="btn bgm-blue">Confirmar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

<script src="<c:url value="/js/municipioController.js"/>"></script>


