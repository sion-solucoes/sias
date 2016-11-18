$('#checkNecessitaCuidadosConstantes').change(function () {

    var checkNecessitaCuidadosConstantes = $('#checkNecessitaCuidadosConstantes');
    var txtDescricaoNecessidadeCuidadosConstantes = $('#txtDescricaoNecessidadeCuidadosConstantes');

    if (checkNecessitaCuidadosConstantes.prop('checked')) {
        txtDescricaoNecessidadeCuidadosConstantes.prop('disabled', false);
    } else {
        txtDescricaoNecessidadeCuidadosConstantes.val('');
        txtDescricaoNecessidadeCuidadosConstantes.prop('disabled', true);
    }

});

$('#checkGestante').change(function () {

    var checkGestante = $('#checkGestante');
    var txtMesesGestacao = $('#txtMesesGestacao');
    var checkIniciouPreNatal = $('#checkIniciouPreNatal');

    if (checkGestante.prop('checked')) {
        txtMesesGestacao.prop('disabled', false);
        checkIniciouPreNatal.prop('disabled', false);
    } else {
        txtMesesGestacao.prop('disabled', true);
        checkIniciouPreNatal.prop('disabled', true);
    }

});
