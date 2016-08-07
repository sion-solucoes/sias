$('#condicaoOcupacaoForm').submit(function (event) {

    var condicaoOcupacao = {
        descricao: $("#txtDescricao").val(),
        codigo: $("#txtCodigo").val()
    };

    var data = {
        json: JSON.stringify(condicaoOcupacao)
    };

    $.ajax({
        method: 'POST',
        url: '../condicaoOcupacao/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../condicaoOcupacao');
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


















