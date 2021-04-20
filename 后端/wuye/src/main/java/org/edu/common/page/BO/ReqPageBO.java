package org.edu.common.page.BO;

/** <br>
 * 标题: 分页查询继承基类<br>
 * 描述: <br>
 * 公司: www.tydic.com<br>
*/
public class ReqPageBO {

	/**  */
	private static final long serialVersionUID = -7485827693286591127L;

	/** 第几页 */
	private int				  pageNo		   = 1;
	/** 每页的数量 */
	private int				  pageSize		   = 15;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "ReqPageBO [pageNo=" + pageNo + ", pageSize=" + pageSize + "]" + super.toString();
	}

}
