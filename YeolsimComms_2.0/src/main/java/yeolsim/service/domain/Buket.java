package yeolsim.service.domain;

import java.sql.Date;


public class Buket {
	
	///Field
	private int totalBuy;
	private int memberNo;
	private int prodNo;
	private int count;
	
	
	///Constructor
	public Buket(){
	}

	public int getTotalBuy() {
		return totalBuy;
	}

	public void setTotalBuy(int totalBuy) {
		this.totalBuy = totalBuy;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Buket [totalBuy=" + totalBuy + ", memberNo=" + memberNo + ", prodNo=" + prodNo + ", count=" + count
				+ "]";
	}

	
}