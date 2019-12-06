/**
 * Created by admin on 2019/11/29.
 */
(function(){
	var count = null;
	$.ajaxSettings.async = false;
	var addressid = null;
	
	$('.xiaoji').each(function(){
		count += parseInt($(this).text().trim());
	});
	$('.textarea-allprice').children('.textarea-price').html(count.toFixed(2));
	$('.realpay-price').html(count.toFixed(2));
	
	$('.address-input').click(function(){
		$(this).children('input').each(function(){
			addressid = $(this).val();
		});
	});
	
	$('.order').click(function(){
		var accountid = $('.accountid').val();
		var order = null;
		
		if(addressid == null && addressid == ''){
			alert('Please select an address');
		}else{
			$('.body-products').each(function(){
				var orderid = $(this).children('.orderid').val();
				var shoesdetailid = $(this).children('.shoesdetailid').val();
				var count = $('.count-number').text().trim();
				order = {'accountid':accountid,'orderid':orderid,'shoesdetailid':shoesdetailid,'addressid':addressid};
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
		}
	});
})();