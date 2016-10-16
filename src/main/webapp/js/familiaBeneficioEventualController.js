$("#familiaBeneficioEventualForm").submit(function (e){
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
    
    $.ajax({
        method: "POST",
        url: "/controleFamiliar/requisicaoBeneficio/save",
        data: data,
        success: function (resp) {
            if (resp !== null) {
                var success = resp.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/controleFamiliar/requisicaoBeneficio');
                    };
                    Msg.notify(resp.msg, 'success', 2000, null, voltarListagem);
                } else {
                    Msg.notify(resp.msg, 'warning');
                }
            }
        },
        failure: function (resp) {
            Msg.notify('Erro inesperado. Contate o adminstrador do Sistema', 'warning');
        }
    });
    
    return false;
});


