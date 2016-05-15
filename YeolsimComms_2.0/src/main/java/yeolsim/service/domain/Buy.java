package yeolsim.service.domain;

import java.sql.Date;


public class Buy {
	
	///Field
	private int buyNo;
	private int memberNo;
	private int prodNo;
	private int tranNo;
	private Date data;
	private Product buyProd;

	///Constructor
	public Buy(){
	}

	public Product getBuyProd() {
		return buyProd;
	}

	public void setBuyProd(Product buyProd) {
		this.buyProd = buyProd;
	}

	public int getBuyNo() {
		return buyNo;
	}


	public void setBuyNo(int buyNo) {
		this.buyNo = buyNo;
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
	
	public int getTranNo() {
		return tranNo;
	}

	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Buy [buyNo=" + buyNo + ", memberNo=" + memberNo + ", prodNo=" + prodNo + ", tranNo=" + tranNo
				+ ", data=" + data + ", buyProd=" + buyProd + "]";
	}

	
}