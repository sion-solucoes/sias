$("#familiaBeneficioEventualForm").submit(function (e) {
    e.preventDefault();

    var familiaBeneficioEventual = {
        familia: {
            id: $("#comboFamilia").val()
        },
        beneficioEventual: {
            id: $("#comboBeneficioEventual").val()
        },
        dataSolicitacao: $("#txtDataSolicitacao").val() === "" ? null : $("#txtDataSolicitacao").val(),
        dataConcessao: $("#txtDataConcessao").val() === "" ? null : $("#txtDataConcessao").val()
    };

    var data = {
        json: JSON.stringify(familiaBeneficioEventual)
    };

    Msg.bar('Salvando. Por favor, aguarde...', null);

    $.ajax({
        method: "POST",
        url: "/controleFamiliar/requisicaoBeneficio/save",
        data: data,
        success: function (data) {
            if (data !== null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/controleFamiliar/requisicaoBeneficio');
                    };
                    Msg.notify(data.msg, 'success', 1000, null, voltarListagem);
                } else {
                    Msg.notify(data.msg, 'warning');
                }
            }
        },
        failure: function (resp) {
            Msg.notify('Erro inesperado. Contate o adminstrador do Sistema', 'warning');
        }
    });

    return false;
});


