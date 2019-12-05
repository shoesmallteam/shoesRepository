$.ajaxSettings.async = false;
var pagesize = $('.pagesize').val();

(function(){
	$(".account_tag").attr('page_show','active');
	$(".shoes_tag").attr('page_show','');
	account();
})();

$(".account_tag").click(function(){
	$(".account_tag").attr('page_show','active');
	$(".shoes_tag").attr('page_show','');
	account();
});
$(".shoes_tag").click(function(){
	$(".account_tag").attr('page_show','');
	$(".shoes_tag").attr('page_show','active');
	shoes();
});

function account(){
	$(".shoes_info").css({"display":"none"});
	$(".shoes_info>table").empty();
	$(".account_info").css({"display":"block"});
	var str = `<thead>
						<td>账户</td>
						<td>密码</td>
						<td>电话</td>
						<td>邮箱</td>
						<td>是否为管理员</td>
					</thead>`;
	
	$.ajax({
		type:"get",
		url:"SelectAccount.do?pagesize="+pagesize,
//		data: {"pagesize" : JSON.stringify(pagesize)},
		success:function(result){
			var data = JSON.parse(result);
			for(var i=0;i< data.length;i++){
				str += `
				<tr>
				<td>${data[i].account}</td>
					<td>******</td>
					<td>${data[i].tel}</td>
					<td>${data[i].email}</td>
					<td>${data[i].isassistant}</td>
					<td>${data[i].isvip}</td>
					</tr>
					`;
			}
			 $(".account_info>table").html(str);			
		}
	});
}


function shoes(){
	$(".shoes_info").css("display","block");
	$(".account_info").css("display","none");
	$(".account_info>table").empty();
	var str = `<thead>
		<td>商品编号</td>
		<td>商品名称</td>
		<td><input type="text" value="商品详情id"></td>
		</thead>`;
	$.ajax({
		type:"post",
		url:"SelectAllShoes.do",
		data: {"pagesize" : pagesize},
		success:function(result){
			var data = JSON.parse(result);
			for(var i=0;i<data.length;i++){
				str += `<tr>
					<td>${data[i].shoesid}</td>
					<td>${data[i].descs}</td>
					<td><input type="text" value="${data[i].shoesdetailid}"></td>
					</tr>
					`;
			}
			$(".shoes_info>table").html(str);			
		}
	});
}

$('.prve').click(function(){
	pagesize --;
	if(pagesize <= 1){
		pagesize = 1;
	}
	if($(".account_tag").attr('page_show') != null && $(".account_tag").attr('page_show') != ''){
		account();
	}else{
		shoes();
	}
});

$('.next').click(function(){
	pagesize ++;
	if($(".account_tag").attr('page_show') != null && $(".account_tag").attr('page_show') != ''){
		account();
	}else{
		shoes();
	}
});
