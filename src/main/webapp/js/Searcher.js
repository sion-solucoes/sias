$(document).ready(function () {
    $('#comboBusca').select2(Select2FamiliaConfig);
    $('#comboBusca').on('change', function (val, choice) {
        var comboBusca = $("#comboBusca");
        var familia = comboBusca.val();
        document.location.assign('/sias/controleFamiliar/familia/' + familia + '/editar');
    });
});

$("#busca").click(function (e){
    
    e.preventDefault();
    
    var valor = $("#buscaValor").val();
    
    $.ajax({
        method: "POST",
        url: "/controleFamiliar/familiaMembro/readByCriteria",
        data: {json: valor},
        success: function (resp){
            if(resp !== null && resp.length > 0){
                console.log(resp);
                //$("#tabela-resultados table").show();
                $("#resultados").children("tr").remove();
                $.each(resp, function (i, item){
                    var tdNome = '<td><a href="/controleFamiliar/familia/'+item.id+'/editar">'+item.nome+'</a></td>';
                    var tdNis = '<td><a href="/controleFamiliar/familia/'+item.id+'/editar">'+item.nis+'</a></td>';
                    $("#resultados").append('<tr>'+tdNome+tdNis+'</tr>');
                });
            }else{
                //$("#tabela-resultados table").hide();
               // $("#tabela-resultados").children().remove();
                $("resultados").append("<tr><td><h4 class='text-center'>Nenhum resultado encontrado para essa pesquisa.</h4></td></tr>");
            }
        }
    });
    
    $("#resultadoPesquisa").modal("show");
});
