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
