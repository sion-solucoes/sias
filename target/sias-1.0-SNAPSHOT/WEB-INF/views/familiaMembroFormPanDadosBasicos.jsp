<div id="familiaMembroFormPanDadosBasicos">
    <h3>Dados Básicos</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <label for="comboGrauParentesco">Grau de Parentesco(com o membro de referência)</label>
            <input hidden="true" id="txtGrauParentesco" value="${familiaMembro.grauParentesco.id}">
            <select class="form-control sias-default" name="grauParentesco.id" id="comboGrauParentesco">
                <option disabled="true" selected>Selecione...</option>
            </select>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <label for="txtNome">Nome</label>
            <input type="text" placeholder="Nome" name="nome" class="form-control sias-default" id="txtNome" value="${familiaMembro.nome}"/>    
        </div>
        <div class="col-md-4">
            <label for="comboSexo">Sexo</label>
            <select class="form-control sias-default" name="sexo" id="comboSexo">
                <option disabled="true" selected>Selecione...</option>
                <option value="0">Masculino</option>
                <option value="1">Feminino</option>
            </select>
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <label for="txtApelido">Apelido</label>
            <input type="text" placeholder="Apelido" name="apelido" class="form-control sias-default" id="txtApelido" value="${familiaMembro.apelido}"/>    
        </div>
        <div class="col-md-4">
            <label for="txtDataNascimento">Data de Nascimento</label>
            <input type="date" placeholder="Data de Nascimento" name="dataNascimento" class="form-control sias-default" id="txtDataNascimento" value="${familiaMembro.dataNascimento}"/>    
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-8">
            <label for="txtNomeMae">Nome da Mãe</label>
            <input type="text" placeholder="Nome da Mãe" name="nomeMae" class="form-control sias-default" id="txtNomeMae" value="${familiaMembro.nomeMae}"/>    
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-3">
            <label for="txtNIS">NIS</label>
            <input placeholder="NIS" name="nis" class="form-control sias-default" id="txtNIS" value="${familiaMembro.nis}"/>    
        </div>
        <div class="col-md-3">
            <label for="txtCPF">CPF</label>
            <input type="text" onkeypress="formatCPF(cpf);" placeholder="CPF" name="cpf" class="form-control sias-default" id="txtCPF" value="${familiaMembro.cpf}"/>    
        </div>
    </div>
    <div class="row clearfix margem">
        <div class="col-md-3">
            <label for="txtRG">RG</label>
            <input type="text" placeholder="RG" name="rg" class="form-control sias-default" id="txtRG" value="${familiaMembro.rg}"/>    
        </div>
        <div class="col-md-3">
            <label for="txtRGOrgaoExpedidor">Órgão Expedidor(RG)</label>
            <input type="text" placeholder="Órgão Expedidor(RG)" name="rgOrgaoExpedidor" class="form-control sias-default" id="txtRGOrgaoExpedidor" value="${familiaMembro.rgOrgaoExpedidor}"/>    
        </div>
        <div class="col-md-3">
            <label for="txtRGUFEmissao">UF Emissão(RG)</label>
            <input type="text" placeholder="UF Emissão(RG)" name="rgUFEmissao" class="form-control sias-default" id="txtRGUFEmissao" value="${familiaMembro.rgUFEmissao}"/>    
        </div>
        <div class="col-md-3">
            <label for="txtRGDataEmissao">Data Emissão(RG)</label>
            <input type="date" placeholder="Data Emissão(RG)" name="rgDataEmissao" class="form-control sias-default" id="txtRGDataEmissao" value="${familiaMembro.rgDataEmissao}"/>    
        </div>
    </div>
</div>