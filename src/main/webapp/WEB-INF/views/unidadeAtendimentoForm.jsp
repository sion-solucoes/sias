<%-- 
    Document   : unidadeAtendimentoForm
    Created on : 22/10/2015, 12:02:56
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de Unidade de Atendimento</h2>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST" id="unidadeAtendimentoForm">
                    <div class="card-header">
                        <h4>Dados Básicos</h4>
                    </div>
                    <input id="txtId" type="number" hidden="true" name="id" value="${unidadeAtendimento.id}">
                    <input id="txtCEPEndereco" hidden="true" value="${unidadeAtendimento.cepEndereco.id}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tipo de Unidade</label>
                        <div class="col-sm-4">
                            <label class="radio radio-inline m-r-20">
                                <c:if test="${(unidadeAtendimento.tipo == 1) && (not empty unidadeAtendimento.tipo)}">
                                    <input type="radio" name="tipo" id="radioCRAS" value="1" checked>
                                </c:if>
                                <c:if test="${(unidadeAtendimento.tipo != 2) || (empty unidadeAtendimento.tipo)}">
                                    <input type="radio" name="tipo" id="radioCRAS" value="1">
                                </c:if>
                                <i class="input-helper"></i>
                                CRAS
                            </label>

                            <label class="radio radio-inline m-r-20">
                                <c:if test="${(unidadeAtendimento.tipo == 2) && (not empty unidadeAtendimento.tipo)}">
                                    <input type="radio" name="tipo" id="radioCREAS" value="2" checked>
                                </c:if>
                                <c:if test="${(unidadeAtendimento.tipo != 2) || (empty unidadeAtendimento.tipo)}">
                                    <input type="radio" name="tipo" id="radioCREAS" value="2">
                                </c:if>
                                <i class="input-helper"></i>
                                CREAS
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="txtCodigo" class="col-sm-2 control-label">Código</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" name="codigo" id="txtCodigo" value="${unidadeAtendimento.codigo}" placeholder="Código" maxlength="10">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtDescricao" class="col-sm-2 control-label">Descrição</label>
                        <div class="col-md-10">
                            <div class="fg-line">
                                <input placeholder="Descrição" maxlength="100" name="descricao" class="form-control input-sm" id="txtDescricao" value="${unidadeAtendimento.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="comboCEPEndereco" class="col-sm-2 control-label">CEP</label>
                        <div class="col-md-6">
                            <select class="selectpicker" title="Selecione..." data-live-search="true" id="comboCEPEndereco">
                                <c:if test="${not empty cepList}">
                                    <c:forEach var="cep" items="${cepList}">
                                        <option value="${cep.id}">${cep.codigo}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtMunicipioEndereco" class="col-sm-2 control-label">Município</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtMunicipioEndereco" value="${unidadeAtendimento.cepEndereco.municipio.descricao}" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtUFEndereco" class="control-label col-sm-2">UF</label>
                        <div class="col-md-5">
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtUFEndereco" value="${unidadeAtendimento.cepEndereco.municipio.unidadeFederacao.sigla} - ${unidadeAtendimento.cepEndereco.municipio.unidadeFederacao.descricao}" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtPaisEndereco" class="control-label col-sm-2">País</label>
                        <div class="col-md-5">
                            <div class="fg-line">
                                <input class="form-control input-sm" id="txtPaisEndereco" value="${unidadeAtendimento.cepEndereco.municipio.unidadeFederacao.pais.sigla} - ${unidadeAtendimento.cepEndereco.municipio.unidadeFederacao.pais.descricao}" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtLogradouroEndereco" class="col-sm-2 control-label">Logradouro</label>
                        <div class="col-md-5">
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtLogradouroEndereco" value="${unidadeAtendimento.logradouroEndereco}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtNumeroEndereco" class="col-sm-2 control-label">Número</label>
                        <div class="col-md-2">
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtNumeroEndereco" value="${unidadeAtendimento.numeroEndereco}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtBairroEndereco" class="col-sm-2 control-label">Bairro</label>
                        <div class="col-md-5">
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtBairroEndereco" value="${unidadeAtendimento.bairroEndereco}">
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-2">
                                <button type="submit" id="btnConfirmar" class="btn bgm-blue">Confirmar</button>
                            </div>
                            <div class="col-md-2">
                                <a href="<c:url value = "/controleAmbiente/unidadeAtendimento"/>" class="btn bgm-white">Voltar</a>
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

<script type="text/javascript" src="<c:url value="/js/unidadeAtendimentoController.js"/>"></script>
