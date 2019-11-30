(function(){
	 	$.ajax({
	 		type:"post",
			url:"center2.do",
			success:function(result){
				//传图片
				//alert(result.photo);
				console.log(result);
				$('#img1').attr('src',result);
				//昵称
				var a = $('#nn').val();
			 	$('#ni').html(a);
			 	//姓名
			 	var b = $('#na').val();
			 	$('#mingzi').html(b);
			 	//性别
			 	var c = $('#se').val();
			 	$('#sssssix').html(c);
			 	//生日
			 	var d = $('#birth').val();
			 	$('#sheng').html(d);
			}
	 	});
//		//头像
//		var touxiang = $('#imgimg').val();
//		console.log(touxiang);
//	 	$('#img1').attr('src',touxiang);
//		//昵称
//		var a = $('#nn').val();
//	 	$('#ni').html(a);
//	 	//姓名
//	 	var b = $('#na').val();
//	 	$('#mingzi').html(b);
//	 	//性别
//	 	var c = $('#se').val();
//	 	$('#sssssix').html(c);
//	 	//生日
//	 	var d = $('#birth').val();
//	 	$('#sheng').html(d);
})();
