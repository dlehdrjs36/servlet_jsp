package DTO;

	public class PointPagingBean {
	    private int page=1; //현재 페이지
	    private int totalCount; //전체 게시글수
	    private int beginPage;    //출력 시작
	    private int endPage;    //출력 끝
	    private int displayRow = 15;    //한 페이지에 몇 개 row
	    private int displayPage = 5;    //화면에서 보여줄 페이지의 목록. 5개씩 보여줌.
	    boolean prev; //prev 버튼이 보일지/안 보일지
	    boolean next; //총 페이지 수가 5개 넘는 경우만 true.	     
	    private int group_no;	 // 현재 그룹
	    private int page_sno;	// 현재그룹에서 페이지의 시작번호
	    private int page_eno;	// 현재그룹에서 페이지의 끝번호
	    private int prev_pageno; // 이전페이지
	    private int next_pageno; // 다음페이지
	    private int totalPage;

	    private String search;
	    private String subjects;
	    
	    public String getSearch() {
			return search;
		}
		public void setSearch(String search) {
			this.search = search;
		}
		public String getSubjects() {
			return subjects;
		}
		public void setSubjects(String subjects) {
			this.subjects = subjects;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getBeginPage() {
			return beginPage;
		}
		public void setBeginPage(int beginPage) {
			this.beginPage = beginPage;
		}
		public int getEndPage() {
			return endPage;
		}
		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}
		public int getDisplayRow() {
			return displayRow;
		}
		public void setDisplayRow(int displayRow) {
			this.displayRow = displayRow;
		}
		public int getDisplayPage() {
			return displayPage;
		}
		public void setDisplayPage(int displayPage) {
			this.displayPage = displayPage;
		}
		public boolean isPrev() {
			return prev;
		}
		public void setPrev(boolean prev) {
			this.prev = prev;
		}
		public boolean isNext() {
			return next;
		}
		public void setNext(boolean next) {
			this.next = next;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
	        //이걸 꼭 호출해야 paging이 가능하기 때문에
	        //이걸 호출하면 자동으로 paging() 함수 호출하도록 설정
	        this.totalCount = totalCount;
	        paging();
	    }			
	    public int getGroup_no() {
			return group_no;
		}
		public int getPrev_pageno() {
			return prev_pageno;
		}
		public void setPrev_pageno(int prev_pageno) {
			this.prev_pageno = prev_pageno;
		}
		public int getNext_pageno() {
			return next_pageno;
		}
		public void setNext_pageno(int next_pageno) {
			this.next_pageno = next_pageno;
		}
		public void setGroup_no(int group_no) {
			this.group_no = group_no;
		}
		public int getPage_sno() {
			return page_sno;
		}
		public void setPage_sno(int page_sno) {
			this.page_sno = page_sno;
		}
		public int getPage_eno() {
			return page_eno;
		}
		public void setPage_eno(int page_eno) {
			this.page_eno = page_eno;
		}
		private void paging(){
	        //displayPage = 15(고정값)
	        //prev,next,beginPage,endPage 를 계산해서 만든다.	     
	    	endPage = ((page+(displayPage-1))/displayPage)*displayPage;
	        beginPage = endPage - (displayPage-1);	        
	        //글이 32개라면 필요한 페이지는 4개
	        //32/10 = 3.2 올림해서 4
	        totalPage = (int)Math.ceil(totalCount/(double)displayRow);            
	        if(page>totalPage){
	    		page = totalPage;
	    	}
	        if(totalPage<=endPage){
	            endPage = totalPage;
	            next=false;
	        }else{
	            next=true;
	        }
	        prev=(beginPage == 1)? false : true;	        
	        group_no = page/ displayPage + (page%displayPage>0 ? 1 : 0);
	        page_eno = group_no*displayPage;
	        page_sno = page_eno-(displayPage-1);	     
	        if(page_eno>totalPage){
//	     	   현재 그룹 끝 번호가 전체페이지 수 보다 클 경우		
	     		page_eno=totalPage;
//	     	   현재 그룹 끝 번호와 = 전체페이지 수를 같게
	     	}
	        prev_pageno = page_sno-displayPage;  // <<  *[이전]* [21],[22],[23]... [30] [다음]  >>
//			이전 페이지 번호	= 현재 그룹 시작 번호 - 페이지당 보여줄 번호수	
//		ex)		46		=	51 - 5				
	        next_pageno = page_sno+displayPage;	// <<  [이전] [21],[22],[23]... [30] *[다음]*  >>
//			다음 페이지 번호 = 현재 그룹 시작 번호 + 페이지당 보여줄 번호수
//		ex)		56		=	51 - 5
	        if(prev_pageno<1){
//			이전 페이지 번호가 1보다 작을 경우		
	        	prev_pageno=1;
//			이전 페이지를 1로
	        }
	        if(next_pageno>totalPage){
//			다음 페이지가 전체페이지 수보다 클경우		
			next_pageno=totalPage/displayPage*displayPage+1;
//			next_pageno=totalpage
//			다음 페이지 = 전체페이지수 / 페이지당 보여줄 번호수 * 페이지당 보여줄 번호수 + 1 
//		ex)			   = 	76 / 5 * 5 + 1	???????? 		
			}     
	    }	
}