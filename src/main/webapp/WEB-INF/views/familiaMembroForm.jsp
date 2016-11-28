<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade animated fadeInUp" id="familiaMembroModal" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="familiaMembroFormLabel" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="familiaMembroModalLabel">Cadastro de Membro Familiar</h4>
            </div>
            <div class="modal-body">
                <form class="form-wizard-basic fw-container form-horizontal" id="familiaMembroForm">
                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">
                                        Dados Básicos
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="collapse" role="tabpanel"
                                 aria-labelledby="headingOne">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanDadosBasicos.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingTwo">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        Documentos Providenciáveis
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanDocumentosProvidenciaveis.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingThree">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseThree" aria-expanded="false"
                                       aria-controls="collapseThree">
                                        Educação
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseThree" class="collapse" role="tabpanel"
                                 aria-labelledby="headingThree">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanCondicoesEducacionais.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingFour">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseFour" aria-expanded="false"
                                       aria-controls="collapseFour">
                                        Trabalho e Rendimentos
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseFour" class="collapse" role="tabpanel"
                                 aria-labelledby="headingFour">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanTrabalhoRendimentos.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingFive">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseFive" aria-expanded="false"
                                       aria-controls="collapseFive">
                                        Saúde
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseFive" class="collapse" role="tabpanel"
                                 aria-labelledby="headingFive">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanSaude.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingSix">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseSix" aria-expanded="false"
                                       aria-controls="collapseSix">
                                        Convivência Familiar, Intrafamiliar e Comunitária
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseSix" class="collapse" role="tabpanel"
                                 aria-labelledby="headingSix">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanConvivencia.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingSeven">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseSeven" aria-expanded="false"
                                       aria-controls="collapseSeven">
                                        Violência e Violações de Direitos
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseSeven" class="collapse" role="tabpanel"
                                 aria-labelledby="headingSeven">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanViolenciaViolacaoDireitos.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-collapse">
                            <div class="panel-heading" role="tab" id="headingEight">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseEight" aria-expanded="false"
                                       aria-controls="collapseEight">
                                        Acompanhamento
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseEight" class="collapse" role="tabpanel"
                                 aria-labelledby="headingEight">
                                <div class="panel-body">
                                    <jsp:include page="/WEB-INF/views/familiaMembroFormPanAcompanhamento.jsp"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-2">
                                <button type="submit" class="btn bgm-blue" id="btnConfirmarFamiliaMembro">Confirmar</button>
                            </div>
                            <div class="col-md-2">
                                <button type="button" class="btn bgm-white" data-dismiss="modal">Cancelar</button>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/js/familiaMembroController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroTrabalhoRendimentosController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroSaudeController.js"/>"></script>
