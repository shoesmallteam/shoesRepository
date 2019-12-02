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
                str+=`
                <tr class="row  animated ${ani} wow">
                    <td class="col-sm-3">
                        <div class="selectArea">
                            <input type="checkbox">
                            <img src="${data[i].image}" alt="" data-goods-id="${data[i].shoesdetailid}">
                        </div>  
                    </td>
                    <td class="col-sm-4"><p>${data[i].descs}</p></td>
                    <td class="col-sm-2"><span>颜色分类:${data[i].color}<br>尺码：${data[i].size}</span></td>
                    <td class="col-sm-1"><span class="count-add">+</span><span class="count-number" data-goods-id="${data[i].shoesdetailid}">${data[i].amount}</span><span class="count-reduce">-</span></td>
                    <td class="col-sm-1">￥<span class="goods-price">${data[i].price}</span></td>
                    <td class="col-sm-1">￥<span class="subtotal">${data[i].price}</span></td>
                </tr>
                `;
            }
            $('.goods-cart>table').append(str);

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
                    if ($(this).is(':checked')) {
                        sum += parseFloat($(this).parent().parent().siblings(4).find('.subtotal').html());
                        var goods = {};
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
                	
                	console.log(shoes);
                	
                });
            }
        }
    })
};

addGoodsList();
