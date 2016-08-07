$('#paisForm').submit(function (event) {

    var pais = {
        sigla: $("#txtSigla").val(),
        descricao: $("#txtDescricao").val(),
        codigoBACEN: $("#txtCodigoBACEN").val()
    };

    var data = {
        json: JSON.stringify(pais)
    };

    $.ajax({
        method: 'POST',
        url: '../pais/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../pais');
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










