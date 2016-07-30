<div id="familiaFormPanEndereco">
    <h3>Condições Habitacionais(Endereço/Moradia)</h3>
    <hr>
    <div class="row clearfix margem">
        <div class="col-md-12">
            <div class="row clearfix">
                <div class="col-md-1">
                    <label>Localização</label>
                </div>
                <div class="col-md-4" id="radioLocalizacaoEndereco">
                    <div class="radio-inline">
                        <label for="radioLocalizacaoEnderecoUrbana">
                            <c:if test="${familia.localizacaoEndereco == null || familia.localizacaoEndereco == 0}">
                                <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoUrbana" value="0" checked>
                            </c:if>
                            <c:if test="${familia.localizacaoEndereco != null && familia.localizacaoEndereco != 0}">
                                <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoUrbana" value="0">
                            </c:if>
                            Urbana
                        </label>
                    </div>
                    <div class="radio-inline">
                        <label for="radioLocalizacaoEnderecoRural">
                            <c:if test="${familia.localizacaoEndereco == 1}">
                                <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoRural" value="1" checked>
                            </c:if>
                            <c:if test="${familia.localizacaoEndereco != 1}">
                                <input type="radio" name="localizacaoEndereco" id="radioLocalizacaoEnderecoRural" value="1">
                            </c:if>  
                            Rural
                        </label>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-6">
                    <c:if test="${familia.enderecoAbrigo}">
                        <input type="checkbox" name="enderecoAbrigo" class="sias-default" id="checkEnderecoAbrigo" checked/>    
                    </c:if>
                    <c:if test="${!familia.enderecoAbrigo}">
                        <input type="checkbox" name="enderecoAbrigo" class="sias-default" id="checkEnderecoAbrigo"/>    
                    </c:if>
                    <label for="checkEnderecoAbrigo">Abrigo</label>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-3">
                    <input id="txtCEPEndereco" hidden="true" name="cep.id" value="${familia.cepEndereco.id}">
                    <label for="comboCEPEndereco">CEP</label>
                    <select class="form-control sias-default" name="cep.id" id="comboCEPEndereco">
                        <option disabled="true" selected>Selecione...</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="txtMunicipioEndereco">Município</label>
                    <input disabled="true" class="form-control sias-default" id="txtMunicipioEndereco" value="${familia.cepEndereco.municipio.descricao}">
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-3">
                    <label for="txtUFEndereco">UF</label>
                    <input disabled="true" class="form-control sias-default" id="txtUFEndereco" value="${familia.cepEndereco.municipio.unidadeFederacao.descricao}">
                </div>
                <div class="col-md-6">
                    <label for="txtPaisEndereco">País</label>
                    <input disabled="true" class="form-control sias-default" id="txtPaisEndereco" value="${familia.cepEndereco.municipio.unidadeFederacao.pais.descricao}">
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-6">
                    <label for="txtLogradouroEndereco">Logradouro</label>
                    <input class="form-control sias-default" maxlength="255" name="logradouro" id="txtLogradouroEndereco" value="${familia.logradouroEndereco}">
                </div>
                <div class="col-md-2">
                    <label for="txtNumeroEndereco">Número</label>
                    <input class="form-control sias-default" maxlength="10" name="numero" id="txtNumeroEndereco" value="${familia.numeroEndereco}">
                </div>
                <div class="col-md-4">
                    <label for="txtBairroEndereco">Bairro</label>
                    <input class="form-control sias-default" maxlength="100" name="bairro" id="txtBairroEndereco" value="${familia.bairroEndereco}">
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-4">
                    <label for="txtPontoReferencia">Ponto de Referência</label>
                    <input class="form-control sias-default" maxlength="255" name="bairro" id="txtPontoReferenciaEndereco" value="${familia.pontoReferenciaEndereco}">
                </div>
            </div>
        </div>
    </div>
</div>