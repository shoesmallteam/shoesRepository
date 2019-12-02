/**
 * Created by admin on 2019/10/25.
 */
	
//http://localhost:8080/ShoesMall/product.do?shoesid=601589564514

(function(){
	var cookie = $.cookie('auto_login');
	$.ajaxSettings.async = false;
	
	Show();
	//显示购物车
	function Show(){
		if(cookie){
			$('#regist, #login').hide();
			$('#welcome, #exit, .cart').show();
			$('#welcome').html(cookie.split("#itheima#")[2]);
		}
	};
	
	//瘦身
	String.prototype.trim=function(){
		var l = this.replace(this.match(/^\s+/), "");
		var r = l.replace(l.match(/\s+$/), "");
		return r;
	}
	
	var color = null;
	var size = null;
	var shoes = null;
	var shoesdetailid = null;//详情id
	var image = null;
	var price = null;
	
    //计数
    var count = 1;
    
    //首张图片
    $('.product-img img').attr('src',$('.colorImage').attr('src'));
    $('.big-img').css({'background-image': 'url('+$('.colorImage').attr('src')+')'});
    

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
        		color = null;
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
        		size = null;
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
    	var shoesid = $('#shoesid').text();
    	shoes = {'shoesid':shoesid,'color':color,'size':size};
    	if(color != null && size != null){
    		$.ajax({
    			type: 'get',
    			url: 'selectcount.do',
    			data: {'shoes':JSON.stringify(shoes)},
    			dataType: "json",
    			success: function(result){
    				$('#onlycount').html(result.count);
    				shoesdetailid = result.shoesdetailid;
    				image = result.image;
    				price = result.price;
    				shoes = null;
    			}
    		});
    	}
    });
    addCart();
    Setaccounts();
    
  //加入购物车
    function addCart(){
        $('.add-cart').click(function(){
            var shoesid = $(this).attr('data-goods-id');
            var amount = $('.banners .count input').val();//数量
            
            //查询库存
            shoes = {'shoesid':shoesid,'color':color,'size':size};
            if (color != null && size != null){
            	//查询详情id
            	$.ajax({
            		type:"get",
            		url: 'selectcount.do',
        			data: {'shoes':JSON.stringify(shoes)},
        			dataType: "json",
        			success: function(result){
        				$('#onlycount').html(result.shoesid);
        				shoesdetailid = result.shoesdetailid;
        				sheos = null;
        			}
            	});
            	
            	//加入用户购物车
                if(cookie){
                    //请求接口
                    $.ajax({
                        type:"get",
                        url:"addGoodsToCart.do",
                        data:{'shoesdetailid':shoesdetailid,'amount':amount},
                        dataType : 'json',
                        success : function(result){
                        	//看返回数据，有加入成功   失败可能后台原因
                        	if(/true/.test(result)){
                        		confirm("Add To Cart,Success!");
                        		shoesdetailid = null;
                        	}else{
                        		confirm("Failed to join cart");
                        	}
                        },
                    });
                }else{
                    //用户没有登录    confirm  返回boolean
                    if(confirm('Not logged in, please click to jump to the login interface')){
                        //跳到登录
                    };
                };
            }else {
                if (color == null){
                    confirm('Please select a color');
                };
                if (size == null){
                    confirm('Please choose a size');
                };
            };
        });
    };
    
    //结账
    function Setaccounts(){
    	$('.buy').click(function(){
    		var count = $('.count input').val();
    		
    		var items = [{"shoesdetailid":shoesdetailid,"count":1},{"shoesdetailid":"007448ff-a7aa-4ee1-92d5-d700deddc528","count":1}];
    		if (color != null && size != null){
    			//跳结账界面
    			items = encodeURI(JSON.stringify(items));
    			location.href = 'confirm_order.do?items='+items;
    		}else{
    			if (color == null){
                    confirm('Please select a color');
                };
                if (size == null){
                    confirm('Please choose a size');
                };
    		};
    	});
    };
})();
