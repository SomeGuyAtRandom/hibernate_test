package la.random.hibernate.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="joined")
	private Date joinedDate;
	
	//@Embedded
	//@AttributeOverride(name="street",column=@Column(name="street_name"))
	//private Address address;
	
	@ElementCollection
	private Set<Address>addresses = new HashSet<Address>();
	
	
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Lob
	private String discription;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	public Address getAddress() {
//		return address;
//	}
//	
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public String getDiscription() {
		return discription;
	}
	
	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
