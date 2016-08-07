$('#grauParentescoForm').submit(function (event) {

    var grauParentesco = {
        descricao: $("#txtDescricao").val(),
        codigo: $("#txtCodigo").val()
    };

    var data = {
        json: JSON.stringify(grauParentesco)
    };

    $.ajax({
        method: 'POST',
        url: '../grauParentesco/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../grauParentesco');
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













