/**
 * 登录相关JS
 */

$(function() {
	$('#myModal').modal({
		backdrop : false,
		show : true,
		keyboard : false
	});
	//点击刷新验证码
	$('img.login-verify-img').on('click', login.findVerifydCode);
	//重置按钮，刷新表单
	$('button.reset').on('click', login.reset);
	//登录按钮
	$('button.btn-login').on('click', login.login);

});


var login = {
		'login' : function(){
			$.verify = true;
			var uname = $.verifyFrom('input.username');
			var pword = $.verifyFrom('input.password');
			var verify = $.verifyFrom('input.login-verify');
			if($.verify == false) return;
			
			$.post('./mgr/0/login', {
				username : uname,
				password : pword,
				verify : verify
			}, function(data){
				if($.isSuccess(data)){
					window.location.href = './assetInfo.html';
					return ;
				}
				login.findVerifydCode();
			});
		},
		
		//刷新图形验证码
		'findVerifydCode' : function(){
			$('img.login-verify-img').attr('src', './mgr/0/findVerifycode?' + new Date().getTime());
		},
		
		//
		'reset' : function(){
			$('.username, .password, .login-verify').val('');
			login.findVerifydCode();
		}
		
}