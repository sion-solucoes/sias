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
                $("#resultados_pesquisa").children().remove();
                var table = '<div class="m-15 table-responsive">'
                        + '<table class="table table-condensed table-striped table-vmiddle">'
                        + '<thead>'
                        + '<tr>'
                        + '<th>Pessoa referência</th>'
                        + '<th>NIS</th>'
                        + '</tr>'
                        + '</thead>'
                        + '<tbody>'
                        + '</tbody>';
                
                        $.each(resp, function (i, item){
                            var tdNome = '<td><a href="/controleFamiliar/familia/'+item.id+'/editar">'+item.nome+'</a></td>';
                            var tdNis = '<td><a href="/controleFamiliar/familia/'+item.id+'/editar">'+item.nis+'</a></td>';
                            table += '<tr>'+tdNome+tdNis+'</tr>';
                        });
                
                        table += '</table>'
                        + '</div>'
                        + '<div class="m-15 text-center">'
                        + '<a href="" data-ma-action="search-open" data-dismiss="modal" data-target="#resultadosPesquisa">'
                        + 'Fazer nova pesquisa</a>'
                        + '</div>';
                
                $("#resultados_pesquisa").append(table);
            }else{
                $("#resultados_pesquisa").children().remove();
                var text = '<div class="m-15 text-center">'
                    + '<h4>Nenhum resultado encontrado para essa pesquisa!</h4>'
                    + '</div>'
                    + '<div class="m-15 text-center">'
                    + '<a href="" data-ma-action="search-open" data-dismiss="modal" data-target="#resultadosPesquisa">'
                    + 'Fazer nova pesquisa</a>'
                    + '</div>';
            
                $("#resultados_pesquisa").append(text);
            }
        }
    });
    
    $("#resultadoPesquisa").modal("show");
});
