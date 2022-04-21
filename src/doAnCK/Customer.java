package doAnCK;

public class Customer {
	private String cusID;
	private String name;	
	private String birth;
	private String phone;
	private String mail;
	private String buyApartment;
	
	public Customer(String cusID, String name, String birth, String phone, String mail, String buyApartment) {
		this.name = name;
		this.cusID = cusID;
		this.birth = birth;
		this.phone = phone;
		this.mail = mail;
		this.buyApartment = buyApartment;
	}

	@Override
	public String toString() {
		return "Customer [cusID=" + cusID + ", name=" + name + ", birth=" + birth + ", phone=" + phone + ", mail="
				+ mail + ", buyApartment=" + buyApartment + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCusID() {
		return cusID;
	}

	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBuyApartment() {
		return buyApartment;
	}

	public void setBuyApartment(String buyApartment) {
		this.buyApartment = buyApartment;
	}
	
	
	
}
