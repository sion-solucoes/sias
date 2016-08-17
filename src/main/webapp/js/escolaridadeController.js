$('#escolaridadeForm').submit(function (event) {

    var escolaridade = {
        codigo: $("#txtCodigo").val(),
        descricao: $("#txtDescricao").val()
    };

    var data = {
        json: JSON.stringify(escolaridade)
    };

    $.ajax({
        method: 'POST',
        url: '../escolaridade/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('../escolaridade');
                    };
                    Msg.notify(data.msg, 'success', 2000, null, voltarListagem);
                } else {
                    Msg.notify(data.msg, 'warning');
                }
            }
        },
        failure: function (data) {
            Msg.notify('Erro inesperado. Contate o adminstrador do Sistema', 'warning');
        }
    });

    return false;
});


















