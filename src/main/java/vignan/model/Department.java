package vignan.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
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
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int departmentId;
	//@Column(unique = true)
	private  String departmentName;
	private String departmentHead;
	private String departmentCoordinator;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name = "st_dpfk",referencedColumnName = "id")
//	List<Student> student =new ArrayList<Student>();
	
	@OneToMany(targetEntity = Student.class,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "department",referencedColumnName = "departmentId")
	
	private List<Student> student;
	
	@OneToMany(targetEntity = Staff.class,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "department",referencedColumnName = "departmentId")
	
	private List<Staff> staff;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentId, String departmentName, String departmentHead, String departmentCoordinator,
			List<Student> student, List<Staff> staff) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentHead = departmentHead;
		this.departmentCoordinator = departmentCoordinator;
		this.student = student;
		this.staff = staff;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public String getDepartmentCoordinator() {
		return departmentCoordinator;
	}

	public void setDepartmentCoordinator(String departmentCoordinator) {
		this.departmentCoordinator = departmentCoordinator;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentHead="
				+ departmentHead + ", departmentCoordinator=" + departmentCoordinator + ", student=" + student
				+ ", staff=" + staff + "]";
	}
	
	
	
	
	

}
