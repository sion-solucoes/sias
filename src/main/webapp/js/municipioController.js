$('#municipioForm').submit(function (event) {

    var municipio = {
        descricao: $("#txtDescricao").val(),
        codigoIBGE: $("#txtCodigoIBGE").val(),
        unidadeFederacao: {
            id: $("#comboUnidadeFederacao").val()
        }
    };

    var data = {
        json: JSON.stringify(municipio)
    };

    $.ajax({
        method: 'POST',
        url: '../municipio/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../municipio');
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




