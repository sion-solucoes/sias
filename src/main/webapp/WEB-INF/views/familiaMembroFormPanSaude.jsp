<div id="familiaMembroFormPanSaude">
    <div class="card-header">
        <h3>Saúde</h3>
    </div>
    <hr>
    <div class="row form-group p-l-15">
        <div class="col-md-8">
            <input id="txtDeficiencia" hidden="true" name="id" value="${familiaMembro.deficiencia.id}">
            <label for="comboDeficiencia">Deficiência</label>
            <select class="selectpicker" title="Selecione..." name="deficiencia.id" id="comboDeficiencia">
                
            </select>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-6 m-l-15">
            <label for="checkNecessitaCuidadosConstantes">
                <input type="checkbox" name="necessitaCuidadosConstantes" id="checkNecessitaCuidadosConstantes"/>
                <i class="input-helper"></i>
                Necessita de cuidados constantes
            </label>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="col-md-12">
            <div class="fg-line">
                <label for="txtDescricaoNecessidadeCuidadosConstantes">Descreva a necessidade de cuidados constantes aqui...</label>
                <textarea class="form-control auto-size" id="txtDescricaoNecessidadeCuidadosConstantes">${familiaMembro.descricaoNecessidadeCuidadosConstantes}</textarea>
            </div>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-12 m-l-15">
            <label for="checkbox UsuarioRemediosControlados">
                <input type="checkbox" name="usuarioRemediosControlados" id="checkUsuarioRemediosControlados"/>
                <i class="input-helper"></i>
                Usuário de remédios controlados(tarja preta) para transtornos mentais
            </label>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-12 m-l-15">
            <label for="checkUsuarioBebidasAlcoolicas">
                <input type="checkbox" name="usuarioBebidasAlcoolicas" id="checkUsuarioBebidasAlcoolicas"/>
                <i class="input-helper"></i>
                Usuário de bebidas alcóolicas(uso abusivo)
            </label>
        </div>
    </div>
    <div class="row form-group p-l-15">
        <div class="checkbox col-md-12 m-l-15">
            <label for="checkUsuarioEntorpecentes">
                <input type="checkbox" name="usuarioEntorpecentes" id="checkUsuarioEntorpecentes"/>
                <i class="input-helper"></i>
                Usuário de entorpecentes(crak, cocaína, maconha, etc)
            </label>
        </div>
    </div>
    <div class="row form-group m-l-15">
        <div class="checkbox col-md-2">
            <label for="checkGestante">
                <input type="checkbox" name="gestante" class="sias-default" id="checkGestante"/>
                <i class="input-helper"></i>
                Gestante
            </label>
        </div>
        <div class="col-sm-2 p-r-0">
            <label for="txtMesesGestacao">Meses de Gestação</label>
        </div>
        <div class="col-sm-2">
            <div class="fg-line">
                <input type="text" onkeypress="formatInteiro(mesesGestacao);" placeholder="Meses de Gestação" name="mesesGestacao" class="form-control input-sm" id="txtMesesGestacao" value="${familiaMembro.mesesGestacao}"/>    
            </div>
        </div>
        <div class="checkbox col-md-5 m-l-15">
            <label for="checkIniciouPreNatal">
                <input type="checkbox" name="iniciouPreNatal" id="checkIniciouPreNatal"/>
                <i class="input-helper"></i>
                Inicou pré-natal
            </label>
        </div>
    </div>
</div>