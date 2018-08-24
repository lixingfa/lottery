function test(){
	var now = Number($("#now").val());
	var how = Number($("#how").val()) + now;
	$("#now").val(how + 1);
	//验证
	$("#data").find("tr").each(function(itr,tr){
		if(itr >= now && itr <= how){//从第三行开始
			var s = "<tr>";
			$(tr).find("td").each(function(itd,td){
				if(itd >= 7){
					s = s + "<td>";
					var now = "";
					var former5 = $('#data tr:eq('+(itr - 5)+') td:eq('+(itd)+')').html();
					var former4 = $('#data tr:eq('+(itr - 4)+') td:eq('+(itd)+')').html();
					var former3 = $('#data tr:eq('+(itr - 3)+') td:eq('+(itd)+')').html();
					var former2 = $('#data tr:eq('+(itr - 2)+') td:eq('+(itd)+')').html();
					var former1 = $('#data tr:eq('+(itr - 1)+') td:eq('+(itd)+')').html();
					//now = getNow(now,whichLast(former1,former2,former3,former4));
					//now	= getNow(now,whichLastS(former1,former2,former3,former4,former5));
					now = getNow(now,lianxuS(former1,former2,former3,former4,former5));
					var contains = now.indexOf($(td).html());
					if(contains != -1){
						s = s + "<span class=\"red\">"
					}
					s = s + now;
					if(contains != -1){
						s = s + "</span>"
					}
					s = s + "</td>";
				}
			});
			s = s + "<td>&nbsp;</td></tr>";
			$("#dataTest").append(s);
			s = "";
		}		
	});
}

function getNow(now,value){
	if(now == ""){
		now = value;
	}else if(now.indexOf(value) == -1){		
		now = now + "," + value;
	}
	return now;
}

function whichLast(former1,former2,former3,former4){
	var wuxing = new Array("土","水","火","木","金");
	var wuxingt = new Array(0,0,0,0,0);
	var k = 0;
	var index = -1;
	for(var i = 0;i < wuxing.length;i++){
		if(former1 == wuxing[i] || former2 == wuxing[i] || former3 == wuxing[i] || former4 == wuxing[i]){
			wuxingt[i] = 1;
		}else{
			k++;
			index = i;
		}
	}
	if(k == 1){
		return wuxing[index];
	}
	return "";
}

function lianxuS(former1,former2,former3,former4,former5){
	var wuxing = new Array(former1,former2,former3,former4,former5);
	var shengke = new Array("∪","∩","⊕","∧","∨");
	var before = "";
	var lianxu = 0;
	for(var i = wuxing.length - 3;i > 0;i--){
		var nowshengke = getShengke(wuxing[i],wuxing[i - 1]);
		if(before == nowshengke){
			lianxu++;
			if(lianxu == 1){
				return shengkeTheOne(wuxing[0],nowshengke);
			}
		}else{
			lianxu = 0;
		}
		before = nowshengke;
	}
	return "";
}

function whichLastS(former1,former2,former3,former4,former5){
	var wuxing = new Array(former1,former2,former3,former4,former5);
	var shengke = new Array("∪","∩","⊕","∧","∨");
	var wuxingt = new Array(0,0,0,0,0);
	var k = 0;
	var index = -1;
	var s = "";
	for(var i = 1;i < shengke.length;i++){
		var nowshengke = getShengke(wuxing[i - 1],wuxing[i]);
		s = s + nowshengke;
		for(var j = 0;j < shengke.length;j++){
			if(nowshengke == shengke[j]){
				wuxingt[j] = 1;
				break;
			}
		}		
	}
	for(var i = 0;i < wuxingt.length;i++){
		if(wuxingt[i] == 1){
			k++;
		}else{
			index = i;
		}
	}
	if(k == 4){
		return shengkeTheOne(former1,shengke[index]);
	}
	return "";
}

function getShengke(one,theOther){
	switch(one){
		case "土":
			switch(theOther){
				case "金" : return "∪";
				case "火" : return "∩";
				case "土" : return "⊕";
				case "木" : return "∧";
				case "水" : return "∨";
			}
		case "水":
			switch(theOther){
				case "木" : return "∪";
				case "金" : return "∩";
				case "水" : return "⊕";
				case "土" : return "∧";
				case "火" : return "∨";
			}
		case "金":
			switch(theOther){
				case "水" : return "∪";
				case "土" : return "∩";
				case "金" : return "⊕";
				case "火" : return "∧";
				case "木" : return "∨";
			}
		case "木":
			switch(theOther){
				case "火" : return "∪";
				case "水" : return "∩";
				case "木" : return "⊕";
				case "金" : return "∧";
				case "土" : return "∨";
			}
		case "火":
			switch(theOther){
				case "土" : return "∪";
				case "木" : return "∩";
				case "火" : return "⊕";
				case "水" : return "∧";
				case "金" : return "∨";
			}
	}
}

function shengkeTheOne(one,shengke){
	switch(one){
		case "土":
			switch(shengke){
				case "∪" : return "金";
				case "∩" : return "火";
				case "⊕" : return "土";
				case "∧" : return "木";
				case "∨" : return "水";
			}
		case "水":
			switch(shengke){
				case "∪" : return "木";
				case "∩" : return "金";
				case "⊕" : return "水";
				case "∧" : return "土";
				case "∨" : return "火";
			}
		case "金":
			switch(shengke){
				case "∪" : return "水";
				case "∩" : return "土";
				case "⊕" : return "金";
				case "∧" : return "火";
				case "∨" : return "木";
			}
		case "木":
			switch(shengke){
				case "∪" : return "火";
				case "∩" : return "水";
				case "⊕" : return "木";
				case "∧" : return "金";
				case "∨" : return "土";
			}
		case "火":
			switch(shengke){
				case "∪" : return "土";
				case "∩" : return "木";
				case "⊕" : return "火";
				case "∧" : return "水";
				case "∨" : return "金";
			}
	}
}