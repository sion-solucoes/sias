<div id="familiaMembroFormPanCondicoesEducacionais">
    <h3>Condições Educacionais</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <input id="txtEscolaridade" hidden="true" name="id" value="${familiaMembro.escolaridade.id}">
            <label for="comboEscolaridade">Escolaridade</label>
            <select class="form-control sias-default" name="sexo" id="comboEscolaridade">
                <option disabled="true" selected>Selecione...</option>
            </select>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-4">
            <input type="checkbox" name="sabeLerEscrever" class="sias-default" id="checkSabeLerEscrever"/>
            <label for="checkSabeLerEscrever">Sabe Ler e Escrever</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-4">
            <input type="checkbox" name="frequentaEscolaAtualmente" class="sias-default" id="checkFrequentaEscolaAtualmente"/>
            <label for="checkFrequentaEscolaAtualmente">Frequenta Escola Atualmente</label>
        </div>
    </div>
</div>