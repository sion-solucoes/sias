<div id="familiaMembroFormPanSaude">
    <h3>Saúde</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <input id="txtDeficiencia" hidden="true" name="id" value="${familiaMembro.deficiencia.id}">
            <label for="comboDeficiencia">Deficiência</label>
            <select class="form-control sias-default" name="deficiencia" id="comboDeficiencia">
                <option disabled="true" selected>Selecione...</option>
            </select>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-6">
            <input type="checkbox" name="necessitaCuidadosConstantes" class="sias-default" id="checkNecessitaCuidadosConstantes"/>
            <label for="checkNecessitaCuidadosConstantes">Necessita de cuidados constantes</label>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12">
            <textarea class="form-control sias-default" rows="3" id="txtDescricaoNecessidadeCuidadosConstantes">${familiaMembro.descricaoNecessidadeCuidadosConstantes}</textarea>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <input type="checkbox" name="usuarioRemediosControlados" class="sias-default" id="checkUsuarioRemediosControlados"/>
            <label for="checkUsuarioRemediosControlados">Usuário de remédios controlados(tarja preta) para transtornos mentais</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <input type="checkbox" name="usuarioBebidasAlcoolicas" class="sias-default" id="checkUsuarioBebidasAlcoolicas"/>
            <label for="checkUsuarioBebidasAlcoolicas">Usuário de bebidas alcóolicas(uso abusivo)</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <input type="checkbox" name="usuarioEntorpecentes" class="sias-default" id="checkUsuarioEntorpecentes"/>
            <label for="checkUsuarioEntorpecentes">Usuário de entorpecentes(crak, cocaína, maconha, etc)</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-3">
            <input type="checkbox" name="gestante" class="sias-default" id="checkGestante"/>
            <label for="checkGestante">Gestante</label>
        </div>
        <div class="col-md-3">
            <label for="txtMesesGestacao">Meses de Gestação</label>
        </div>
        <div class="col-md-3">
            <input type="text" onkeypress="formatInteiro(mesesGestacao);" placeholder="Meses de Gestação" name="mesesGestacao" class="form-control sias-default" id="txtMesesGestacao" value="${familiaMembro.mesesGestacao}"/>    
        </div>
        <div class="col-md-3">
            <input type="checkbox" name="iniciouPreNatal" class="sias-default" id="checkIniciouPreNatal"/>
            <label for="checkIniciouPreNatal">Inicou pré-natal</label>
        </div>
    </div>
</div>