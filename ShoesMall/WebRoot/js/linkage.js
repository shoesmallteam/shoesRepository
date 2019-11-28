$(function(){
  var i=1945;
  var date=new Date();
  var year=date.getFullYear();//获取当前年份
  var dropList;
  for(var i;i<2019;i++){
    if(i==year){
      dropList=dropList+"<option value='"+i+"' selected>"+i+"</option>";
    }else {
      dropList=dropList+"<option value='"+i+"'>"+i+"</option>";
    }
  }
  $('.year').html(dropList);//生成年份下拉列表
  var monthly;
  for(var j=1;j<13;j++){
    monthly=monthly+'<option value="'+j+'">'+j+'</option>'
  }
  $('.month').html(monthly);//生成月份下拉列表
  var daily;
  for(var day=1;day<=31;day++){
    daily=daily+'<option value="'+day+'">'+day+'</option>';
  }
  $('.day').html(daily);
  $('.year').change(function(){
  	$('.month').html(monthly);
  	$('.day').html(daily);
  })
  $('.month').change(function(){
    var currentDay;
    var total;
    var flag=$('.year').val();
    console.log(flag);
    var currentMonth=$('.month').val();
    switch (currentMonth){
      case "1":
      case "3":
      case "5":
      case "7":
      case "8":
      case "10":
      case "12":total=31;break;
      case "4":
      case "6":
      case "9":
      case "11":total=30;break;
      case "2":
        //闰年 整除4但是不整除100 或者整除400
        if( (flag%4==0 && flag%100!=0 ) || (flag%400==0)){
          total=29;
        }else {
          total=28;
        }
      default :break
    }
    for(day=1;day<=total;day++){
      currentDay=currentDay+'<option value="'+day+'">'+day+'</option>'
    }
    $('.day').html(currentDay);//生成日期下拉列表
  });
});