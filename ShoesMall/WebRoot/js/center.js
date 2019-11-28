//默认选中第一个且显示
$('#section-big-layout-left li:first>a').css({
      	fontSize : 18,
    	color : '#c40e0e',
      	});
$('#section-big-layout-right li:first').show().siblings().hide();
//遍历，点击
$('#section-big-layout-left li').each(function(i){
	$(this).click(function(){
		$('#section-big-layout-left li a').eq(i).css({
      	fontSize : 18,
    	color : '#c40e0e',
      	}).parent().siblings().children().css({
      	fontSize : 16,
    	color : 'black',
      	});
		$('#section-big-layout-right li').eq(i).show(i).siblings().hide();
	});
});
//点击编辑按钮
$('.layout-right-l1-down').click(function(){
	$('.layout-right-l1-all2').show();
	$('.layout-right-l1-all').hide();
});
$('.layout-right-l1-down3').click(function(){
	$('.layout-right-l1-all2').hide();
	$('.layout-right-l1-all').show();
});