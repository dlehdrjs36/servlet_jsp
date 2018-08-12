/**
 * 
 */

function paging(param1){
	var pagingform = document.pagingform;
	pagingform.page.value= param1 ;
	pagingform.submit();
	}

function paging(param1, param2, param3){
	var pagingform = document.pagingform;
	pagingform.page.value= param1 ;
	pagingform.subjects.value= param2 ;
	pagingform.search.value= param3;
	pagingform.submit();

}



