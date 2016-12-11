$(document).ready(function () {
    if ($('.date-picker')[0]) {
        $('.date-picker').datetimepicker({
            format: 'DD/MM/YYYY'
        });
    }
    if ($('.month-picker')[0]) {
        $('.month-picker').datetimepicker({
            format: 'MMMM, YYYY'
        });
    }
    if ($('.date-time-picker')[0]) {
        $('.date-time-picker').datetimepicker();
    }
    if ($('.selectpicker')[0]) {
        $('.selectpicker').selectpicker({
            size: 4
        });
    }
    if ($('.table-bootgrid')[0]) {
        $('.table-bootgrid').bootgrid(bootgridConfig);
    }
});