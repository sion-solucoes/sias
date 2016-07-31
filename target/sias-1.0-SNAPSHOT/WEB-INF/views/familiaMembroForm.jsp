<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" data-backdrop="static" id="familiaMembroModal" tabindex="-1" role="dialog" aria-labelledby="familiaMembroFormLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title" id="familiaMembroModalLabel">Cadastro de Membro Familiar</h2>
            </div>
            <div class="modal-body">
                <input id="txtId" type="number" hidden="true" name="id" value="${familiaMembro.id}">
                <form id="familiaMembroForm">
                    <%@include file="familiaMembroFormPanDadosBasicos.jsp" %>
                    <%@include file="familiaMembroFormPanDocumentosProvidenciaveis.jsp" %>
                    <%@include file="familiaMembroFormPanCondicoesEducacionais.jsp" %>
                    <%@include file="familiaMembroFormPanTrabalhoRendimentos.jsp" %>
                    <%@include file="familiaMembroFormPanSaude.jsp" %>
                </form>
            </div>
            <div class="modal-footer">
                <div class="row clearfix margem">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <a id="btnConfirmarFamiliaMembro" type="button" class="btn btn-primary buttons hvr-bob sias-default">
                            <img alt="" src="<c:url value="/img/icon-confirm.png"/>" class="img-rounded" />
                            Confirmar
                        </a>
                    </div>
                    <div class="col-md-4"></div>
                </div>
                <div class="row clearfix">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <a type="button" class="btn btn-primary buttons hvr-bob sias-default" data-dismiss="modal">
                            <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                            Cancelar
                        </a>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>
        </div>
    </div>
</div>
                            
<script type="text/javascript" src="<c:url value="/js/familiaMembroController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroDadosBasicosController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroDocumentosProvidenciaveisController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroCondicoesEducacionaisController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroTrabalhoRendimentosController.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/familiaMembroSaudeController.js"/>"></script>
