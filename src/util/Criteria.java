package util;
/*
 * current page page #, number of items on page
 */
public class Criteria {
	private int pageNum;	//current page#
	private int numPerPage;	//# of items per page 
	
	public Criteria() {
	//	this(1,10);		//default page num=-1, number of items per page -10
		this(1,20);
	}
	
	public Criteria(int pageNum, int numPerPage) {
		this.pageNum  = pageNum;
		this.numPerPage = numPerPage;
	}
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if (pageNum <= 0) {
			pageNum = 1;
		} else {
		this.pageNum = pageNum;
		}
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		if (numPerPage <= 0 || numPerPage > 50) {
			//numPerPage = 10;
			numPerPage=20;
		} else {
		this.numPerPage = numPerPage;
		}
	}
		
		/*
		 * starting number from each page/
		 * returning the item sequence number starting at each page
		 * 1 page has 10. second page starts with 11 
		 * page number(pageNum )-1*(#of items on page=numPerPage)+1=?
		 *  (2)-1*10+1=11
		 */
	public int getPageStart() {
		return (this.pageNum-1) * this.numPerPage + 1;
	}

	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", numPerPage=" + numPerPage + "]";
	}
}
