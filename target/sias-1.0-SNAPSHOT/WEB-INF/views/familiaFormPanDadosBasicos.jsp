<div id="familiaFormPanDadosBasicos">
    <h3>Dados B�sicos</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <input id="txtFormaIngresso" hidden="true" name="formaIngresso.id" value="${familia.formaIngresso.id}">
            <label for="comboFormaIngresso">Forma de Ingresso</label>
            <select class="form-control sias-default" name="formaIngresso.id" id="comboFormaIngresso">
                <option disabled="true" selected>Selecione...</option>
            </select>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12">
            <label for="txtDetalheFormaIngressoEncaminhamento">Detalhe o nome e contato do �rg�o/unidade que encaminhou o usu�rio/a fam�lia(detalhe da forma de ingresso)</label>
            <textarea class="form-control sias-default" rows="2" id="txtDetalheFormaIngressoEncaminhamento">${familia.detalheFormaIngressoEncaminhamento}</textarea>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12">
            <label for="txtObservacaoFormaIngresso">Quais raz�es, demandas ou necessidades motivaram o atendimento?(observa��o da forma de ingresso)</label>
            <textarea class="form-control sias-default" rows="5" id="txtObservacaoFormaIngresso">${familia.observacaoFormaIngresso}</textarea>
        </div>
    </div>
</div>