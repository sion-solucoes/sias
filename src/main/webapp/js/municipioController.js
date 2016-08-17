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
                    var voltarListagem = function () {
                        document.location.assign('../municipio');
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




