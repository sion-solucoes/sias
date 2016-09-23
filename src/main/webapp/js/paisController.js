$('#paisForm').submit(function (event) {

    var id = $("#txtId").val();
    if (id == "") {
        id = null;
    }

    var pais = {
        id: id,
        sigla: $("#txtSigla").val(),
        descricao: $("#txtDescricao").val(),
        codigoBACEN: $("#txtCodigoBACEN").val()
    };

    var data = {
        json: JSON.stringify(pais)
    };

    $.ajax({
        method: 'POST',
        url: '/sias/cadastrosBasicos/pais/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/sias/cadastrosBasicos/pais');
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










