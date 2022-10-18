package vignan.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Placement implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int placementId;
	private String salary;
	private String role;
	private Date placedDate;
	
	
	
//	@ManyToMany(fetch = FetchType.LAZY,
//		    
//		      mappedBy = "placement")
//		  @JsonIgnore
	
	@ManyToMany(fetch = FetchType.LAZY )
	  @JoinTable(name = "student_placement",
	        joinColumns = { @JoinColumn(name = "placement_id", referencedColumnName = "placementId",insertable = false,updatable = false) },
	        inverseJoinColumns = { @JoinColumn(name = "student_id") })
	
		  
		  private Set<Student> student = new HashSet<>();

	public Placement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Placement(int placementId, String salary, String role, Date placedDate, Set<Student> student) {
		super();
		this.placementId = placementId;
		this.salary = salary;
		this.role = role;
		this.placedDate = placedDate;
		
		this.student = student;
	}

	public int getPlacementId() {
		return placementId;
	}

	public void setPlacementId(int placementId) {
		this.placementId = placementId;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Placement [placementId=" + placementId + ", salary=" + salary + ", role=" + role + ", placedDate="
				+ placedDate + ", company="  +", student=" + student + "]";
	}
	
	
	

}
