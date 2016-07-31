$(document).ready(function () {
    $('#comboBusca').select2(Select2FamiliaConfig);
    $('#comboBusca').on('change', function (val, choice) {
        var comboBusca = $("#comboBusca");
        var familia = comboBusca.val();
        document.location.assign('/sias/controleFamiliar/familia/' + familia + '/editar');
    });
});
