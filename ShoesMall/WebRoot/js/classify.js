
//分类商品
var count = 1;
var typename = getUrlVal('typename');
function listGoods(typename,number,size) {
	$('.load-more').html("正在加载中...");
	$.ajax({
    	type : "GET",
        url : "http://localhost:8081/ShoesMall/classify.do",
        data : {"typename" : typename,"size" : size,"number" : number},
        success: function (result) {
        	$('.load-more').html("加载更多");
        	result = JSON.parse(result);
        	console.log(result);
        	var data = result;
            var str = ``;
            for (var i = 0; i < data.length; i++) {
                console.log(data[i].shoesid);
            	str += `
            <div class="col-md-3 col-sm-6 col-xs-12 goods-info" data-id="${data[i].shoesid}">
                <a href="product.jsp?shoesid=${data[i].shoesid}">
                    <img src="${data[i].image}" alt="">
                </a>
                <a class="info" href="product.do?shoesid=${data[i].shoesid}">
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

listGoods(typename,count++,8);


$('.load-more').click(function () {
    $('.load-more').html("正在加载中...")
    listGoods(typename,count++,8);
});

