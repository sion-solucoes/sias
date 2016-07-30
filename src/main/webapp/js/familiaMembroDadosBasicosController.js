$('#comboGrauParentesco').ready(function (event) {

    var txtGrauParentesco = $('#txtGrauParentesco');
    var grauParentescoId = txtGrauParentesco.val();
    var comboGrauParentesco = $('#comboGrauParentesco');

    $.ajax({
        method: 'POST',
        url: '/sias/controleFamiliar/grauParentesco/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var grauParentesco = data[i];
                    var option = document.createElement("option");
                    option.selected = grauParentescoId == grauParentesco.id;
                    option.value = grauParentesco.id;
                    option.text = grauParentesco.codigo + ' - ' + grauParentesco.descricao;
                    comboGrauParentesco.append(option);
                }
            }
        }
    });
});