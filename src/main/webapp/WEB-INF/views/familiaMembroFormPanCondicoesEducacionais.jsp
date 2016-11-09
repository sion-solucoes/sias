<div id="familiaMembroFormPanCondicoesEducacionais">
    <div class="card-header">
        <h3>Condições Educacionais</h3>
    </div>
    <hr>
    <div class="row form-group p-l-15">
        <div class="col-md-8">
            <input id="txtEscolaridade" hidden="true" name="id" value="${familiaMembro.escolaridade.id}">
            <label for="comboEscolaridade">Escolaridade</label>
            <select class="selectpicker" title="Selecione..." name="escolaridade.id" id="comboEscolaridade">

            </select>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-4 m-l-15">
            <label for="checkSabeLerEscrever">
                <input type="checkbox" name="sabeLerEscrever" id="checkSabeLerEscrever"/>
                <i class="input-helper"></i>
                Sabe Ler e Escrever
            </label>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-4 m-l-15">
            <label for="checkFrequentaEscolaAtualmente">
                <input type="checkbox" name="frequentaEscolaAtualmente" id="checkFrequentaEscolaAtualmente"/>
                <i class="input-helper"></i>
                Frequenta Escola Atualmente
            </label>
        </div>
    </div>
</div>