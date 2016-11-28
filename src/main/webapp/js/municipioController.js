$('#municipioForm').submit(function (event) {

    var id = $("#txtId").val();
    if (id == "") {
        id = null;
    }

    var municipio = {
        id: id,
        descricao: $("#txtDescricao").val(),
        codigoIBGE: $("#txtCodigoIBGE").val(),
        unidadeFederacao: {
            id: $("#comboUnidadeFederacao").val()
        }
    };

    var data = {
        json: JSON.stringify(municipio)
    };

    Msg.bar('Salvando. Por favor, aguarde...', null);

    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/municipio/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/cadastrosBasicos/municipio');
                    };
                    Msg.notify(data.msg, 'success', 1000, null, voltarListagem);
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




