$(document).ready(function () {
    if ($('.date-picker')[0]) {
        $('.date-picker').datetimepicker({
            format: 'DD/MM/YYYY'
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
    if ($('.table')[0]) {
        $('.table').bootgrid(bootgridConfig);
    }
});