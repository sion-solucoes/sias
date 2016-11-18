<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="familiaMembroModal" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="familiaMembroFormLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="familiaMembroModalLabel">Cadastro de Membro Familiar</h4>
            </div>
            <div class="modal-body">
                <form class="form-wizard-basic fw-container form-horizontal" id="familiaMembroForm">
                    <input id="txtId" type="number" hidden="true" name="id" value="${familiaMembro.id}">
                    <ul class="tab-nav">
                        <li><a href="#tab4" data-toggle="tab">Dados Básicos</a></li>
                        <li><a href="#tab5" data-toggle="tab">Documentos</a></li>
                        <li><a href="#tab6" data-toggle="tab">Educação</a></li>
                        <li><a href="#tab7" data-toggle="tab">Trabalho</a></li>
                        <li><a href="#tab8" data-toggle="tab">Saúde</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane animated fadeInUp" id="tab4">
                            <jsp:include page="/WEB-INF/views/familiaMembroFormPanDadosBasicos.jsp"/>
                        </div>
                        <div class="tab-pane animated fadeInUp" id="tab5">
                            <jsp:include page="/WEB-INF/views/familiaMembroFormPanDocumentosProvidenciaveis.jsp"/>
                        </div>
                        <div class="tab-pane animated fadeInUp" id="tab6">
                            <jsp:include page="/WEB-INF/views/familiaMembroFormPanCondicoesEducacionais.jsp"/>
                        </div>
                        <div class="tab-pane animated fadeInUp" id="tab7">
                            <jsp:include page="/WEB-INF/views/familiaMembroFormPanTrabalhoRendimentos.jsp"/>
                        </div>
                        <div class="tab-pane animated fadeInUp" id="tab8">
                            <jsp:include page="/WEB-INF/views/familiaMembroFormPanSaude.jsp"/>
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
