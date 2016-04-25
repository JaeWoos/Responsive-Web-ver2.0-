package yeolsim.service.domain;

public class Member {
	
	///Field
	private int memberNo;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String sex;
	private String addr;
	
	///Constructor
	public Member(){
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", sex=" + sex + ", addr=" + addr + "]";
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	

}