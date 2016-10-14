$('#btnConfirmar').click(function (event) {

    var txtId = $('#txtId');
    var comboFormaIngresso = $('#comboFormaIngresso');
    var txtDetalheFormaIngressoEncaminhamento = $('#txtDetalheFormaIngressoEncaminhamento');
    var txtObservacaoFormaIngresso = $('#txtObservacaoFormaIngresso');
    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    var composicaoFamiliarCheckList = tabelaComposicaoFamiliar.find('input:checkbox');
    var familiaMembroList = new Array();
    for (var indexComposicaoFamiliarCheck = 0; indexComposicaoFamiliarCheck < composicaoFamiliarCheckList.length; indexComposicaoFamiliarCheck++) {
        var checkComposicaoFamiliar = composicaoFamiliarCheckList[indexComposicaoFamiliarCheck];
        var familiaMembro = JSON.parse($(checkComposicaoFamiliar).val());
        familiaMembroList.push(familiaMembro);
    }
    var radioLocalizacao = $("input[type=radio][name='localizacaoEndereco']:checked").val();
    var checkEnderecoAbrigo = $('#checkEnderecoAbrigo');
    var comboCEPEndereco = $('#comboCEPEndereco');
    var txtLogradouroEndereco = $('#txtLogradouroEndereco');
    var txtNumeroEndereco = $('#txtNumeroEndereco');
    var txtBairroEndereco = $('#txtBairroEndereco');
    var txtPontoReferenciaEndereco = $('#txtPontoReferenciaEndereco');

    var id = null;
    if (txtId.val() != "") {
        id = txtId.val();
    }

    var familia = {
        id: id,
        formaIngresso: {
            id: comboFormaIngresso.val()
        },
        detalheFormaIngressoEncaminhamento: txtDetalheFormaIngressoEncaminhamento.val(),
        observacaoFormaIngresso: txtObservacaoFormaIngresso.val(),
        familiaMembroList: familiaMembroList,
        localizacaoEndereco: radioLocalizacao,
        enderecoAbrigo: checkEnderecoAbrigo.prop('checked'),
        cepEndereco: {
            id: comboCEPEndereco.val()
        },
        logradouroEndereco: txtLogradouroEndereco.val(),
        numeroEndereco: txtNumeroEndereco.val(),
        bairroEndereco: txtBairroEndereco.val(),
        pontoReferenciaEndereco: txtPontoReferenciaEndereco.val()
    };

    var data = {
        json: JSON.stringify(familia)
    };

    $.ajax({
        method: 'POST',
        url: '/controleFamiliar/familia/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/controleFamiliar/familia');
                    };
                    Msg.notify(data.msg, 'success', 2000, null, voltarListagem);
                } else {
                    Msg.notify(data.msg, 'warning');
                }
            }
        }
    });

});


