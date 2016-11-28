<%-- 
    Document   : defienciaForm
    Created on : 01/09/2015, 20:33:10
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Relatório Mensal de Atendimento</h2>
                </div>
                <hr>
                <div class="card-body card-padding">
                    <div class="row form-group p-l-15">
                        <div class="col-md-3">
                            <label for="txtDataInicial">Mês de Referência</label>
                            <div class="fg-line">
                                <input type="date" disabled="true" pattern="mm/yyyy" class="form-control input-sm" id="txtDataInicial" value="${relatorioMensalAtendimento.dataInicial}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row form-group p-l-15">
                        <div class="col-md-12">
                            <label for="txtUnidadeAtendimento">Unidade de Atendimento</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.codigo} - ${relatorioMensalAtendimento.unidadeAtendimento.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row form-group p-l-15">
                        <div class="col-md-12">
                            <label for="txtEnderecoUnidadeAtendimento">Endereço</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtEnderecoUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.logradouroEndereco}, ${relatorioMensalAtendimento.unidadeAtendimento.numeroEndereco}, ${relatorioMensalAtendimento.unidadeAtendimento.bairroEndereco}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row form-group p-l-15">
                        <div class="col-md-12">
                            <label for="txtMunicipioUnidadeAtendimento">Município</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtMunicipioUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.cepEndereco.municipio.descricao} - ${relatorioMensalAtendimento.unidadeAtendimento.cepEndereco.municipio.unidadeFederacao.descricao}"/>    
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">

                    </div>
                    <div class="card-body card-padding">

                    </div>
                </div>


            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script src="<c:url value="/js/deficienciaController.js"/>" type="text/javascript"></script>