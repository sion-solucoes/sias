$('#btnIrParaComeco').on('mouseover', function (btn) {
    document.getElementById('img').src = 'http://localhost:8084/sias/img/icon-happy.png';
});
$('#btnIrParaComeco').on('mouseout', function (btn) {
    document.getElementById('img').src = 'http://localhost:8084/sias/img/icon-sad.png';
});