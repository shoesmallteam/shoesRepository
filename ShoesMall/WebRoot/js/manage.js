


function exitDelete(){
	$(".transparent").css("display","none");
	$(".center-delete").css("display","none");
	$(".center-update").css("display","none");
};

$(".no-delete").click(exitDelete);
$(".close-ask").click(exitDelete);

$(".no-update").click(exitDelete);
					
//设置确认你删除界面的大小
function autoSize(){
	//获得窗口的大小
	
	var windowWidth = document.body.clientWidth;
	var windowHeight = document.body.clientHeight;
	/*alert("宽："+windowWidth + ",高"+ windowHeight);*/
	//获得
	var width = $(".center-delete").width();
	var height = $(".center-delete").height();
	
	$(".transparent").css({
		"width" : windowWidth,
		"height" : windowHeight
	});
	
	$(".center-delete").css({
		"left" : (windowWidth-width)/2,
		"top" : (windowHeight-height)/2
	});
	$(".center-update").css({
		"left" : (windowWidth-width)/2,
		"top" : (windowHeight-height)/2
	});
};

$(".info table tr").mouseover(function(){
	$(this).css({"border-color":"#c40e0e",
		});
});

$(".info table tr").mouseout(function(){
	$(this).css({"border-color":"#eee",
	});
});

$(".info table tr td").css("padding-top","10px");
$(".delete_shoes button").css({"border-radius":"5px"});
$(".update_account button").css({"border-radius":"5px"});


$('.delete_shoes').click(function(){
	autoSize();
	var shoesid = $(this).attr("data-detailid");
	alert(shoesid);
	$(".transparent").css({"display":"block"});
	$(".center-delete").css({"display":"block"});	
	
	//-----------------------------------------------------------------
	$(".enter-delete").click(function(){
		alert(shoesid);
		//获得当前的会员ID
		/*alert("detailid====="+detailid);*/
		if(shoesid != ``){
			$.ajax({
				type:"post",
				url:"delectShoes.do",
				data:"shoesid=1",
				success:function(){
					$(".transparent").css("display","none");
					$(".center-delete").css("display","none");
					$(".account_tag").attr('page_show','');
					$(".shoes_tag").attr('page_show','active');
					
					window.location.reload();
					
				}
			});
		}
		
		detailid = ``;
	});	
});


$(".update_account").click(function(){
	autoSize();
	var account = $(this).attr('account');
	var isassistant = $(this).attr("data-isassistant");
	var isvip = $(this).attr("data-isvip");
	
	$(".transparent").css({"display":"block"});
	$(".center-update").css({"display":"block"});	
	
	$('#account').val(account);
	$("#isassistant").val(isassistant);
	$("#isvip").val(isvip);
	
	//-----------------------------------------------------------------
	$(".enter-update").click(function(){
		account = $('#account').val();
		isassistant = $('#isassistant').val();
		isvip = $('#isvip').val();
		//获得当前的会员ID
		/*alert("detailid====="+detailid);*/
		if(account != ``){
			
			$.ajax({
				type:"post",
				url:"updateAccount.do",
				data:"account="+account+"&isassistant="+isassistant+"&isvip="+isvip,
				success:function(){
					$(".transparent").css("display","none");
					$(".center-update").css("display","none");
					window.location.reload();
					
				}
			});
		}
		detailid = ``;
	});	
});