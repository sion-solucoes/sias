<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="familiaFormPanEndereco">
    <input id="txtCEPEndereco" hidden="true" name="cep.id" value="${familia.cepEndereco.id}">
    <div class="card-header">
        <h3>Condições Habitacionais(Endereço/Moradia)</h3>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Localização</label>
        <div class="col-md-6">
            <label class="radio-inline radio m-r-20 m-t-5" for="radioLocalizacaoEnderecoUrbana">
                <c:if test="${familia.localizacaoEndereco == null || familia.localizacaoEndereco == 0}">
                    <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoUrbana" value="0" checked>
                </c:if>
                <c:if test="${familia.localizacaoEndereco != null && familia.localizacaoEndereco != 0}">
                    <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoUrbana" value="0">
                </c:if>
                <i class="input-helper"></i>
                Urbana
            </label>

            <label class="radio radio-inline m-r-20 m-t-5" for="radioLocalizacaoEnderecoRural">
                <c:if test="${familia.localizacaoEndereco == 1}">
                    <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoRural" value="1" checked>
                </c:if>
                <c:if test="${familia.localizacaoEndereco != 1}">
                    <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoRural" value="1">
                </c:if>  
                <i class="input-helper"></i>
                Rural
            </label>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="checkEnderecoAbrigo">Abrigo</label>
        <div class="col-md-6">
            <label class="checkbox checkbox-inline m-r-20 m-t-5">
                <c:if test="${familia.enderecoAbrigo}">
                    <input type="checkbox" name="enderecoAbrigo" id="checkEnderecoAbrigo" checked/>    
                </c:if>
                <c:if test="${!familia.enderecoAbrigo}">
                    <input type="checkbox" name="enderecoAbrigo" id="checkEnderecoAbrigo"/>    
                </c:if>
                <i class="input-helper"></i>
            </label>
        </div>
    </div>

    <div class="form-group">
        <label for="comboCEPEndereco" class="control-label col-sm-2">CEP</label>
        <div class="col-md-6">
            <select class="selectpicker" title="Selecione..." name="cep.id" id="comboCEPEndereco">

            </select>
        </div>
    </div>

    <div class="form-group">
        <label for="txtMunicipioEndereco" class="control-label col-sm-2">Município</label>
        <div class="col-md-6">
            <div class="fg-line">        
                <input readonly="readonly" class="form-control input-sm" id="txtMunicipioEndereco" value="${familia.cepEndereco.municipio.descricao}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="txtUFEndereco" class="control-label col-sm-2">UF</label>
        <div class="col-md-3">
            <div class="fg-line">  
                <input readonly="readonly" class="form-control input-sm" id="txtUFEndereco" value="${familia.cepEndereco.municipio.unidadeFederacao.descricao}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="txtPaisEndereco" class="control-label col-sm-2">País</label>
        <div class="col-md-4">
            <div class="fg-line">  
                <input readonly="readonly" class="form-control input-sm" id="txtPaisEndereco" value="${familia.cepEndereco.municipio.unidadeFederacao.pais.descricao}">
            </div>
        </div>
    </div>  
    <div class="form-group">
        <label for="txtLogradouroEndereco" class="control-label col-sm-2">Logradouro</label>
        <div class="col-md-8">
            <div class="fg-line">       
                <input class="form-control input-sm" maxlength="255" name="logradouro" id="txtLogradouroEndereco" value="${familia.logradouroEndereco}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="txtNumeroEndereco" class="control-label col-sm-2">Número</label>
        <div class="col-md-4">
            <div class="fg-line">       
                <input class="form-control input-sm" maxlength="10" name="numero" id="txtNumeroEndereco" value="${familia.numeroEndereco}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="txtBairroEndereco" class="control-label col-sm-2">Bairro</label>
        <div class="col-md-4">
            <div class="fg-line">
                <input class="form-control input-sm" maxlength="100" name="bairro" id="txtBairroEndereco" value="${familia.bairroEndereco}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="txtPontoReferencia" class="control-label col-sm-2">Ponto de Referência</label>
        <div class="col-md-6">
            <div class="fg-line">
                <input class="form-control input-sm" maxlength="255" name="bairro" id="txtPontoReferenciaEndereco" value="${familia.pontoReferenciaEndereco}">
            </div>
        </div>
    </div>
    <div class="card-header">
        <h3>Informações Adicionais (Características do domicilío)</h3>
    </div>
    <div class="form-group">
        <label for="comboTipoResidencia" class="control-label col-sm-2">Tipo de Residência</label>
        <input type="hidden" id="tipoResidencia" value="${familia.tipoResidencia}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboTipoResidencia" id="comboTipoResidencia">
                <option value="1">Própria</option>
                <option value="2">Alugada</option>
                <option value="3">Cedida</option>
                <option value="4">Ocupada</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboMaterialParedes" class="control-label col-sm-2">Material das paredes externas do domicilío</label>
        <input type="hidden" id="materialParedes" value="${familia.materialParedesExternas}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboMaterialParedes" id="comboMaterialParedes">
                <option value="1">Alvenaria ou madeira aparelhada</option>
                <option value="2">Madeira aproveitada, taipa ou outros materiais precários</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboAcessoEnergia" class="control-label col-sm-2">Acesso a energia elétrica</label>
        <input type="hidden" id="acessoEnergiaEletrica" value="${familia.acessoEnergiaEletrica}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboAcessoEnergia" id="comboAcessoEnergia">
                <option value="1">Sim, com medidor próprio</option>
                <option value="2">Sim, com medidor compartilhado</option>
                <option value="3">Sim, sem medidor</option>
                <option value="4">Não possui energia elétrica no domicilío</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboAguaCanalizada" class="control-label col-sm-2">Possui água canalizada</label>
        <input type="hidden" id="aguaCanalizada" value="${familia.aguaCanalizada}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboAguaCanalizada" id="comboAguaCanalizada">
                <option value="1">Sim</option>
                <option value="2">Não</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboFormaAbastecimentoAgua" class="control-label col-sm-2">Forma de abastecimento de água</label>
        <input type="hidden" id="formaAbastecimentoAgua" value="${familia.formaAbastecimentoAgua}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboFormaAbastecimentoAgua" id="comboFormaAbastecimentoAgua">
                <option value="1">Rede geral de distribuição</option>
                <option value="2">Poço ou nascente</option>
                <option value="3">Cisterna de captação de águas da chuva</option>
                <option value="4">Carro pipa</option>
                <option value="5">Outra forma</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboEscoamentoSanitario" class="control-label col-sm-2">Escoamento sanitário</label>
        <input type="hidden" id="escoamentoSanitario" value="${familia.escoamentoSanitario}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboEscoamentoSanitario" id="comboEscoamentoSanitario">
                <option value="1">Rede coletora de esgoto ou pluvial</option>
                <option value="2">Fossa séptica</option>
                <option value="3">Fossa rudimentar</option>
                <option value="4">Direto para vala, rio, lago ou mar</option>
                <option value="5">Dimicílio sem banheiro</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboColetaLixo" class="control-label col-sm-2">Coleta de Lixo</label>
        <input type="hidden" id="coletaLixo" value="${familia.coletaLixo}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboColetaLixo" id="comboColetaLixo">
                <option value="1">Sim, coleta direta</option>
                <option value="2">Sim, coleta indireta</option>
                <option value="3">Não possui coleta</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="txtNumeroComodos" class="control-label col-sm-2">Número de cômodos</label>
        <div class="col-md-4">
            <div class="fg-line">
                <c:if test="${empty familia.numeroComodos}">
                    <input type="number" class="form-control input-sm" min="0" name="txtNumeroComodos" id="txtNumeroComodos" value="0">
                </c:if>
                <c:if test="${not empty familia.numeroComodos}">
                    <input type="number" class="form-control input-sm" min="0" name="txtNumeroComodos" id="txtNumeroComodos" value="${familia.numeroComodos}">
                </c:if>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="txtNumeroDormitorios" class="control-label col-sm-2">Número de dormitórios</label>
        <div class="col-md-4">
            <div class="fg-line">
                <c:if test="${empty familia.numeroDormitorios}">
                    <input type="number" class="form-control input-sm" min="0" name="txtNumeroDormitorios" id="txtNumeroDormitorios" value="0">
                </c:if>
                <c:if test="${empty familia.numeroDormitorios}">
                    <input type="number" class="form-control input-sm" min="0" name="txtNumeroDormitorios" id="txtNumeroDormitorios" value="${familia.numeroDormitorios}">
                </c:if>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="comboAcessibilidade" class="control-label col-sm-2">Acessibilidade para pessoas com dificuldade de locomoção</label>
        <input type="hidden" id="acessibilidade" value="${familia.acessibilidade}">
        <div class="col-md-7">
            <select class="selectpicker" title="Selecione..." name="comboAcessibilidade" id="comboAcessibilidade">
                <option value="1">Sim, tanto no espaço interno como na acesso a rua</option>
                <option value="2">Sim, apenas nos espaços internos, mas com barreiras na comunicação com a rua</option>
                <option value="3">Não possui condições de acessibilidade</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboLocalizacaoRisco" class="control-label col-sm-2">Localização em área de alagamento ou desabamento</label>
        <input type="hidden" id="localizacaoRisco" value="${familia.localizacaoAreaRisco}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboLocalizacaoRisco" id="comboLocalizacaoRisco">
                <option value="1">Sim</option>
                <option value="2">Não</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboAcessoGeografico" class="control-label col-sm-2">Localização em área de dificil acesso geográfico</label>
        <input type="hidden" id="acessoGeografico" value="${familia.dificilAcessoGeografico}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboAcessoGeografico" id="comboAcessoGeografico">
                <option value="1">Sim</option>
                <option value="2">Não</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="comboAreaViolencia" class="control-label col-sm-2">Localização em área de conflito/violência</label>
        <input type="hidden" id="areaViolencia" value="${familia.areaConflitoViolencia}">
        <div class="col-md-4">
            <select class="selectpicker" title="Selecione..." name="comboAreaViolencia" id="comboAreaViolencia">
                <option value="1">Sim</option>
                <option value="2">Não</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="txtObservacoesCondicoesHabitacionais" class="control-label col-sm-2">Observações das condições habitacionais da família</label>
        <div class="col-md-6">
            <div class="fg-line">
                <textarea class="form-control auto-size" id="txtObservacoesCondicoesHabitacionais" name="txtObservacoesCondicoesHabitacionais">${familia.observacoesCondicoesHabitacionais}</textarea>
            </div>
        </div>
    </div>
</div>

