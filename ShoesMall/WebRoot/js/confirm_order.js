/**
 * Created by admin on 2019/11/29.
 */
(function(){
	var count = null;
	$('.xiaoji').each(function(){
		count += parseInt($(this).text().trim());
	});
	$('.textarea-allprice').children('.textarea-price').html(count.toFixed(2));
	$('.realpay-price').html(count.toFixed(2));
	
	$('.order').click(function(){
		
	});
})();