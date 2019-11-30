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
		//点击保存
		$('.layout-right-l1-down2').click(function(){
			//拿到上传的照片编码后的字符串
			var content = $('#content').val();
			//拿到昵称
			var nicheng = $('#nicheng').val();
			//拿到名字
			var xingming = $('#xingming').val();
			//拿到性别
			var xingbie = $('.sexs').val();
			//拿到生日
			var nian=$('.year').val();
			var yue=$('.month').val();
			var ri=$('.day').val();
			$.ajax({
				type:"post",
				url:"center.do",
				data:"content="+content+"&nicheng="+nicheng+"&xingming="+xingming+"&xingbie="+xingbie+"&nian="+nian+"&yue="+yue+"&ri="+ri,
				success:function(result){
					//alert("修改成功");
					$('#sheng').html(result);
					$('#img1').attr('src',content);
					$('#mingzi').html(xingming);
					$('#sssssix').html(xingbie);
					$('#ni').html(nicheng);
					$('.layout-right-l1-all2').hide();
					$('.layout-right-l1-all').show();
				}
			
			});
			
		});
		
		//原密码框获焦
		$('#section-big-layout-right li:eq(1) .layout-right-l2-middle1>input').focus(function(){
			$('#section-big-layout-right li:eq(1) .layout-right-l2-middle1>input').css('border','1px solid blue');
		});
		//新密码框获焦
		$('#section-big-layout-right li:eq(1) .layout-right-l2-middle2>input').focus(function(){
			$('#section-big-layout-right li:eq(1) .layout-right-l2-middle2>input').css('border','1px solid blue');
		});
		//点击修改密码
		$('#section-big-layout-right li:eq(1)>.layout-right-l2-down2').click(function(){
			//拿到文本框输入的值
			var n = $('#section-big-layout-right li:eq(1) .layout-right-l2-middle1>input').val();
			var m = $('#section-big-layout-right li:eq(1) .layout-right-l2-middle2>input').val();
			//长度为8～14个字符支持数字，大小写字母和标点符号,不能有空格
		 	var re1 = /^([a-z-A-Z\d]|[,.!@]){8,14}$/g;
		 	if (!re1.test(m)) {
		 		$('#section-big-layout-right li:eq(1) .layout-right-l2-middle2>input').css('border','1px solid red');
	  			return;
	 		}else{
	 			$.ajax({
					type:"post",
					url:"pass.do",
					data:"n="+n+"&m="+m,
					success:function(result){
						if(result){
					 		$('#section-big-layout-right li:eq(1) .layout-right-l2-middle1>input').css('border','1px solid red');
						}else{
							alert("密码修改成功，请重新登陆");
							window.location.href = 'http://localhost:8080/ShoesMall/home.jsp';
						}
					}
				});
	 		};
		});
		
		
