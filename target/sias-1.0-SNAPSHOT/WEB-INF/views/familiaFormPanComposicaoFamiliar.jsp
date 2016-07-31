<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="familiaFormPanComposicaoFamiliar">
    <h3>Composição Familiar</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-4"></div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary buttons hvr-bob sias-default" id="btnAdicionarMembro">
                <img alt="" src="<c:url value="/img/icon-add.png"/>" class="img-rounded" />
                Adicionar Membro
            </button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary buttons hvr-bob sias-default" id="btnEditarMembro">
                <img alt="" src="<c:url value="/img/icon-edit.png"/>" class="img-rounded" />
                Editar Membro
            </button>
        </div>
        <div class="col-md-4"></div>
    </div>
    <%@include file="familiaMembroForm.jsp" %>
    <table class="table table-striped" id="tabelaComposicaoFamiliar">
        <thead>
            <tr>
                <th></th>
                <th>Nome</th>
                <th>Grau Parentesco</th>
                <th><span class="glyphicon glyphicon-trash"></span></th>
            </tr>
        </thead>
    </table>
</div>