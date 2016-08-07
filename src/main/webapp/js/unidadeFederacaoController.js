$('#unidadeFederativaForm').submit(function (event) {

    var unidadeFederacao = {
        sigla: $("#txtSigla").val(),
        descricao: $("#txtDescricao").val(),
        codigoIBGE: $("#txtCodigoIBGE").val(),
        pais: {
            id: $("#comboPais").val()
        }
    };

    var data = {
        json: JSON.stringify(unidadeFederacao)
    };

    $.ajax({
        method: 'POST',
        url: '../unidadeFederacao/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../unidadeFederacao');
                    }, 1500);
                } else {
                    Msg.notify(data.msg, 'danger');
                }
            }
        },
        failure: function (data) {
            Msg.notify('Erro inesperado. Contate o adminstrador do Sistema');
        }
    });

    return false;
});

