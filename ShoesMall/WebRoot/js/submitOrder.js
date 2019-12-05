//点击保存地址按钮
$("#save").click(function(){
	var name = $('#consignee').val();
	var tel = $("#phone-number").val();
	var provinces = $("#provinces").val();
	var city = $("#city").val();
	var area = $("#area").val();
	var detail = $("#detail-address").val();
	var userid = $("#uid").val();
 
	$.ajax({
		type:"get",
		url:"insertAddress.do",
		data:"name="+name+"&tel="+tel+"&provinces="+provinces+"&city="+city+
		"&area="+area+"&detail="+detail+"&userid="+userid,
		success:function(result){
				
				var str = ``;
				str += `
					<tr>
					    <td><input type="hidden" id="addressid" value="Test"></td> 
						<td id="consignees"><p>${name }</p></td>
						<td id="phone-numbers"><p>${tel }</p></td>
						<td id="address"><p>${provinces}${city}${area}${detail} </p></td>
						<td id="operation">
							<span id="modify">修改</span>
							<span>　</span>
							<span id="delete">删除</span>
						</td>
					</tr>
					<tr>
						<td id="add-address">
							<div class="add-curcle"><p>新增收货地址</p></div>
						</td>
					</tr>
					`;
					$(".main-info").css("display","none");
					$("#exit-add").css("display","none");
	
					$('#select-address').css({"display":"block"});
					
					var row =  $(str);
					$('#select-address>table>tbody').append(row);
					 window.location.reload();
					/*$(row).find("#add-address .add-curcle").mouseover(function(){
						$(this).css({
							"background-color":"#c40e0e",
							"color":"#fff"
						});
						$('#save').css("display","block");
					});
					
					$(row).find('#add-address .add-curcle').mouseout(function(){
						$(this).css({
							"background-color":"#d6d6d6",
							"color":"#666"
						});
					});
					
					$(row).find('#row').mouseover(function(){
						$(this).css({
							"margin":"10px",
							"border":"1px solid #c40e0e"
						});
					});
					
					$(row).find('#row').mouseout(function(){
						$(this).css({
							"border":"1px solid #d6d6d6"
						});
					});*/
			}
	});
});
//新增收货地址鼠标事件
$('#add-address .add-curcle').mouseover(function(){
	$(this).css({
		"background-color":"#c40e0e",
		"color":"#fff"
	});
	$('#save').css("display","block");
});
$('#add-address .add-curcle').mouseout(function(){
	$(this).css({
		"background-color":"#d6d6d6",
		"color":"#666"
	});
});
//点击修改地址
$("#update").click(function(){
	var name = $('#consignee').val();
	var tel = $("#phone-number").val();
	var province = $("#provinces").val();
	var city = $("#city").val();
	var area = $("#area").val();
	var detail = $("#detail-address").val();
	var addressid = $("#addressid").val();
	
	/*alert("name"+name+"tel"+tel+"province"+province);*/
	
    $.ajax({
    	type:"get",
    	url:"updateAddress.do",
    	data:"name="+name+"&tel="+tel+"&province="+province+"&city="+city+
		"&area="+area+"&detail="+detail+"&addressid="+addressid,
		success:function(result){
			$("#select-address").css("display","block");
			$(".main-info").css("display","none");
			$("#exit-add").css("display","block");
			 window.location.reload();
			 
			   /* window.location.reload();*/
			/*$("#add-address").remove();*/
				
		}
    });
});
//地址框鼠标事件
$(".select-address tr").each(function(n){
	//除了最后一个tr都有的事件
	if(n<$(".select-address tr").length-1){
		//点击事件
		$(this).mouseover(function(){
			$(this).css({
				"margin" : "10px",
				"border" : "1px solid #c40e0e",
			});
		});
		
		$(this).mouseout(function(){
			$(this).css({
				"border" : "1px solid #d6d6d6",
			});
		});
		//点击删除按钮
		$(this).find("#delete").click(function(){
			var addressid = $(this).parents('tr').attr("data-addressid");
			
			/*var addressid = $('#addressid').val();*/
			/*alert("js中addressid="+addressid);*/
			
			$(".transparent").css({"display":"block"});
			$(".center-delete").css({"display":"block"});		
			$(".enter-delete").click(function(){
				//获得当前的会员ID
				
				//通过会员ID删除此地址
				$.ajax({
					type:"post",
					url:"deleteAddress.do",
					data:"addressid="+addressid,
					success:function(result){
						if(result){
							//清除界面中对应的地址
							/*$(".select-address tr").eq(index).remove();*/
							$(".transparent").css("display","none");
							$(".center-delete").css("display","none");
							//判断地址列表是否为空，空就显示新增地址界面
							 window.location.reload();
							if($(".select-address tr").length==1){
								$(".select-address").css("display","none");
								$(".main-info").css("display","block");
								$("#exit-add").css("display","none");
							};
						}
					}
				});
			});
				
		});
		
		//点击修改地址信息
		$(this).find("#modify").click(function(){
			var addressid = $(this).parents('tr').attr("data-addressid");
			var name = $(this).parents('tr').attr("data-name");
			var tel = $(this).parents('tr').attr("data-tel");
			var province = $(this).parents('tr').attr("data-province");
			var city = $(this).parents('tr').attr("data-city");
			var area = $(this).parents('tr').attr("data-area");
		    var detail = $(this).parents('tr').attr("data-detail");
		   
		    $("#select-address").css("display","none");
			$(".main-info").css("display","block");
			$("#exit-add").css("display","none");
			/*$("#add-address").remove();*/
			
			$("#addressid").val(addressid);
			$('#consignee').val(name);
			$('#phone-number').val(tel);
			
			/*set_select_checked('provinces', province);
			set_select_checked('city', city);
			set_select_checked('area', area);*/
			/* 
			$('#provinces').val(province);
			$('#city').val(city);
			$('#area').val(area);*/
			$('#detail-address').html(detail);
			
			$('#save').css("display","none");
			$('#update').css("display","block");
	       /* window.location.reload();*/
		});
	};
	//添加地址
	if(n==$(".select-address tr").length-1){
		$(this).click(function(){
			$("#select-address").css("display","none");
			$(".main-info").css("display","block");
			$("#exit-add").css("display","none");
			$("#add-address").remove();	
			$('#save').css("display","block");
			$('#update').css("display","none");
			});
		};
	}); 

