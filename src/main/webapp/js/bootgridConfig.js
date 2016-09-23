bootgridConfig = {
    caseSensitive: false,
    labels: {
        search: 'Procurar...',
        loading: 'Carregando...',
        noResults: 'Nenhum registro encontrado',
        refresh: 'Atualizar',
        infos: 'Mostrando {{ctx.start}} a {{ctx.end}} de {{ctx.total}}'
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

            var pathSplitted = document.URL.split('/');
            var pathEdit = '../' + pathSplitted[pathSplitted.length - 2] + '/' + pathSplitted[pathSplitted.length - 1] + '/' + row.id + '/' + 'editar';
            var pathDel = '../' + pathSplitted[pathSplitted.length - 2] + '/' + pathSplitted[pathSplitted.length - 1] + '/' + row.id + '/' + 'excluir';

            var edit = "<a href=\"" + pathEdit + "\" type=\"button\" class=\"btn btn-icon command-edit waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-edit\"></span></a> ";

            var del = "<a href=\"" + pathDel + "\" type=\"button\" class=\"btn btn-icon command-delete waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-delete\"></span></a>";

            return edit + del;
        }
    }
};