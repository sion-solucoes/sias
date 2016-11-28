<%-- 
    Document   : familiaForm
    Created on : 29/08/2015, 11:27:10
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de Família</h2>
                </div>
                <div class="pull-right">
                    <div class="form-group">
                        <label>Última Alteração</label>
                        <div class="fg-line">
                            <input type="date" class="form-control" disabled="true" id="txtDataUltimaAlteracao" value="${familia.dataUltimaAlteracao}"/>    
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-wizard-basic fw-container form-horizontal" id="familiaForm">
                    <input id="txtId" type="hidden" name="id" value="${familia.id}">
                    <ul class="tab-nav text-center">
                        <li><a href="#tab1" data-toggle="tab">Dados Básicos</a></li>
                        <li><a href="#tab2" data-toggle="tab">Composição Familiar</a></li>
                        <li><a href="#tab3" data-toggle="tab">Condições Habitacionais</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane" id="tab1">
                            <jsp:include page="/WEB-INF/views/familiaFormPanDadosBasicos.jsp"/>
                        </div>
                        <div class="tab-pane" id="tab2">
                            <jsp:include page="/WEB-INF/views/familiaFormPanComposicaoFamiliar.jsp"/>
                        </div>
                        <div class="tab-pane" id="tab3">
                            <jsp:include page="/WEB-INF/views/familiaFormPanCondicoesHabitacionais.jsp"/>
                        </div>

                        <ul class="fw-footer pagination wizard">
                            <li class="previous first"><a class="a-prevent" href=""><i class="zmdi zmdi-more-horiz"></i></a></li>
                            <li class="previous"><a class="a-prevent" href=""><i class="zmdi zmdi-chevron-left"></i></a></li>
                            <li class="next"><a class="a-prevent" href=""><i class="zmdi zmdi-chevron-right"></i></a></li>
                            <li class="next last"><a class="a-prevent" href=""><i class="zmdi zmdi-more-horiz"></i></a></li>
                        </ul>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-2">
                                <button type="submit" class="btn bgm-blue" id="btnConfirmar">Confirmar</button>
                            </div>
                            <div class="col-md-2">
                                <a type="button" href="<c:url value = "/controleFamiliar/familia"/>" class="btn bgm-white">Voltar</a>
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

<jsp:include page="/WEB-INF/views/familiaMembroForm.jsp"/>

<script type="text/javascript" src="<c:url value="/js/familiaController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaDadosBasicosController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaComposicaoFamiliarController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaEnderecoController.js"/>"></script>

