$('#comboCEPEndereco').ready(function (event) {

    var txtComboCEP = document.getElementById('txtCEPEndereco');
    var cepId = txtComboCEP.value;
    var combo = document.getElementById('comboCEPEndereco');
    var txtMunicipio = document.getElementById('txtMunicipioEndereco');
    var txtUF = document.getElementById('txtUFEndereco');
    var txtPais = document.getElementById('txtPaisEndereco');

    $.ajax({
        method: 'POST',
        url: '/sias/cadastrosBasicos/cep/readAll',
        success: function (data) {
            var cepList = data;
            if (cepList != null) {
                for (var indexCEP = 0; indexCEP < cepList.length; indexCEP++) {
                    var cep = cepList[indexCEP];
                    var option = document.createElement("option");
                    option.value = cep.id;
                    option.innerText = cep.codigo;
                    if (cepId == cep.id) {
                        option.selected = true;
                        var data = {
                            id: cepId
                        };
                        $.ajax({
                            method: 'POST',
                            url: '/sias/cadastrosBasicos/cep/readById',
                            data: data,
                            success: function (data) {
                                var cep = data;
                                if (cep != null) {
                                    txtMunicipio.value = cep.municipio.descricao;
                                    txtUF.value = cep.municipio.unidadeFederacao.sigla + ' - ' + cep.municipio.unidadeFederacao.descricao;
                                    txtPais.value = cep.municipio.unidadeFederacao.pais.sigla + ' - ' + cep.municipio.unidadeFederacao.pais.descricao;
                                }
                            }
                        });
                    }
                    combo.appendChild(option);
                }
            }
        }
    });
});

$('#comboCEPEndereco').change(function (event) {

    var combo = document.getElementById('comboCEPEndereco');
    var id = combo.value;
    var txtMunicipio = document.getElementById('txtMunicipioEndereco');
    var txtUF = document.getElementById('txtUFEndereco');
    var txtPais = document.getElementById('txtPaisEndereco');

    var data = {
        id: id
    };

    if (id != null && id != "" && id != "Selecione...") {
        $.ajax({
            method: 'POST',
            url: '/sias/cadastrosBasicos/cep/readById',
            data: data,
            success: function (data) {
                var cep = data;
                if (cep != null) {
                    txtMunicipio.value = cep.municipio.descricao;
                    txtUF.value = cep.municipio.unidadeFederacao.sigla + ' - ' + cep.municipio.unidadeFederacao.descricao;
                    txtPais.value = cep.municipio.unidadeFederacao.pais.sigla + ' - ' + cep.municipio.unidadeFederacao.pais.descricao;
                }
            }
        });
    } else {
        txtMunicipio.value = null;
        txtUF.value = null;
        txtPais.value = null;
    }

});