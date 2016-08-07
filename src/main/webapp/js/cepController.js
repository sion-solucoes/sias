$('#cepForm').submit(function (event) {

    var cep = {
        codigo: $("#txtCodigo").val(),
        logradouro: $("#txtLogradouro").val(),
        bairro: $("#txtBairro").val(),
        municipio: {
            id: $("#comboMunicipio").val()
        }
    };

    var data = {
        json: JSON.stringify(cep)
    };

    $.ajax({
        method: 'POST',
        url: '../cep/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../cep');
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







