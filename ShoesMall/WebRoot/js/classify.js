
//分类商品
var count = 1;
var price = 5;
var classify = {};
var curentMaxIndex = 8;
var typename = getUrlVal('typename');
function listGoods(typename,number,size,price) {
	if(size > curentMaxIndex){
		$(".no-more").show();
		$(".load-more").hide();
		return;
	}
	var flag = false;
	
	if(price != classify.price){
		flag = true;
	}
	classify.typename = typename;
	classify.number = number;
	classify.size = size;
	classify.price = price;
	
	$('.load-more').html("正在加载中...");
	$.ajax({
    	type : "GET",
        url : "http://localhost:8081/ShoesMall/classify.do",
        data : classify,
        success: function (result) {
        	$('.load-more').html("加载更多");
        	result = JSON.parse(result);
        	console.log(result);
        	var data = result;
            var str = ``;
            if(flag == true)
            {            	
            	$('.classify>.row').html("");
            }
            curentMaxIndex = data.length;
            for (var i = 0; i < data.length; i++) {
                console.log(data[i].shoesid);
            	str += `
            <div class="col-md-3 col-sm-6 col-xs-12 goods-info" data-id="${data[i].shoesrid}">
                <a href="product.jsp?shoesid=${data[i].shoesid}&color=${data[i].color}">
                    <img src="${data[i].image}" alt="">
                </a>
                <a class="info" href="product.do?shoesid=${data[i].shoesid}&color=${data[i].color}">
                    <p class="goods-desc">${data[i].descs}</p>
                </a>
                <div class="price-and-star">
                    <span class="goods-price">￥${data[i].price}</span>
                </div>
                <a href="addGoodsToCart.do?shoesdetailid=${data[i].shoesdetailid}&amount=1" target="_blank" class="join-to-cart">加入购物车</a>
            </div>
            `;
            }
            $('.classify>.row').append(str); 
            $('.goods-info>.info').css({
                'width': $('.goods-info img').width(),
                'height': $('.goods-info img').height()
            });
            $('.goods-info>.price-and-star').css({
                'width': $('.goods-info img').width(),
                'height': 50
            });

            $('.goods-info img').mouseenter(function () {
                $(this).parent().siblings('.info').show();
            });

            $('.info').mouseleave(function () {
                $(this).hide();
            });
        }
    });
};

listGoods(typename,count++,8,price);


$('.load-more').click(function () {
    $('.load-more').html("正在加载中...")
    listGoods(typename,count++,8,price);
});

$(".search-by-price").click(function(){

	var price_sort = $(this).siblings(".price-sort");
	var price_step = $(this).siblings(".price-step");
	
	var psort = price_sort.find("select option:checked").val();
	var pstep = price_step.find("select option:checked").val();
	price = (parseInt(psort) + parseInt(pstep));
	listGoods(typename,count++,8,price);
});
