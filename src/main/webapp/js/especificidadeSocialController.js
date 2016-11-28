$('#especificidadeSocialForm').submit(function (event) {

    var id = $("#txtId").val();
    if (id == "") {
        id = null;
    }

    var especificidadeSocial = {
        id: id,
        descricao: $("#txtDescricao").val(),
        indigena: $("#checkIndigena").prop('checked'),
        povoEtnia: $("#txtPovoEtnia").val()
    };

    var data = {
        json: JSON.stringify(especificidadeSocial)
    };

    Msg.bar('Salvando. Por favor, aguarde...', null);

    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/especificidadeSocial/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/cadastrosBasicos/especificidadeSocial');
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













