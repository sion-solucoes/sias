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
            <select class="selectpicker" data-live-search="true" title="Selecione..." name="cep.id" id="comboCEPEndereco">
                
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
</div>
        
    