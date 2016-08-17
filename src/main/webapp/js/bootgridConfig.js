bootgridConfig = {
    labels: {
        search: 'Procurar...',
        loading : 'Carregando...',
        noResults : 'Nenhum registro encontrado',
        refresh : 'Atualizar',
        infos : 'Mostrando {{ctx.start}} a {{ctx.end}} de {{ctx.total}}'
    },
    css: {
        icon: 'zmdi icon',
        iconColumns: 'zmdi-view-module',
        iconDown: 'zmdi-sort-amount-desc',
        iconRefresh: 'zmdi-refresh',
        iconUp: 'zmdi-sort-amount-asc'
    },
    formatters: {
        "commands": function (column, row) {
            return "<a type=\"button\" class=\"btn btn-icon command-edit waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-edit\"></span></a> " +
                    "<a type=\"button\" class=\"btn btn-icon command-delete waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-delete\"></span></a>";
        }
    }
};