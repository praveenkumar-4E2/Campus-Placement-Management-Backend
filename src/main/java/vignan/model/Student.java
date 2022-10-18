package vignan.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String rollNo;
	private String name;
	private String section;
	private String marks;
	private String mail;
	private String mobileNo;
	private String address;
	private String passingYear;
	private boolean placed;
	
	
	
//	@ManyToMany(fetch = FetchType.LAZY )
//	  @JoinTable(name = "student_placement",
//	        joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id",insertable = false,updatable = false) },
//	        inverseJoinColumns = { @JoinColumn(name = "placement_id") })
//	
	
	@ManyToMany(fetch = FetchType.LAZY,
    
    mappedBy = "student")
@JsonIgnore
		  private Set<Placement> placement = new HashSet<>();
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String rollNo, String name, String section, String marks, String mail, String mobileNo,
			String address, String passingYear, boolean placed, 
			Set<Placement> placement) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.section = section;
		this.marks = marks;
		this.mail = mail;
		this.mobileNo = mobileNo;
		this.address = address;
		this.passingYear = passingYear;
		this.placed = placed;
		
		this.placement = placement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}

	

	public Set<Placement> getPlacement() {
		return placement;
	}

	public void setPlacement(Set<Placement> placement) {
		this.placement = placement;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", name=" + name + ", section=" + section + ", marks="
				+ marks + ", mail=" + mail + ", mobileNo=" + mobileNo + ", address=" + address + ", passingYear="
				+ passingYear + ", placed=" + placed + ", department=" + ", placement=" + placement + "]";
	}

	
	
	
	

}





