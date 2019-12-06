var settlement = 0;
function addGoodsList() {
	var amountChanged = true;

	$.ajaxSettings.async = false;
    $.ajax({
        type:'POST',
        url:'cart.do',
        success : function (result) {
            var data = JSON.parse(result);
            var str = ``;
            //更新购物车数据
            for (var i = 0; i <data.length;i++)
            {
                var ani = 'bounceInRight';
                ani = i % 2 == 0 ? ani : 'bounceInLeft';
                $('.goods-cart>table').html(`<tr class="row">
                <th class="col-md-3">
                    <div class="">
                        <input type="checkbox" class="cart_selectAll">
                        <span class="">全选</span>
                    </div>
                </th>
                <th  class="col-sm-4">
                    <div>
                        <span class="">商品信息</span>
                    </div>
                </th>
                <th class="col-sm-2">
                    <div >
                        <span class="">颜色尺码</span>
                    </div>
                </th>
                
                <th class="col-sm-1">
                    <div >
                        <span class="">数量</span>
                    </div>
                </th>
                <th class="col-sm-1">
                    <div>
                        <span class="">价格</span>
                    </div>
                </th>
                <th class="col-sm-1">
                    <div>
                        <span class="">小计</span>
                    </div>
                </th>
            </tr>`);
                str+=`
                <tr class="row  animated ${ani} wow">
                    <td class="col-sm-3">
                        <div class="selectArea">
                            <input type="checkbox">
                            <img src="${data[i].image}" alt="" data-goods-id="${data[i].shoesdetailid}">
                        </div>  
                    </td>
                    <td class="col-sm-3"><p>${data[i].descs}</p></td>
                    <td class="col-sm-2"><span>颜色分类:${data[i].color}<br>尺码：${data[i].size}</span></td>
                    <td class="col-sm-1"><span class="count-add">+</span><span class="count-number" data-goods-id="${data[i].shoesdetailid}">${data[i].amount}</span><span class="count-reduce">-</span></td>
                    <td class="col-sm-1">￥<span class="goods-price">${data[i].price}</span></td>
                    <td class="col-sm-1">￥<span class="subtotal">${data[i].price}</span></td>
                    <td class="col-sm-1"><span class="glyphicon glyphicon-remove"></span></td>
                </tr>
                `;
            }
            $('.goods-cart>table').append(str);
            $(".goods-cart .glyphicon-remove").mouseover(function(){
                $(this).css("color","red");
            });
            $(".goods-cart .glyphicon-remove").mouseout(function(){
                $(this).css("color","black");
            });
            
            $(".goods-cart .glyphicon-remove").click(function(){
                if(confirm("您确定删除此购物车记录吗?"))
                {
                	var curRecord = $(this).parent().siblings().find(".count-number");
                	$.ajax({
                		type : "post",
                		url: "deleteCartGood.do",
                		data : {"shoesdetailid" : curRecord.attr("data-goods-id")},
                		success : function(delResult){
                			if("true" == delResult)
                			{
                				alert("删除成功");
                				addGoodsList();
                			}else{
                				alert("删除失败");
                			}
                		}
                	});
                	
                }
                
            });
            
            //全选
            $('.cart_selectAll').click(function () {
                if($(this).siblings().eq(0).html() == '全选'){
                    $('.container>table input[type="checkbox"]:gt(0)').each(function () {
                        $(this).prop('checked',true);
                    });
                    $(this).siblings().eq(0).html('全不选');
                }else{
                    $('.container>table input[type="checkbox"]:gt(0)').each(function () {
                        $(this).prop('checked',false);
                    });
                    $(this).siblings().eq(0).html('全选');
                };
                //更新总价
                calTotalPrice();
            });

            //添加
            $('.count-add').click(function () {
             if(amountChanged){
                amountChanged=false;
            	 var currentCount = parseInt($(this).siblings().eq(0).html());
	             var oCount = $(this).siblings().eq(0);
	             if (currentCount < 20)
	             {
	                 $(this).siblings().eq(0).html(++currentCount);
	                 //更新小计
	                 var price = parseFloat($(this).parent().siblings().eq(3).find('.goods-price').html());
	                 $(this).parent().siblings().eq(4).find('.subtotal').html(price * currentCount + '.00');
	                    
	                 //更新数据库
	                 
	                 console.log(oCount.attr("data-goods-id"));
	                 console.log(oCount.html());
	                 $.ajax({
	                	 url:"addGoodsToCart.do",
	                	 data :{"shoesdetailid":oCount.attr("data-goods-id"),"amount":"1"},
	                	 success : function(result){
	                		 if(result == "true")
	                		 {
	                		 	amountChanged = true;
	                		 }
	                	 }
	                 });
	                    
	                 //更新总价
	                 calTotalPrice();
	              }
                }
            });
            //减少
            $('.count-reduce').click(function () {
             if(amountChanged){
                amountChanged=false;
	                var currentCount = parseInt($(this).siblings().eq(1).html());
		            var oCount = $(this).siblings().eq(1);
	                if (currentCount > 1)
	                {
	                    $(this).siblings().eq(1).html(--currentCount);
	                    //更新小计
	                    var price = parseFloat($(this).parent().siblings().eq(3).find('.goods-price').html());
	                    $(this).parent().siblings().eq(4).find('.subtotal').html(price * currentCount + '.00');
	                    //更新数据库
	                    $.ajax({
		                	 url:"addGoodsToCart.do",
		                	 data :{"shoesdetailid":oCount.attr("data-goods-id"),"amount":"-1"},
		                	 success : function(result){
		                		 if(result == "true")
		                		 {
		                		 	amountChanged = true;
		                		 }
		                	 }
		                 });
	                    
	                    //更新总价
	                    calTotalPrice();
	                }
             	}
            });

            //单选
            $('input[type="checkbox"]:gt(0)').click(calTotalPrice);
            $('.selectArea>img').click(function () {
                $(this).siblings('input[type="checkbox"]').prop('checked',!$(this).siblings('input[type="checkbox"]').is(':checked'));
                calTotalPrice();
            });

            //计算总价
            function calTotalPrice() {
            	var shoes = [];
                var sum = 0;
                $('input[type="checkbox"]:gt(0)').each(function (index) {
                    var goods = {};
                    if ($(this).is(':checked')) {
                        sum += parseFloat($(this).parent().parent().siblings(4).find('.subtotal').html());
                        var countNumber = $(this).parent().parent().siblings(2).find(".count-number").html();
                		var dtid = $(this).parent().parent().siblings(2).find(".count-number").attr("data-goods-id");
    					goods.shoesdetailid = dtid;
    					goods.count = countNumber;
    					shoes.push(goods);
                    }
                });
                console.log(shoes);
                settlement = sum;
                $('.cart_total').html("总价：" + sum + ".00￥" + "<button class='settlement btn btn-primary'>结算</button>");
                $(".settlement").click(function(){
                	shoes = JSON.stringify(shoes);
                	shoes = encodeURI(shoes);
                	console.log(shoes);
                	location.href = "confirm_order.do?items=" + shoes;
                });
            }
        }
    })
};

addGoodsList();
//自动登陆与单态
function checkLogin1(){
	//拿到账号和密码
    var un = $('#username').val();
    var pw = $('#pwd').val();
    var nn = $('#nn').val();
    var msg = $('#msg').val();
    var isa = $('#isa').val();
    //判断
    if(un == '' || pw == ''){
    	$('#regist, #login').show();
        $('#welcome, #exit, .cart').hide();
        $('#welcome').html('');
    }else{
    	if(isa == '0'){
    		$('#regist, #login').hide();
    		$('#welcome, #exit, .cart').show();
    		$('#welcome').html(nn);
    	}else{
    		window.location.href = 'manage.jsp';
    	}
    };
    if (msg != '') {
    	alert(msg);
    	$.ajax({
    		type:"post",
    		url:"removemsg.do",
    		success:function(result){
				window.location.href = 'home.jsp';
			}
    	});
    }
    
};
checkLogin1();
//点击退出
$('#exit').click(function(){
	if (confirm(" Are you sure? ")) {
		$.ajax({
			type:"post",
			url:"exits.do",
			success:function(result){
				window.location.href = 'home.jsp';
			}
		});
	}
});