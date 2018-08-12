/**
 *  검색조건 입력여부 체크.
 */

  function checkContent() {
	  var Rex = /^[1-2]{1}$/;
	  var target = document.getElementById("subjects");
	  
	  
	  if(document.getElementById("content").value ==""){
		  alert("검색조건 내용을 작성해주세요.");
		  return false;
		 }  
	  
	  if(target.options[target.selectedIndex].value==2) {
		  if( !Rex.test(document.searchoption.content.value)) {
			  alert("Flag는 1(포인트적립) 또는 2(포인트사용)를 입력해야합니다.");
			  return false;
      }
  	}
	  
  }