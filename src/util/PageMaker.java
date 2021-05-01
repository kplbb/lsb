package util;
/*
 * class that has page/paging buttons function
 */
public class PageMaker {
	private Criteria cri;	//save current page info 
	
	private int totalCount;		//total items of blog,q&a,posts of page 
	private int startPage; 		//# of the starting page
	private int endPage;		//# of ending page (for calculation)
	private boolean prev;		//need previous button? true or false
	private boolean next;		//need next button? true or false
	
	private int displayPageNum=10;		//# of page buttons to display on screen
	private int realEndPage;		//actual last page # according to total # of items 
/*
 * if total items=125, current page=5, #page buttons=10
 * ceil(current page=5/#page bttns=10)==  ceil(5/10)=1
 * end_page = ceil(5 starting page/10 items per page) * #of page bttns 10 = 10
 * ex: 13/10 * 10 =  20
 * start_page 11 = end_page(20 from ex) - # of page bttns + 1 
 * ceil() =nearest int round up
 */ 
	
	//method to determine page info(input parameter: totalCount=total # of posts/items)
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		memberInitialize();
	}
	
	//member variable initialize/constructor method
	public void memberInitialize() {
		//last page # calculation
		//(current page# / # of bttns) * # of pages 
		this.endPage =  (int)(Math.ceil(cri.getPageNum() / (double)displayPageNum) 
						* displayPageNum);
		//start page # calculation
		//endParge - # bttns + 1
		this.startPage = endPage - displayPageNum + 1;
		
		//calculate actual endPage # according to total # of posts
		realEndPage = (int)Math.ceil(totalCount / (double)cri.getNumPerPage());  
		
		//edit endPage according to realEndPage(from above) 
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		prev = (startPage == 1 ? false:true);  //if startPage==1, no <previous> bttn
		next = (endPage * cri.getNumPerPage() >= totalCount ? false:true);  //if end page is bigger or same as total# of items, no <next> bttn
		
	}
	/*
	 * input parameter variables: 
	 * 		page: page number to be printed 
	 * 	print: create QueryString that transmits current page# and # of entries per page to server
	 * ?pageNum=3&numPerPage=10
	 */
	public String makeQuery(int page) {     //used in pagearea.jsp
		return "&pageNum=" + page + "&numPerPage=" + cri.getNumPerPage();
	 	}
	public Criteria getCri() {
		return cri;
	}
	
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	public int getStartPage() {
		return startPage;
	}
	
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	
	public int getEndPage() {
		return endPage;
	}
	
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
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
	
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	
	public int getRealEndPage() {
		return realEndPage;
	}
	
	
	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}
	
	
	public int getTotalCount() {
		return totalCount;
	}
	
	@Override
	public String toString() {
		return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
				+ ", realEndPage=" + realEndPage + "]";
	}
}

