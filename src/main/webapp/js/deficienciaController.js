$('#deficienciaForm').submit(function (event) {

    var deficiencia = {
        descricao: $("#txtDescricao").val(),
        codigo: $("#txtCodigo").val()
    };

    var data = {
        json: JSON.stringify(deficiencia)
    };

    $.ajax({
        method: 'POST',
        url: '../deficiencia/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../deficiencia');
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





















