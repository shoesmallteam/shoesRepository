function addGoodsList() {
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
                    <td class="col-sm-1"><span class="count-add">+</span><span class="count-number">1</span><span class="count-reduce">-</span></td>
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
                var currentCount = parseInt($(this).siblings().eq(0).html());
                if (currentCount < 20)
                {
                    $(this).siblings().eq(0).html(++currentCount);
                    //更新小计
                    var price = parseFloat($(this).parent().siblings().eq(3).find('.goods-price').html());
                    $(this).parent().siblings().eq(4).find('.subtotal').html(price * currentCount + '.00');
                    //更新总价
                    calTotalPrice();
                }
            });
            //减少
            $('.count-reduce').click(function () {
                var currentCount = parseInt($(this).siblings().eq(1).html());
                if (currentCount > 1)
                {
                    $(this).siblings().eq(1).html(--currentCount);
                    //更新小计
                    var price = parseFloat($(this).parent().siblings().eq(3).find('.goods-price').html());
                    $(this).parent().siblings().eq(4).find('.subtotal').html(price * currentCount + '.00');
                    //更新总价
                    calTotalPrice();
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
                var sum = 0;
                $('input[type="checkbox"]:gt(0)').each(function (index) {
                    if ($(this).is(':checked')) {
                        sum += parseFloat($(this).parent().parent().siblings(4).find('.subtotal').html());
                    }
                });
                $('.cart_total').html('总价：' + sum + '.00￥')
            }
        }
    })
};
addGoodsList();
