/**
 * Created by admin on 2019/10/25.
 */
//初始化 33704
(function(){
//    var goodsid = getUrlVal('goods_id');
//    $.ajaxSettings.async = false;
//    $.get('http://www.wjian.top/shop/api_goods.php',{
//        goods_id : goodsid,
//    },function (event){
//        var goods = JSON.parse(event);
//        console.log(goods);
//        var id = `<span>Style # ${goods.data[0].goods_id}</span>`;
//        var getimg = `<img src="${goods.data[0].goods_thumb}">
//                    <div class="slide"></div>`;
//        var li_img = `<li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>`;
//        var name = `<h4>${goods.data[0].goods_name}</h4>`;
//        var price = `<span>${goods.data[0].price}</span>
//                    <span>1000.00</span>`;
//        var color_img = `<li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>
//                            <li><img src="${goods.data[0].goods_thumb}"></li>`;
//        //添加数据
//        $('.product .topbtn').html(id);
//        $('.product .product-img').html(getimg);
//        $('.product .content-show .navbar .nav').html(li_img);
//        $('.big-img').css({'background-image': 'url('+goods.data[0].goods_thumb+')'});
//        $('.product .banners h4').html(name);
//        $('.banners .price').html(price);
//        $('.banners .navbar #color').html(color_img);
//        $('.banners .navbar #color li .select').css({'background-image': 'url('+goods.data[0].goods_thumb+')'});
//        $('.banners .buy-btns .add-cart').attr('data-goods-id' ,goods.data[0].goods_id);
//
//        addCart();
//    });
	addCart();
})();

//加入购物车
function addCart(){
    $('.add-cart').click(function(){
        var token = localStorage.getItem('token');
        var goodsId = $(this).attr('data-goods-id');

        var color_active = false;
        var size_active = false;
        //检查是否存在active
        $('#color li').each(function (i) {
            if ($(this).prop('className') == 'active'){
                color_active = true;
            }
        });
        $('.size .prodSpec a').each(function (i) {
            if ($(this).prop('className') == 'active'){
                size_active = true;
            }
        });

        if (color_active&&size_active){
            if(token){
                //加入用户购物车
                //请求接口
                $.ajax({
                    type:"post",
                    url:"http://www.wjian.top/shop/api_cart.php",
                    data:{'goods_id':goodsId, 'number':1},
                    dataType : 'json',
                    success : function(re){
                        console.log(re);
                        //看返回数据，有加入成功   失败可能后台原因
                    },
                });
            }else{
                //用户没有登录    confirm  返回boolean
                if(confirm('未登录，请点击跳转登录界面')){
                    //跳到登录
                    location.href = 'index.html?goods_id='+ goodsId;
                };
            };
        }else {
            if (!color_active){
                confirm('请选择颜色');
            };
            if (!size_active){
                confirm('请选择尺码');
            };
        };
    });
};

