<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="familiaFormPanDadosBasicos">
    <div class="card-header">
        <h3>Dados Básicos</h3>
    </div>
    <div class="row form-group p-l-30">
        <div class="col-md-6">
            <label for="comboFormaIngresso">Forma de Ingresso</label>
            <input id="txtFormaIngresso" hidden="true" name="formaIngresso.id" value="${familia.formaIngresso.id}">
            <select class="selectpicker" title="Selecione..." name="formaIngresso.id" id="comboFormaIngresso">

            </select>
        </div>
    </div>
    <div class="row form-group p-l-30">
        <div class="col-md-10">
            <label for="txtDetalheFormaIngressoEncaminhamento">Detalhe o nome e contato do órgão/unidade que encaminhou o usuário/a família(detalhe da forma de ingresso)</label>
            <div class="fg-line">
                <textarea class="form-control auto-size" id="txtDetalheFormaIngressoEncaminhamento">${familia.detalheFormaIngressoEncaminhamento}</textarea>
            </div>
        </div>
    </div>
    <div class="row form-group p-l-30">
        <div class="col-md-10">
            <label for="txtObservacaoFormaIngresso">Quais razões, demandas ou necessidades motivaram o atendimento?(observação da forma de ingresso)</label>
            <div class="fg-line">
                <textarea class="form-control auto-size" id="txtObservacaoFormaIngresso">${familia.observacaoFormaIngresso}</textarea>
            </div>
        </div>
    </div>
</div>