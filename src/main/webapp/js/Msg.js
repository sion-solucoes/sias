Msg = {
    notify: function (message, type) {

        setTimeout(function () {

            $.growl({
                message: message
            }, {
                type: type,
                allow_dismiss: false,
                label: 'Cancel',
                className: 'btn-xs btn-inverse',
                placement: {
                    from: 'top',
                    align: 'center'
                },
                delay: 2500,
                animate: {
                    enter: 'animated fadeInUp',
                    exit: 'animated fadeOutDown'
                },
                offset: {
                    x: 30,
                    y: 80
                }
            });
        }, 1000);
    }
};