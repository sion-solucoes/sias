Select2FamiliaConfig = {
    placeholder: "Pesquise famílias por seus membros aqui...",
    ajax: {
        type: 'POST',
        url: '/sias/controleFamiliar/familiaMembro/readByCriteria',
        quietMillis: 250,
        data: function (params) {
            var json = {
                nome: params.term
            };
            return json;
        },
        results: function (data) {
            var results = {
                results: data
            };
            return results;
        }
    },
    formatResult: function (data) {
        return data.nome;
    },
    formatSelection: function (data) {
        return '<option value=\'' + data.id + '\'>' + data.nome + '</option>';
    },
    change: function (val, added, removed) {
        var teste = 0;
    }
}