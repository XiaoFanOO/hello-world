var Dialog = {
	msg : function(text) {
		new BootstrapDialog({
			title : '标题',
			message : text,
		}).open();
	},
	confirm : function(text, callback) {
		new BootstrapDialog({
			title : '标题',
			message : text,
			type : BootstrapDialog.TYPE_PRIMARY,
			buttons : [
				{
					label : '取消',
					action : function(dialog) {
						dialog.close();
					}
				}, {
					label : '确定',
					action : function(dialog) {
						callback();
						dialog.close();
					}
				}
			]
		}).open();
	},
	showModal : function(id){
		$(id).modal({
			backdrop: 'static',
			keyboard: false,
		}).modal(show);
	},
	
	
};

(function($){
	//监测后台返回的数据是否成功
	$.isSuccess = function(data){
		if(data.head == true){
			return true;
		}
		Dialog.msg(data.body);
		return false;
	};
	$.verify = true;
	$.verifyFrom = function(className, isNull){
		var val = $(className).removeClass('border-red').val();
		if(val == null || val == '' || val.length <= 0 ){
			$.verify = false;
			$(className).addClass('border-red');
			
		}
		return val;
	};
	$.verifySelect = function(className, isNull){
		var val = $(className).removeClass('border-red').val();
		if(val == null || val == -1 ){
			$.verify = false;
			$(className).addClass('border-red');
			
		}
		return val;
	};

	$.echoSelect = function(data, id, selected){
		var select = $(id).empty().append("<option value = -1>请选择...</option>");
		$.each(data, function(i, v){
			if(v.id == selected){
				$("<option value="+v.id+" selected=true></option>").append(v.name).appendTo(select);
			}else{
				$("<option value="+v.id+"></option>").append(v.name).appendTo(select);
			}
		});
	};
	
	
})(jQuery);

$(function(){
	$('input.date').on('click, focus', function(e){
		WdatePicker();
	});
	$('input.date-before').on('click, focus', function(e){
		WdatePicker({maxDate:'%y-%M-%d'});
	});
});

$(function(){
	$('.exit').on('click', function(){
		Dialog.confirm('请确认是否需要注销登录！', function() {
			//发送请求到后台注销登录，成功后跳转到登录界面;
			window.location = './login.html';
		});
	});
	
});