//取消添加地址
$("#exit-add").click(function(){
	$(".select-address").css("display","block");
	$(".main-info").css("display","none");
});

//取消删除方法
function exitDelete(){
	$(".transparent").css("display","none");
	$(".center-delete").css("display","none");
};

$(".no-delete").click(exitDelete);
$(".close-ask").click(exitDelete);

//点击删除方法
$(".enter-delete").click(function(){
	
});

$(function(){
	autoSize();
	$(window).resize(autoSize);
	//获得当前的会员ID
	var memberId = 0;
	//判断是否有地址
	$.ajax({
		type:"post",
		url:" ",
		data:"memberId="+memberId,
		success:function(result){
			//返回的地址列表为空
			if(result==null){
				//显示新增地址界面
				$(".select-address").css("display","block");
				$(".main-info").css("display","none");
			}else{
				//添加地址到页面中
				var len = result.length;
				//逐个添加
				for(var i=0;i<result.length;i++){
					$(".select-address table tbody").prepend("");
				};
			};
		}
	});
});

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
		"top" : (windowHeight)/2-height
	});
};


function set_select_checked(selectId, checkValue){  
    var select = document.getElementById(selectId);  
 
    for (var i = 0; i < select.options.length; i++){  
        if (select.options[i].value == checkValue){  
            select.options[i].selected = true;  
            break;  
        }  
    }  
}



