$('#escolaridadeForm').submit(function (event) {

    var escolaridade = {
        descricao: $("#txtDescricao").val(),
        codigo: $("#txtCodigo").val()
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
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../escolaridade');
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


















