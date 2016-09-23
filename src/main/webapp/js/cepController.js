$('#cepForm').submit(function (event) {

    var id = $("#txtId").val();
    if (id == "") {
        id = null;
    }

    var cep = {
        id: id,
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
        url: '/sias/cadastrosBasicos/cep/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/sias/cadastrosBasicos/cep');
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







