package yeolsim.service.domain;

import java.sql.Date;


public class Product {
	
	///Field
	private int prodNo;
	private int memberNo;
	private String prodName;
	private int price;
	private String info;
	private String pic;
	private Date data;
	private String stat;
	private String cate;

	///Constructor
	public Product(){
	}

	public String getStat() {
		return stat;
	}
	
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	public String getCate() {
		return cate;
	}
	
	public void setCate(String cate) {
		this.cate = cate;
	}
	
	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getDate() {
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
	}

	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", memberNo=" + memberNo + ", prodName=" + prodName + ", price=" + price
				+ ", info=" + info + ", pic=" + pic + ", date=" + data + ", stat=" + stat + ", cate=" + cate + "]";
	}

}