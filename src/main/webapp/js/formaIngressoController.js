$('#formaIngressoForm').submit(function (event) {

    var formaIngresso = {
        descricao: $("#txtDescricao").val()
    };

    var data = {
        json: JSON.stringify(formaIngresso)
    };

    $.ajax({
        method: 'POST',
        url: '../formaIngresso/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('../formaIngresso');
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










