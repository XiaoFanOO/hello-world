


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
});

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