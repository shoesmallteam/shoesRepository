//动画初始化调用
  new WOW().init();
//遍历li,鼠标移入移出
$('header ul li').each(function(i){
	$(this).mouseenter(function(){
		$(this).css({
		background : 'white',
		color : 'black',
		}).children().css('color','black').parent().siblings().css('background','#c40e0e').children().css('color','white');
		$('#_subnav>div').eq(i).show(i).siblings().hide();
	});
});
$('.logo').mouseenter(function(){
	$('#_subnav>div').fadeOut(1000);
});
$('#logo_right').mouseenter(function(){
	$('#_subnav>div').fadeOut(1000);
});
$('.content_img').mouseenter(function(){
	$('#_subnav>div').fadeOut(1000);
});
