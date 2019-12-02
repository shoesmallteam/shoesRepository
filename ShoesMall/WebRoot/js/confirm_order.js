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
		var result = null;
		
		$('.body-products').each(function(){
			var orderid = $(this).children('.orderid').val();
			var shoesdetailid = $(this).children('.shoesdetailid').val();
			order = {'accountid':accountid,'orderid':orderid,'shoesdetailid':shoesdetailid};
			
			$.ajax({
				type: "post",
				url:"addOrder.do",
                data:{'order':JSON.stringify(order)},
                dataType : 'json',
                success : function(result){
                	result = result;
                }
			});
		});
		if(result){
			alert(success);
		}
	});
})();