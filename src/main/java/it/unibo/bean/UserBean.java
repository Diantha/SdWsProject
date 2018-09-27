package it.unibo.bean;

//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;

/** Classe di mapping tra db e oggetto ritornato**/
//@XmlRootElement(name = "userB")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(namespace = "it.unibo.bean")
public class UserBean {
	private int idUser;
	private String firstname;
	private String lastname;
	private String taxCode;
	private String birthDate;
	private String gender;
	
	public UserBean() {
		
	}
//	@XmlElementWrapper(name = "idUserList")
//    @XmlElement(name = "idUser")
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
