Msg = {
    notify: function (title, type, timer, image, fn) {
        if (fn == null) {
            swal({
                title: title,
                type: type,
                timer: timer > 0 ? timer : null,
                showConfirmButton: timer > 0 ? false : true,
                closeOnConfirm: true
            });
        } else {
            swal({
                title: title,
                type: type,
                timer: timer > 0 ? timer : null,
                showConfirmButton: timer > 0 ? false : true,
                closeOnConfirm: true
            }, function () {
                if (timer > 0) {
                    setTimeout(function () {
                        fn();
                        swal.close();
                    }, timer);
                } else {
                    fn();
                }
            });
        }
    },
    yesno: function (title, type, fn) {
        swal({
            title: title,
            type: type,
            showConfirmButton: true,
            showCancelButton: true,
            confirmButtonText: 'Sim',
            cancelButtonText: 'Não',
            closeOnConfirm: true
        }, fn);

    },
    bar: function (title, fn) {
        swal({
            title: title,
            showConfirmButton: false,
            text: '<div class="preloader pl-xl"><svg class="pl-circular" viewBox="25 25 50 50"><circle class="plc-path" cx="50" cy="50" r="20"/></svg></div>',
            html: true
        }, fn);
    }
};