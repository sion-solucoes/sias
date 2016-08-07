$('#beneficioEventualForm').submit(function (event) {

    var beneficioEventual = {
        codigo: $("#txtCodigo").val(),
        descricao: $("#txtDescricao").val()
    };

    var data = {
        json: JSON.stringify(beneficioEventual)
    };

    $.ajax({
        method: 'POST',
        url: '../beneficioEventual/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../beneficioEventual');
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