(function(){
	String.prototype.trim=function(){
		var l = this.replace(this.match(/^\s+/), "");
		var r = l.replace(l.match(/\s+$/), "");
		return r;
	}
	
    //计数
    var count = 1;
    
    //首张图片
    $('.product-img img').attr('src',$('.content-show .nav li').eq(0).children().attr('src'));
    $('.big-img').css({'background-image': 'url('+$('.content-show .nav li').eq(0).children().attr('src')+')'});

    $('.product-img').mouseenter(function(event){
        var width = event.target.width;
        var height = event.target.height;
        $('.banners .big-img').css('background-size',parseInt(width * 2));

        $('.product-img').mousemove(function(event){
            var x = event.clientX - $('.product-img').offset().left - $('.slide').outerWidth()/2;
            var y = event.clientY - $('.product-img').offset().top - $('.slide').outerHeight()/2 +$(document).scrollTop();

            if (x <= 0){x= 0};
            if (y <= 0){y= 0};
            if (x >= $('.product-img').width() - $('.slide').outerWidth()){
                x = $('.product-img').width() - $('.slide').outerWidth();
            };
            if (y >= $('.product-img').height() - $('.slide').outerHeight()){
                y = $('.product-img').height() - $('.slide').outerHeight();
            };

            $('.slide').css({
                left : x,
                top : y,
            });

            var bili = (parseInt(width * 2) - $('.big-img').width()) / ($('.product-img').width() - $('.slide').outerWidth());
            var str = -x * bili + 'px ' + -y * bili + 'px';
            $('.big-img').css('backgroundPosition', str);
        });
    });

    //切换图片
    $('.content-show .nav li').each(function(i){
        $(this).click(function(){
            var imgstr = $(this).children().attr('src');
            $('.product-img img').attr('src',imgstr);
            $('.big-img').css({'background-image': 'url('+imgstr+')'});
        });
    });

    //鼠标移入显示图片
    $('.product-img').hover(function(){
        $('.big-img,.slide').show();
    },function(){
        $('.big-img,.slide').hide();
    });

    //点击跳出尺码表
    $('.banners .size .more').click(function(){
        $('.more-size').show();
    });
    $('.more-size .more-header p').click(function(){
        $('.more-size').hide();
    });

    //选择颜色
    $('#color li').each(function(i){
        console.log()
        $(this).click(function () {
        	if(/active/.test($(this).attr('class'))){
        		$(this).children('i').remove('i');
        		$(this).removeClass('active');
        	}else{
        		$(this).append('<i></i>').siblings().children('i').remove('i');
        		$(this).addClass('active').siblings().removeClass('active');
        	}
        });
        //鼠标移入显示较大图片
        $(this).mouseenter(function(){
            var imgstr = $(this).children('img').attr('src');
            $(this).append('<div class="select"></div>').siblings().children('.select').remove('.select');
            $(this).children('.select').css({'background-image': 'url('+imgstr+')'});
        });
        $(this).mouseleave(function(){
            $(this).children('.select').remove('.select');
        });
    });

    //选择尺码
    $('.banners .size .prodSpec a').each(function(i){
        $(this).click(function(){
        	if(/active/.test($(this).attr('class'))){
        		$(this).children('i').remove('i');
        		$(this).removeClass('active');
        	}else{
        		if ($(this).prop('className') != $('.banners .size .prodSpec a').last().prop('className')){
        			$(this).append('<i></i>').siblings().children('i').remove('i');
        			$(this).addClass('active').siblings().removeClass('active');
        		}
        	}
        });
    });

    //输入获取焦点
    $('.banners .count input').focusin(function(){
        $('.banners .count input').keydown();
        $('.banners .count input').keyup(function(){
            var str = $('.banners .count input').val();
            if (/^[1-9]{2}$/.test(str)){
                $('.banners .count input').val(str);
            }else{
                $('.banners .count input').val(count);
            }
        });
    });
    $('.banners .count input').focusout(function(){
        count = $('.banners .count input').val();
        if (count.length != 0){
            $('.banners .count input').val(count);
        }else{
            count = 1;
            $('.banners .count input').val(count);
        }
    });
    //点击增加数量
    $('.add').click(function(){
        count ++;
        if (count > 10 ){
            count = 10;
            alert('数量不能超过10');
        };
        $('.add').parent().siblings('input').val(count);
    });
    $('.sub').click(function(){
        count --;
        if (count < 1 ){
            count = 1;
        };
        $('.add').parent().siblings('input').val(count);
    });
    
    //选择颜色或尺码，改变库存数
    $('#color,.size .prodSpec').click(function(){
    	var color = null;
    	var size = null;
    	var shoesid = $('#shoesid').text();
    	$('#color li').each(function(){
    		if($(this).attr('class')!=null){
    			color = $(this).attr('value');
    		}
    	});
    	$('.banners .size .prodSpec a').each(function(){
    		if(/active/.test($(this).attr('class'))){
    			size = $(this).children('span').text();
    		}
    	});
    	var shoes = {'shoesid':shoesid,'color':color,'size':size};
    	if(color != null && size != null){
    		$.ajax({
    			type: 'get',
    			url: 'selectcount.do',
    			data: {'shoes':JSON.stringify(shoes)},
    			dataType: "json",
    			success: function(result){
    				$('#onlycount').html(result);
    			}
    		});
    	}
    });
    
    
})();

