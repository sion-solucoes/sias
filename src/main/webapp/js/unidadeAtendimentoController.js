$("#unidadeAtendimento").ready(function (){
    var unidadeAtendimentoCEPEndereco = $("#txtCEPEndereco").val();
    var comboCEPEndereco = $("#comboCEPEndereco");
    comboCEPEndereco.val(unidadeAtendimentoCEPEndereco);
    comboCEPEndereco.selectpicker("refresh");
});

$('#btnConfirmar').submit(function (event) {

    var id = $("#txtId").val();

    if (id == "") {
        id = null;
    }

    var unidadeAtendimento = {
        id: id,
        tipo: $("input[name='tipo']:checked").val(),
        codigo: $("#txtCodigo").val(),
        descricao: $("#txtDescricao").val(),
        cepEndereco: {
            id: $("#comboCEPEndereco").val()
        },
        logradouroEndereco: $("#txtLogradouroEndereco").val(),
        numeroEndereco: $("#txtNumeroEndereco").val(),
        bairroEndereco: $("#txtBairroEndereco").val()
    };

    var data = {
        json: JSON.stringify(unidadeAtendimento)
    };

    $.ajax({
        method: 'POST',
        url: '/controleAmbiente/unidadeAtendimento/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/controleAmbiente/unidadeAtendimento');
                    };
                    Msg.notify(data.msg, 'success', 2000, null, voltarListagem);
                } else {
                    Msg.notify(data.msg, 'warning');
                }
            }
        },
        failure: function () {
            Msg.notify('Erro inesperado. Contate o adminstrador do Sistema', 'warning');
        }
    });

    return false;

});
