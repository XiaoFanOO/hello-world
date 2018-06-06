


$(function(){
	
	var selectState = $('select.select-state').empty().append("<option value=-1>请选择状态</option>");
	$.post('./mgr/asset/findSelectState', function(data){
		 $.each(data.body, function(index, value){
			 $("<option value="+value.id+"></option>").append(value.name).appendTo(selectState);
		 });
	 });
	
	var selectType = $('select.select-type').empty().append("<option value=-1>请选择类型</option>");
	$.post('./mgr/maintain/findSelectType', function(data){
		 $.each(data.body, function(index, value){
			 $("<option value="+value.id+"></option>").append(value.name).appendTo(selectType);
		 });
	 });
	
	$('button.btn-create').on('click', ass.init());
	
	$('#modal-button1').on('click', function(e){
		type.showAddBox();
	});
});

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
		init : function(){
			$('.btn-create').on('click', function(data){
				window.open('assetInfo.html');
			});
			$('ul.search-type-ul').find('li').on('click', function(){
				$('.search-type-name').text($(this).find('a').text());
			});
		}
};