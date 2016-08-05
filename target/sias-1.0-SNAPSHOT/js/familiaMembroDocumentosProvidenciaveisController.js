$('#tabelaDocumentosProvidenciaveis').ready(function (event) {

    var txtFamiliaMembroId = document.getElementById('txtId');
    var familiaMembroId = txtFamiliaMembroId.value;
    var tabelaDocumentosProvidenciaveis = document.getElementById("tabelaDocumentosProvidenciaveis");

    var data = {
        familiaMembroId: familiaMembroId
    };

    var body = document.createElement("tbody");

    $.ajax({
        method: 'POST',
        url: '/sias/controleFamiliar/documentoProvidenciavel/readAll',
        success: function (documentoProvidenciavelList) {
            if (familiaMembroId != null && familiaMembroId != "") {
                $.ajax({
                    method: 'POST',
                    data: data,
                    url: '/sias/controleFamiliar/familiaMembroDocumentoProvidenciavel/readDocumentoProvidenciavelByFamiliaMembro',
                    success: function (familiaMembroDocumentoProvidenciavelList) {
                        if (documentoProvidenciavelList !== null) {
                            for (var indexDocumentoProvidenciavel = 0; indexDocumentoProvidenciavel < documentoProvidenciavelList.length; indexDocumentoProvidenciavel++) {
                                var row = document.createElement("tr");
                                var cellCheck = document.createElement("td");
                                var documentoProvidenciavel = documentoProvidenciavelList[indexDocumentoProvidenciavel];
                                var input = document.createElement("input");
                                input.type = "checkbox";
                                input.value = documentoProvidenciavel.id;
                                if (familiaMembroDocumentoProvidenciavelList != null) {
                                    var check = false;
                                    for (var indexFamiliaMembroDocumentoProvidenciavel = 0; indexFamiliaMembroDocumentoProvidenciavel < familiaMembroDocumentoProvidenciavelList.length; indexFamiliaMembroDocumentoProvidenciavel++) {
                                        var familiaMembroDocumentoProvidenciavel = familiaMembroDocumentoProvidenciavelList[indexFamiliaMembroDocumentoProvidenciavel];
                                        if (documentoProvidenciavel.id == familiaMembroDocumentoProvidenciavel.id) {
                                            check = true;
                                        }
                                    }
                                    input.checked = check;
                                }
                                cellCheck.appendChild(input);
                                row.appendChild(cellCheck);
                                var cellCodigo = document.createElement("td");
                                var codigo = document.createTextNode(documentoProvidenciavel.codigo);
                                cellCodigo.appendChild(codigo);
                                row.appendChild(cellCodigo);
                                var cellDescricao = document.createElement("td");
                                var descricao = document.createTextNode(documentoProvidenciavel.descricao);
                                cellDescricao.appendChild(descricao);
                                row.appendChild(cellDescricao);
                                body.appendChild(row);
                            }
                            tabelaDocumentosProvidenciaveis.appendChild(body);
                        }
                    }
                });
            } else {
                if (documentoProvidenciavelList !== null) {
                    for (var indexDocumentoProvidenciavel = 0; indexDocumentoProvidenciavel < documentoProvidenciavelList.length; indexDocumentoProvidenciavel++) {
                        var row = document.createElement("tr");
                        var cellCheck = document.createElement("td");
                        var documentoProvidenciavel = documentoProvidenciavelList[indexDocumentoProvidenciavel];
                        var input = document.createElement("input");
                        input.type = "checkbox";
                        input.value = documentoProvidenciavel.id;
                        cellCheck.appendChild(input);
                        row.appendChild(cellCheck);
                        var cellCodigo = document.createElement("td");
                        var codigo = document.createTextNode(documentoProvidenciavel.codigo);
                        cellCodigo.appendChild(codigo);
                        row.appendChild(cellCodigo);
                        var cellDescricao = document.createElement("td");
                        var descricao = document.createTextNode(documentoProvidenciavel.descricao);
                        cellDescricao.appendChild(descricao);
                        row.appendChild(cellDescricao);
                        body.appendChild(row);
                    }
                    tabelaDocumentosProvidenciaveis.appendChild(body);
                }
            }
        }
    });
});