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
        },
        "commands2": function (column, row) {
            var pathSplitted = document.URL.split("/");
            var pathDel = '../' + pathSplitted[pathSplitted.length - 2] + '/' + pathSplitted[pathSplitted.length - 1] + '/' + row.id + '/' + 'excluir';
            var del = "<a href=\"" + pathDel + "\" type=\"button\" class=\"btn btn-icon command-delete waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-delete\"></span></a>";
            return del;
        },
        "composicaoFamiliar": function (column, row) {
            var me = this;
            var edit = "<button type=\"button\" onclick=\"editarMembro(" + (me.current - 1) + ")\" class=\"btn btn-icon command-edit waves-effect waves-circle\"><span class=\"zmdi zmdi-edit\"></span></button> ";
            var del = "<button type=\"button\" onclick=\"removerMembro(" + (me.current - 1) + ")\" class=\"btn btn-icon command-delete waves-effect waves-circle\"><span class=\"zmdi zmdi-delete\"></span></button>";
            return edit + del;
        },
        "date": function (column, row) {
            return moment.utc(row[column.id]).format("DD/MM/YYYY");
        },
        "grauParentesco": function (column, row) {
            return row.grauParentesco.codigo + ' - ' + row.grauParentesco.descricao;
        }
    }
};