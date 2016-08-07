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
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../formaIngresso');
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










