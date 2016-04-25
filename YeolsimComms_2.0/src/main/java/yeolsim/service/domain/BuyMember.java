package yeolsim.service.domain;

public class BuyMember {
	
	///Field
	private int buyNo;
	private String name;
	private String phone;
	private String addr;
	
	///Constructor
	public BuyMember(){
	}
	
	public int getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(int buyNo) {
		this.buyNo = buyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "BuyMember [buyNo=" + buyNo + ", name=" + name + ", phone=" + phone
				+ ", addr=" + addr + "]";
	}
}