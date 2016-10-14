$('#comboCondicaoOcupacao').ready(function (event) {

    var txtCondicaoOcupacao = $('#txtCondicaoOcupacao');
    var condicaoOcupacaoId = txtCondicaoOcupacao.val();
    var comboCondicaoOcupacao = $('#comboCondicaoOcupacao');
    comboCondicaoOcupacao.selectpicker({
        size: 4
    });

    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/condicaoOcupacao/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var condicaoOcupacao = data[i];
                    var option = document.createElement("option");
                    option.selected = condicaoOcupacaoId === condicaoOcupacao.id;
                    option.value = condicaoOcupacao.id;
                    option.text = condicaoOcupacao.codigo + ' - ' + condicaoOcupacao.descricao;
                    comboCondicaoOcupacao.append(option);
                }
                comboCondicaoOcupacao.selectpicker('refresh');
            }
        }
    });
});

$('#checkPossuiQualificacaoProfissional').change(function () {

    var checkPossuiQualificacaoProfissional = $('#checkPossuiQualificacaoProfissional');
    var txtDescricaoQualificacaoProfissional = $('#txtDescricaoQualificacaoProfissional');

    if (checkPossuiQualificacaoProfissional.prop('checked')) {
        txtDescricaoQualificacaoProfissional.prop('disabled', false);
    } else {
        txtDescricaoQualificacaoProfissional.val('');
        txtDescricaoQualificacaoProfissional.prop('disabled', true);
    }

});
