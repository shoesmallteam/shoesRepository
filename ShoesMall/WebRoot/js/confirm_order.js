/**
 * Created by admin on 2019/11/29.
 */
(function(){
	var count = null;
	$.ajaxSettings.async = false;
	
	$('.xiaoji').each(function(){
		count += parseInt($(this).text().trim());
	});
	$('.textarea-allprice').children('.textarea-price').html(count.toFixed(2));
	$('.realpay-price').html(count.toFixed(2));
	
	$('.order').click(function(){
		var accountid = $('.accountid').val();
		var order = null;
		
		$('.body-products').each(function(){
			var orderid = $(this).children('.orderid').val();
			var shoesdetailid = $(this).children('.shoesdetailid').val();
			var count = $('.count-number').text().trim();
			order = {'accountid':accountid,'orderid':orderid,'shoesdetailid':shoesdetailid};
			
			if(orderid != '' && orderid != null){
				$.ajax({
					type: "post",
					url:"addOrder.do",
					data:{'order':JSON.stringify(order),'count':count},
					dataType : 'json',
					success : function(result){
						if(result){
							alert('success');
							$('.orderid').attr('value','');
						}
					}
				});
			}
		});
	});
})();