$(function(){

    $('#num').keyup(function(event) {
        //alert("1")
        $('.tel-warn').addClass('hide');
        checkBtn();
    });

    $('#pass').keyup(function(event) {
        //alert("2")
        $('.tel-warn').addClass('hide');
        checkBtn();
    });
    $('#pass2').keyup(function(event) {
        //alert("3")
        $('.tel-warn').addClass('hide');
        checkBtn();
    });

    $('#veriCode').keyup(function(event) {
        //alert("4")
        $('.tel-warn').addClass('hide');
        checkBtn();
    });


    // 按钮是否可点击
    function checkBtn() {
            var inp = $.trim($('#num').val());
            var pass = $.trim($('#pass').val());
            var pass2 = $.trim($('#pass2').val());
            var veriCode = $.trim($('#veriCode').val());
            //alert(inp+"-"+pass+"-"+pass2+"-"+veriCode);
            if (inp != '' && pass != '' && pass2 != '' && veriCode != '') {
                $(".reg-btn").removeClass("off");
            } else {
                $(".reg-btn").addClass("off");
            }
    }

    function checkpass(pass,pass2){
        if (pass==pass2) {
            if (pass.length>5 && pass.length<17) {
                return true
            }
            $('.pwd-err').removeClass('hide').find("em").text('密码位数不合法，应在6至16位数之间');
            return false;
        } else {
            $('.pwd-err').removeClass('hide').find("em").text('两次密码输入不一致');
            return false;
        }
    }

    function checkVeriCode(veriCode){
        if (veriCode!='' && veriCode.length==6) {
            return true;
        } else {
            $('.error').removeClass('hide').find("em").text('验证码不合法');
            return false;
        }
    }

    // 登录的回车事件
    $(window).keydown(function(event) {
        if (event.keyCode == 13) {
            $('.reg-btn').trigger('click');
        }
    });

        // 注册点击事件
        $(".reg-btn").click(function () {
            alert($(".icon-ok-sign").hasClass("boxcol"))
            if($(this).hasClass('off')) {
                return;
            }
            var tel = $.trim($('#num').val());
            var pass = $.trim($('#pass').val());
            var pass2 = $.trim($('#pass2').val());
            var veriCode = $.trim($('#veriCode').val());
            if (checkPhone(tel) && checkVeriCode(veriCode) && checkpass(pass, pass2) ) {
                if (!($(".icon-ok-sign").hasClass("boxcol"))){
                    $('.agree-err').removeClass('hide').find("em").text('请同意BlackDog协议');
                    return;
                }
                $('.agree-err').addClass('hide');
                $.ajax({
                    url: '/user/register.do',
                    type: 'post',
                    dataType: 'json',
                    async: true,
                    data: {tel: tel, password: pass, password2: pass2, veriCode: veriCode},
                    success: function (data) {
                        if (data.code == 200) {
                            alert("注册成功");
                        } else if (data.code == 4001) {
                            $('.error').removeClass('hide').find("em").text('验证码错误');
                        } else if (data.code == 4002) {
                            $('.pwd-err').removeClass('hide').find("em").text('两次密码输入不一致');
                        } else {
                            alert("BlackDog系统发生异常，请稍后再试！");
                        }
                        changeVerify();
                    },
                    error: function () {
                        alert("BlackDog系统发生异常，请稍后再试！");
                    }
                });
            } else {
                return false;
            }
        });

        //发送验证码
        $(".form-data").delegate(".send","click",function () {
        var phone = $.trim($('#num').val());
        if (checkPhone(phone)) {
            $.ajax({
                url: '/user/sendSms.do',
                type: 'post',
                dataType: 'json',
                async: true,
                data: {tel:phone},
                success:function(data){
                    if (data.code == '0') {

                    } else {

                    }
                },
                error:function(){
                    alert("BlackDog系统发生异常，请稍后再试！");
                }
            });
            var oTime = $(".form-data .time"),
                oSend = $(".form-data .send"),
                num = parseInt(oTime.text()),
                oEm = $(".form-data .time em");
            $(this).hide();
            oTime.removeClass("hide");
            var timer = setInterval(function () {
                var num2 = num-=1;
                oEm.text(num2);
                if(num2==0){
                    clearInterval(timer);
                    oSend.text("重新发送验证码");
                    oSend.show();
                    oEm.text("120");
                    oTime.addClass("hide");
                }
            },1000);
        }
    });

    function checkPhone(phone){
        var status = true;
        if (phone == '') {
            $('.num2-err').removeClass('hide').find("em").text('请输入手机号');
            return false;
        }
        var param = /^1[34578]\d{9}$/;
        if (!param.test(phone)) {
            $('.num2-err').removeClass('hide');
            $('.num2-err').text('手机号不合法，请重新输入');
            return false;
        }
       return status;
    }
});