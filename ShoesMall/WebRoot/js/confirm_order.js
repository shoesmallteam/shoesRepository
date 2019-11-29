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
		$('.xiaoji').html((count*$('.price').text().trim()).toFixed(2));
	});
	$('.count-add').click(function(){
		count = $('.count-number').text().trim();
		count ++;
		$('.count-number').html(count);
		$('.xiaoji').html((count*$('.price').text().trim()).toFixed(2));
	});
	
	$('.order').click(function(){
		
	});
})();