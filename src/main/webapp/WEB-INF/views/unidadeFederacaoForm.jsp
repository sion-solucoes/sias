<%-- 
    Document   : unidadeFederacaoForm
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
                    <h2>Cadastro de Unidade Federativa</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value = "/cadastrosBasicos/unidadeFederacao"/>" type="button" class="btn bgm-blue">Voltar</a>
                </div>
            </div>
                
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST" id="unidadeFederativaForm">
                    <div class="card-header">
                        <h4>Dados B�sicos</h4>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="txtSigla">Sigla</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input placeholder="Sigla" maxlength="2" name="sigla" class="form-control input-sm" id="txtSigla" value="${unidadeFederacao.sigla}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="txtDescricao">Descri��o</label>
                        <div class="col-md-5">
                            <div class="fg-line">
                                <input placeholder="Descri��o" maxlength="50" name="descricao" class="form-control input-sm" id="txtDescricao" value="${unidadeFederacao.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtCodigoIBGE" class="control-label col-sm-2">C�digo(IBGE)</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input placeholder="C�digo(IBGE)" name="codigoIBGE" class="form-control input-sm" id="txtCodigoIBGE" value="${unidadeFederacao.codigoIBGE}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="comboPais" class="col-sm-2 control-label">Pais</label>
                        <div class="col-md-5">
                            <select class="selectpicker" data-live-search="true" id="comboPais" name="pais.id">
                                <option>Selecione o pais...</option>
                                <c:if test="${not empty paisList}">
                                    <c:forEach var="pais" items="${paisList}">
                                        <c:if test="${unidadeFederacao.pais.id == pais.id}">
                                            <option selected value="${pais.id}">${pais.sigla} - ${pais.descricao}</option>
                                        </c:if>
                                        <c:if test="${unidadeFederacao.pais.id != pais.id}">
                                            <option value="${pais.id}">${pais.sigla} - ${pais.descricao}</option>
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

<script src="<c:url value="/js/unidadeFederacaoController.js"/>"></script>


   


