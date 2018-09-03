/**
 * 
 */
// 달력 비교

function check() {
    if ( $("#todate").val() < $("#fromdate").val() ) {
    	
    	alert("도착일이 출발일보다 빠릅니다.");
    	return false;
    } 
    
}
 
