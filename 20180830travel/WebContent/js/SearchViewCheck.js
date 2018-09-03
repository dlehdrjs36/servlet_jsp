/**
 * 
 */
/*$(function() {
	$("#getBtn").on("click", function() {
	
	
	}
}*/

var contury = ['서울','부산','제주','홍콩','타이페이','마카오','상하이','베이징','칭다오','도쿄','싱가포르','방콕','마닐라','쿠알라룸프르','하노이','런던','파리','로마','로스앤젤레스','뉴욕','샌프란시스코'];
var iata = ['GMP','PUS','CJU','HKG','TPE','MFM','SHA','BJS','TAO','TYO','SIN','BKK','MNL','KUL','HAN','LON','PAR','ROM','LAX','NYC','SFO' ];
// 선택된 영역이 아닌곳을 클릭하면 dropdown창이 안보이도록 함.
$('html').click(function(e) {
	if(!$(e.target).hasClass("area")) { 
		$('.dropdown-content').hide();
		}
	if(!$(e.target).hasClass("area2")) { 
		$('.dropdown2-content').hide();
		} 
	}); 
//
// 달력 UI
$(function() {
    $(".testDatepicker" ).datepicker({
    	showOn: "both", 
    	 buttonImage: "button.png", 
         buttonImageOnly: true ,
    	dateFormat : "yy-mm-dd",
    	dayNames : ['월요일','화요일','수요일','목요일','금요일','토요일','일요일'],
    	dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        minDate: -0, 
        maxDate: "+3M"
    });

});
// 항공권 개수증가
$(function(){ 
	  $('.bt_up').click(function(){ 
	    var n = $('.bt_up').index(this);
	    var num = $(".num:eq("+n+")").val();
		if(num == 9) {	
			return false;
		}
		else {   num = $(".num:eq("+n+")").val(num*1+1);} 	    
	  });
	  $('.bt_down').click(function(){ 
	    var n = $('.bt_down').index(this);
	    var num = $(".num:eq("+n+")").val();
		if(num == 0) {	
			return false;
		}
		else {   num = $(".num:eq("+n+")").val(num*1-1); } 
	  });
	});
// dropdown창
$(function(){ 
	$("#dia_bt").click(function(){ //dia_bt라는 아이디를 클릭했을 때
		$(".dropdown-content").css("display","block");			
	//함수실행
	/*	$("#dia_bt").click(function(){ 
		$("#dia_rs").dialog({ 
			autoOpen:false,
			title : "출발지 선택",
			width : 800,
			modal : true, //dialog창이 올라왔을 때 dialog이전 레이어(즉 dialog창뒤에 있는것)을 보호할것인가 하지않을것이가 정합니다
		});*/
		// 같이 값들어가는거 수정해야함.
		$(".contury").click(function(){ 
			//$("#dia_rs").dialog( "close" );			
			$(".dropdown-content").css("display","none");	
			var i = $(".contury").index(this);			
			console.log($(".contury").index(this));				
			$("input[name=from]").val(contury[i] +"(" +iata[i] + ")");	
		});

//	});	
	});	
});

$(function(){ 
	$("#dia_bt2").click(function(){ 
		$(".dropdown2-content").css("display","block");	
/*	$("#dia_bt2").click(function(){ 
		$("#dia_rs2").dialog({ // dia_rs를 dialog오버레이창으로 띄워주고 넓이 800을 설정합니다
			autoOpen:false,
			title : "도착지 선택",
			width : 800,
			modal : true, //dialog창이 올라왔을 때 dialog이전 레이어(즉 dialog창뒤에 있는것)을 보호할것인가 하지않을것이가 정합니다		
		});*/
		$(".tocontury").click(function(){ 
		//	$("#dia_rs2").dialog( "close" );
			$(".dropdown2-content").css("display","none");	
			var i = $(".tocontury").index(this);
			
			console.log($(".tocontury").index(this));
			
		
			$("input[name=to]").val(contury[i] +"(" +iata[i] + ")");	
		});
		
//	});	
	});
});

	