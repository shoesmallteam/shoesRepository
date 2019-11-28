var flaguser1=false;
var flagpass1=false;
$('#section-big-layout-right li:eq(1) .layout-right-l2-middle1>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flaguser1 = true;
		lock1();
	}else{
		flaguser1 =false;
		lock1();
	}
	
});
$('#section-big-layout-right li:eq(1) .layout-right-l2-middle2>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flagpass1 = true;
		lock1();
	}else{
		flagpass1 =false;
		lock1();
		
	}
});
function lock1(){
	if(flaguser1&&flagpass1){
		$('#section-big-layout-right li:eq(1)>.layout-right-l2-down2').removeAttr('disabled');
	}else{
		$('#section-big-layout-right li:eq(1)>.layout-right-l2-down2').attr('disabled','disabled');
	}
	
}


var flaguser2=false;
var flagpass2=false;
$('#section-big-layout-right li:eq(2) .layout-right-l2-middle1>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flaguser2 = true;
		lock2();
	}else{
		flaguser2 =false;
		lock2();
	}
	
});
$('#section-big-layout-right li:eq(2) .layout-right-l2-middle2>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flagpass2 = true;
		lock2();
	}else{
		flagpass2 =false;
		lock2();
		
	}
});
function lock2(){
	if(flaguser2&&flagpass2){
		$('#section-big-layout-right li:eq(2)>.layout-right-l2-down2').removeAttr('disabled');
	}else{
		$('#section-big-layout-right li:eq(2)>.layout-right-l2-down2').attr('disabled','disabled');
	}
	
}

var flaguser3=false;
var flagpass3=false;
$('#section-big-layout-right li:eq(3) .layout-right-l2-middle1>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flaguser3 = true;
		lock3();
	}else{
		flaguser3 =false;
		lock3();
	}
	
});
$('#section-big-layout-right li:eq(3) .layout-right-l2-middle2>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flagpass3 = true;
		lock3();
	}else{
		flagpass3 =false;
		lock3();
		
	}
});
function lock3(){
	if(flaguser3&&flagpass3){
		$('#section-big-layout-right li:eq(3)>.layout-right-l2-down2').removeAttr('disabled');
	}else{
		$('#section-big-layout-right li:eq(3)>.layout-right-l2-down2').attr('disabled','disabled');
	}
	
}

var flaguser4=false;
var flagpass4=false;
$('#section-big-layout-right li:eq(4) .layout-right5-middle1>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flaguser4 = true;
		lock4();
	}else{
		flaguser4 =false;
		lock4();
	}
	
});
$('#section-big-layout-right li:eq(4) .layout-right5-middle2>input').keyup(function(){
	var a = $(this).val();
	if (a!='') {
		flagpass4 = true;
		lock4();
	}else{
		flagpass4 =false;
		lock4();
		
	}
});
function lock4(){
	if(flaguser4&&flagpass4){
		$('#section-big-layout-right li:eq(4)>.layout-right-l2-down2').removeAttr('disabled');
	}else{
		$('#section-big-layout-right li:eq(4)>.layout-right-l2-down2').attr('disabled','disabled');
	}
	
}











