<%-- 
    Document   : cepForm
    Created on : 29/08/2015, 11:23:19
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de CEP</h2>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST" id="cepForm">
                    <div class="card-header">
                        <h4>Dados Básicos</h4>
                    </div>
                    <input type="hidden" id="txtId" value="${cep.id}"/>
                    <div class="form-group">
                        <label for="txtCodigo" class="control-label col-sm-2">Código</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input placeholder="Código" maxlength="10" onkeypress="formatCEP(codigo);" name="codigo" class="form-control input-sm" id="txtCodigo" value="${cep.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtLogradouro" class="control-label col-sm-2">Logradouro</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Logradouro" maxlength="255" name="logradouro" class="form-control input-sm" id="txtLogradouro" value="${cep.logradouro}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtBairro" class="control-label col-sm-2">Bairro</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Bairro" maxlength="100" name="bairro" class="form-control input-sm" id="txtBairro" value="${cep.bairro}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="comboMunicipio" class="control-label col-sm-2">Município</label>
                        <div class="col-md-4">
                            <select class="selectpicker" title="Selecione o município..." data-live-search="true" name="municipio.id" id="comboMunicipio">

                                <c:if test="${not empty municipioList}">
                                    <c:forEach var="municipio" items="${municipioList}">
                                        <c:if test="${cep.municipio.id == municipio.id}">
                                            <option selected="true" value="${municipio.id}">${municipio.descricao}</option>    
                                        </c:if>
                                        <c:if test="${cep.municipio.id != municipio.id}">
                                            <option value="${municipio.id}">${municipio.descricao}</option>    
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-2">
                                <button type="submit" id="btnConfirmar" class="btn bgm-blue">Confirmar</button>
                            </div>
                            <div class="col-md-2">
                                <a href="<c:url value = "/cadastrosBasicos/cep"/>" type="button" class="btn bgm-white">Voltar</a>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script type="text/javascript" src="<c:url value="/js/Formatter.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/cepController.js"/>"></script>
