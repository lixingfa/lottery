$(function(){
	//显示
	for(var i = 0; i < num1.length; i ++){
		$("#data").append("<tr><td>" + periods[i] + "</td><td>" + numdate[i] + "</td><td>" + ganzhi[i] 
		+ "</td><td>" + num1[i] + "</td><td>" + num2[i] + "</td><td>" + num3[i] + "</td><td>"+sum(num1[i],num2[i],num3[i])+"</td><td>"
		+getWuXing(num1[i]) + "</td><td>" +getWuXing(num2[i]) + "</td><td>" +getWuXing(num3[i]) + "</td><td>"
		+getWuXing(sum(num1[i],num2[i],num3[i])) +
		"</td></tr>");
	}
});

function search(){
	var zhigan = "";
	var gan = $("#gan").val();
	var zhi = $("#zhi").val();
	if(gan != 0){
		zhigan = $("#gan").find("option:selected").text();
	}
	if(zhi != 0){
		zhigan = zhigan + $("#zhi").find("option:selected").text() + "日";
	}
	$("#data").find("tr").each(function(index,tr){
		if(ganzhi[index].indexOf(zhigan) != -1){
			$(tr).show();
		}else{
			$(tr).hide();
		}
	});
}

function sum(n1,n2,n3){
	return n1 + n2 + n3;
}

function getWuXing(n){
	switch(n % 5){
		case 0 : return "土";break;
		case 1 : return "水";break;
		case 2 : return "火";break;
		case 3 : return "木";break;
		case 4 : return "金";break;
	}
}