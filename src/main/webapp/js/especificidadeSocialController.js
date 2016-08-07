$('#especificidadeSocialForm').submit(function (event) {

    var especificidadeSocial = {
        descricao: $("#txtDescricao").val(),
        indigena: $("#checkIndigena").val(),
        povoEtnia: $("#txtPovoEtnia").val()
    };

    var data = {
        json: JSON.stringify(especificidadeSocial)
    };

    $.ajax({
        method: 'POST',
        url: '../especificidadeSocial/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    Msg.notify(data.msg, 'success');
                    setTimeout(function () {
                        document.location.assign('../especificidadeSocial');
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













