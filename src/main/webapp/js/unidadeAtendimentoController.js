/*
$('body').ready(function (event) {

    var txtComboCEPEndereco = document.getElementById('txtCEPEndereco');
    var cepId = txtComboCEPEndereco.value;
    var combo = document.getElementById('comboCEPEndereco');
    var txtMunicipioEndereco = document.getElementById('txtMunicipioEndereco');
    var txtUFEndereco = document.getElementById('txtUFEndereco');
    var txtPaisEndereco = document.getElementById('txtPaisEndereco');

    $.ajax({
        method: 'POST',
        url: '/sias/cadastrosBasicos/cep/readAll',
        success: function (data) {
            var cepList = data;
            if (cepList != null) {
                for (var indexCEPEndereco = 0; indexCEPEndereco < cepList.length; indexCEPEndereco++) {
                    var cep = cepList[indexCEPEndereco];
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
                                    txtMunicipioEndereco.value = cep.municipio.descricao;
                                    txtUFEndereco.value = cep.municipio.unidadeFederacao.sigla + ' - ' + cep.municipio.unidadeFederacao.descricao;
                                    txtPaisEndereco.value = cep.municipio.unidadeFederacao.pais.sigla + ' - ' + cep.municipio.unidadeFederacao.pais.descricao;
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
*/

$('#comboCEPEndereco').change(function (event) {

    var combo = document.getElementById('comboCEPEndereco');
    var id = combo.value;
    var txtMunicipioEndereco = document.getElementById('txtMunicipioEndereco');
    var txtUFEndereco = document.getElementById('txtUFEndereco');
    var txtPaisEndereco = document.getElementById('txtPaisEndereco');
    
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
                    txtMunicipioEndereco.value = cep.municipio.descricao;
                    txtUFEndereco.value = cep.municipio.unidadeFederacao.sigla + ' - ' + cep.municipio.unidadeFederacao.descricao;
                    txtPaisEndereco.value = cep.municipio.unidadeFederacao.pais.sigla + ' - ' + cep.municipio.unidadeFederacao.pais.descricao;
                }
            }
        });
    } else {
        txtMunicipioEndereco.value = null;
        txtUFEndereco.value = null;
        txtPaisEndereco.value = null;
    }

});

$('#btnConfirmar').click(function (event) {

    var txtId = document.getElementById("txtId");
    var radioCRAS = document.getElementById("radioCRAS");
    var radioCREAS = document.getElementById("radioCREAS");
    var txtCodigo = document.getElementById("txtCodigo");
    var txtDescricao = document.getElementById("txtDescricao");
    var comboCEPEndereco = document.getElementById("comboCEPEndereco");
    var txtLogradouroEndereco = document.getElementById("txtLogradouroEndereco");
    var txtNumeroEndereco = document.getElementById("txtNumeroEndereco");
    var txtBairroEndereco = document.getElementById("txtBairroEndereco");
    var tipo = null;
    if (radioCRAS.checked) {
        tipo = 1;
    } else if (radioCREAS.checked) {
        tipo = 2;
    }

    var id = null;
    if (txtId.value != null && txtId.value != "") {
        id = txtId.value;
    }
    var cepId = null;
    if (comboCEPEndereco.value != "" && comboCEPEndereco.value != "Selecione...") {
        cepId = comboCEPEndereco.value;
    }

    var unidadeAtendimento = {
        id: id,
        tipo: tipo,
        codigo: txtCodigo.value,
        descricao: txtDescricao.value,
        cepEndereco: {
            id: cepId
        },
        logradouroEndereco: txtLogradouroEndereco.value,
        numeroEndereco: txtNumeroEndereco.value,
        bairroEndereco: txtBairroEndereco.value
    };
    
    var data = {
        json: JSON.stringify(unidadeAtendimento)
    };
    
    $.ajax({
        method: 'POST',
        url: '/sias/controleAmbiente/unidadeAtendimento/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                var msg = data.msg;
                if (msg != null) {
                    if (success) {
                        $('#msgSuccess').text(msg);
                        $('#dlgSuccess').modal('show');
                        setTimeout(function () {
                            document.location.assign('/sias/controleAmbiente/unidadeAtendimento');
                        }, 3000);
                    } else {
                        $('#msgFailure').text(msg);
                        $('#dlgFailure').modal('show');
                        setTimeout(function () {
                            $('#dlgFailure').modal('hide');
                        }, 3000);
                    }
                }
            }
        }
    });
});