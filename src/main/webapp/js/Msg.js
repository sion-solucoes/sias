Msg = {
    notify: function (title, type, timer, image, fn) {

        swal({
            title: title,
            type: type,
            timer: timer > 0 ? timer : null,
            showConfirmButton: timer > 0 ? false : true
        }, fn);
    }
};