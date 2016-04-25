package yeolsim.service.domain;

import java.sql.Date;


public class Pay {
	
	///Field
	private int payNo;
	private int BuyNo;
	private String payMenu;
	
	public Pay() {
		super();
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public int getBuyNo() {
		return BuyNo;
	}
	public void setBuyNo(int buyNo) {
		BuyNo = buyNo;
	}
	public String getPayMenu() {
		return payMenu;
	}
	public void setPayMenu(String payMenu) {
		this.payMenu = payMenu;
	}
	@Override
	public String toString() {
		return "Pay [payNo=" + payNo + ", BuyNo=" + BuyNo + ", payMenu=" + payMenu + "]";
	}


	
}