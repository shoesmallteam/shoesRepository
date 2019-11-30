/**
 * Created by admin on 2019/11/29.
 */
(function(){
	var count = null;
	
	$('.count-reduce').click(function(){
		count = $('.count-number').text().trim();
		count --;
		if(count <= 1){
			count = 1;
		}
		$('.count-number').html(count);
		var price = (count*$('.price').text().trim()).toFixed(2);
		$('.xiaoji').html(price);
		$('.textarea-allprice>span').eq(1).html(price);
		$('.realpay-price').html(price);
	});
	$('.count-add').click(function(){
		count = $('.count-number').text().trim();
		count ++;
		$('.count-number').html(count);
		var price = (count*$('.price').text().trim()).toFixed(2);
		$('.xiaoji').html(price);
		$('.textarea-allprice>span').eq(1).html(price);
		$('.realpay-price').html(price);
	});
	
	$('.order').click(function(){
		
	});
})();