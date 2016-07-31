<div id="familiaMembroFormPanSaude">
    <h3>Sa�de</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <input id="txtDeficiencia" hidden="true" name="id" value="${familiaMembro.deficiencia.id}">
            <label for="comboDeficiencia">Defici�ncia</label>
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
            <label for="checkUsuarioRemediosControlados">Usu�rio de rem�dios controlados(tarja preta) para transtornos mentais</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <input type="checkbox" name="usuarioBebidasAlcoolicas" class="sias-default" id="checkUsuarioBebidasAlcoolicas"/>
            <label for="checkUsuarioBebidasAlcoolicas">Usu�rio de bebidas alc�olicas(uso abusivo)</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <input type="checkbox" name="usuarioEntorpecentes" class="sias-default" id="checkUsuarioEntorpecentes"/>
            <label for="checkUsuarioEntorpecentes">Usu�rio de entorpecentes(crak, coca�na, maconha, etc)</label>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-3">
            <input type="checkbox" name="gestante" class="sias-default" id="checkGestante"/>
            <label for="checkGestante">Gestante</label>
        </div>
        <div class="col-md-3">
            <label for="txtMesesGestacao">Meses de Gesta��o</label>
        </div>
        <div class="col-md-3">
            <input type="text" onkeypress="formatInteiro(mesesGestacao);" placeholder="Meses de Gesta��o" name="mesesGestacao" class="form-control sias-default" id="txtMesesGestacao" value="${familiaMembro.mesesGestacao}"/>    
        </div>
        <div class="col-md-3">
            <input type="checkbox" name="iniciouPreNatal" class="sias-default" id="checkIniciouPreNatal"/>
            <label for="checkIniciouPreNatal">Inicou pr�-natal</label>
        </div>
    </div>
</div>