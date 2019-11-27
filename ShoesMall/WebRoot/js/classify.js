
//分类商品
var count = 1;
var cartid = getUrlVal('cartId');
function listGoods(cartId,page,pageSize) {
    console.log(cartId)
    $.ajax({
        type: 'GET',
        url: 'http://www.wjian.top/shop/api_goods.php',
        data: {
            'cat_id': cartid,
            'page': page,
            'pagesize': pageSize
        },
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        success: function (result) {
            var data = result.data;
            console.log(data);
            var str = ``;
            for (var i = 0; i < data.length; i++) {
                str += `
            <div class="col-md-3 col-sm-6 col-xs-12 goods-info" data-id="${data[i].goods_id}">
                <a href="product.jsp?goods_id=${data[i].goods_id}">
                    <img src="${data[i].goods_thumb}" alt="">
                </a>
                <a class="info" href="product.jsp?goods_id=${data[i].goods_id}">
                    <p class="goods-name">${data[i].goods_name}</p>
                    <p class="goods-desc">${data[i].goods_desc}</p>
                </a>
                <div class="price-and-star">
                    <span class="goods-price">￥${data[i].price}</span>
                    <span class="goods-star"><b>❤</b>${data[i].star_number}</span>
                </div>
                <a href="http://www.baidu.com" target="_blank" class="join-to-cart">加入购物车</a>
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

listGoods(cartid,count++,8);


$('.load-more').click(function () {
	console.log("id" + cartid);
    listGoods(cartid,count++,8);
});

