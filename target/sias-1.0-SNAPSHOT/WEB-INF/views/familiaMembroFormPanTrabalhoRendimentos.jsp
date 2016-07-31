<div id="familiaMembroFormPanTrabalhoRendimentos">
    <h3>Trabalho e Rendimentos</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-6">
            <input type="checkbox" name="possuiCarteiraTrabalho" class="sias-default" id="checkPossuiCarteiraTrabalho"/>
            <label for="checkPossuiCarteiraTrabalho">Possui carteira de trabalho</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <input id="txtCondicaoOcupacao" hidden="true" name="id" value="${familiaMembro.condicaoOcupacao.id}">
            <label for="comboCondicaoOcupacao">Condição de Ocupação</label>
            <select class="form-control sias-default" name="condicaoOcupacao" id="comboCondicaoOcupacao">
                <option disabled="true" selected>Selecione...</option>
            </select>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-6">
            <input type="checkbox" name="possuiQualificacaoProfissional" class="sias-default" id="checkPossuiQualificacaoProfissional"/>
            <label for="checkPossuiQualificacaoProfissional">Possui qualificação profissional</label>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12">
            <textarea class="form-control sias-default" rows="3" id="txtDescricaoQualificacaoProfissional">${familiaMembro.descricaoQualificacaoProfissional}</textarea>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-4">
            <label for="txtRendaMensal">Renda Mensal</label>
            <input type="text" value=0 placeholder="Renda Mensal" name="rendaMensal" class="form-control sias-default" id="txtRendaMensal" value="${familiaMembro.rendaMensal}"/>    
        </div>
    </div>
</div>