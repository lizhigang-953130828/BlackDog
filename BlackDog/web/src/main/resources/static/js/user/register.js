$(function() {
    $("*").slow(1000);

    $('#tel,#veriCode,#password,#password2 ').keyup(function(event) {
        checkBtn();
    });

    // 按钮是否可点击
    function checkBtn() {
        var tel = $.trim($('#tel').val());
        var veriCode = $.trim($('#veriCode').val());
        var password = $.trim($('#password').val());
        var password2 = $.trim($('#password2').val());
        if (tel != '' && veriCode != '' && password != '' && password2 != '') {
            $(".log-btn").addClass("on");
        } else {
            $(".log-btn").addClass("off");
        }
    }
})