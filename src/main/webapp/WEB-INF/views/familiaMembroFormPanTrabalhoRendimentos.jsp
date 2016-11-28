<div id="familiaMembroFormPanTrabalhoRendimentos">
    <div class="card-header">
        <h3>Trabalho e Rendimentos</h3>
    </div>
    <hr>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-6 m-l-15">
            <label for="checkPossuiCarteiraTrabalho">
                <input type="checkbox" name="possuiCarteiraTrabalho" id="checkPossuiCarteiraTrabalho"/>
                <i class="input-helper"></i>
                Possui carteira de trabalho
            </label>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="col-md-8">
            <input id="txtCondicaoOcupacao" hidden="true" name="id" value="${familiaMembro.condicaoOcupacao.id}">
            <label for="comboCondicaoOcupacao">Condição de Ocupação</label>
            <select class="selectpicker" title="Selecione..." name="condicaoOcupacao" id="comboCondicaoOcupacao">
            </select>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-6 m-l-15">
            <label for="checkPossuiQualificacaoProfissional">
                <input type="checkbox" name="possuiQualificacaoProfissional" id="checkPossuiQualificacaoProfissional"/>
                <i class="input-helper"></i>
                Possui qualificação profissional
            </label>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="col-md-12">
            <div class="fg-line">
                <label for="txtDescricaoQualificacaoProfissional">Descrição da qualificação profissional</label>
                <textarea class="form-control auto-size" id="txtDescricaoQualificacaoProfissional">${familiaMembro.descricaoQualificacaoProfissional}</textarea>
            </div>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="col-md-4">
            <label for="txtRendaMensal">Renda Mensal</label>
            <div class="fg-line">
                <input type="text" value=0 placeholder="Renda Mensal" name="rendaMensal" class="form-control input-sm" id="txtRendaMensal" value="${familiaMembro.rendaMensal}"/>    
            </div>
        </div>
    </div>
</div>