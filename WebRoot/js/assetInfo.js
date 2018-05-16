//模块框监听事件
$(function(){
	//状态下拉菜单显示
	
	$.post('./mgr/asset/findSelectState', function(data){
		 $.echoSelect(data.body, 'select.select-state', -1);
	 });
	
	//类型下拉菜单显示
	var selectType = $('select.select-type').empty().append("<option value=-1>请选择...</option>");
	$.post('./mgr/maintain/findSelectType', function(data){
		 $.each(data.body, function(index, value){
			 $("<option value="+value.id+"></option>").append(value.name).appendTo(selectType);
		 });
	 });
	
	$('#modal-button1').on('click', function(e){
		type.showAddBox();
	});
	
	$('#modal-button2').on('click', function(e){
		sta.showAddBox();
	});
	
	$('button.btn-add-type').on('click',function(){
		$('tbody.tbody-type-list').append($('tbody.tbody-type-list tr:last').prop('outerHTML'));
	});
	$('button.btn-add-state').on('click',function(){
		$('tbody.tbody-state-list').append($('tbody.tbody-state-list tr:last').prop('outerHTML'));
	});
	
	$('button.btn-allsave').on('click',function(){
		var data = getassetInfo(); //获取并验证页面中所有的表单信息
	});
	//保存新增状态
	$('button.state-save').on('click', function(e){
		sta.save();
	});
	//保存新增类型
	$('button.type-save').on('click', function(e){
		type.save();
	});
	
	
});
//验证页面中所有表单，并将最终的数据封装为一个Json对象返回
function getassetInfo (){
	$('.color-red').removeClass('color-red');
	var asset = {};
	asset.fullName = $.input('.fullname', false);
	asset.type = $.select('.type',false);
	asset.state = $.select('.state',false);
	asset.address = $.select('.address',false);
	asset.person = $.select('.person',false);
	asset.warranty = $.input('.warranty',false);
	
	asset.madetime = $.input('.madetime',true);
	asset.college = $.select('.college',true);
	asset.description = $.input('.description',true);
	return asset;
	
}
(function($){
	$.isSubmit = true; //如果为true，说明页面中的所有表单全部验证通过
	//获取并验证Input中的数据，最后将数据返回
	$.input = function(className, isNull){
		//1.获取制定元素的值
		var val = $(className).val();
		//2.验证这个值是否合法
		    //合法-返回值
		    //不合法-对应label标签为红色，返回null
		if(isNull) return val; //验证是否允许为空
		if(val != null && val != '') return val;  //验证通过，返回数据
		$(className + '-label').addClass('color-red');
		$.isSubmit = false;
		return '';//验证不通过，返回空串
	}
	
	//
	$.select = function(className, isNull){
		var val = $(className).val();
		if(isNull) return val; //验证是否允许为空
		if(val != null && val != -1) return val;  //验证通过，返回数据
		$(className + '-label').addClass('color-red');
		$.isSubmit = false;
		return '';//验证不通过，返回空串
	}
	
})(jQuery);

 function removeType(_this){
	 if($('tr.tr-type').length <= 1) return;
	 $(_this).parent().parent().remove();
 }
 function removeState(_this){
	 if($('tr.tr-state').length <= 1) return;
	 $(_this).parent().parent().remove();
 }

 var sta = {
		 showAddBox : function(){
			 
			 $('input.addState-name').val('');
			 $('input.addState-desc').val('');
			 Dialog.showModal("#myModal2")
		 },
		 save : function(){
			 
			 $.verify = true;
			 
			 var name = $.verifyFrom('input.addState-name');
			 var desc = $('input.addState-desc').val();
			 if(!$.verify) return;
			 $.post('./mgr/maintain/add', {name:name, description:desc}, function(data){
				 if(!$.isSuccess(data)) return;
				 Dialog.msg(data.body);
			 });
			 $('input.addState-name').val('');
			 $('input.addState-desc').val('');
		 }
 };
 var type = {
		 showAddBox : function(){
			 
			 $('input.addType-name').val('');
			 $('input.addType-desc').val('');
			 Dialog.showModal("#myModal1")
		 },
		 save : function(){
			 
			 $.verify = true;
			 
			 var name = $.verifyFrom('input.addType-name');
			 var desc = $('input.addType-desc').val();
			 if(!$.verify) return;
			 $.post('./mgr/type/addType', {name:name, description:desc}, function(data){
				 if(!$.isSuccess(data)) return;
				 Dialog.msg(data.body);
			 });
			 $('input.addType-name').val('');
			 $('input.addType-desc').val('');
		 }
 };
 
 var ass = {
		 save : function(){
			 
			 $.verify = true;
			 
			 var name = $.verifyFrom('input.addType-name');
			 var desc = $('input.addType-desc').val();
			 if(!$.verify) return;
			 $.post('./mgr/type/addType', {name:name, description:desc}, function(data){
				 if(!$.isSuccess(data)) return;
				 Dialog.msg(data.body);
			 });
			 $('input.addType-name').val('');
			 $('input.addType-desc').val('');
		 }
 };