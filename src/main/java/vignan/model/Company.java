package vignan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
public class Company {
	@Id
	@GeneratedValue
	private int companyId;
	private String companyName;
	private String hrName;
	private String hrMail;
	private String hrMobileNo;
	
	@OneToMany(targetEntity = Placement.class,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "company",referencedColumnName = "companyId")
	private List<Placement> placement;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int companyId, String companyName, String hrName, String hrMail, String hrMobileNo,
			List<Placement> placement) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.hrName = hrName;
		this.hrMail = hrMail;
		this.hrMobileNo = hrMobileNo;
		this.placement = placement;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrMail() {
		return hrMail;
	}

	public void setHrMail(String hrMail) {
		this.hrMail = hrMail;
	}

	public String getHrMobileNo() {
		return hrMobileNo;
	}

	public void setHrMobileNo(String hrMobileNo) {
		this.hrMobileNo = hrMobileNo;
	}

	public List<Placement> getPlacement() {
		return placement;
	}

	public void setPlacement(List<Placement> placement) {
		this.placement = placement;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", hrName=" + hrName + ", hrMail="
				+ hrMail + ", hrMobileNo=" + hrMobileNo + ", placement=" + placement + "]";
	}

	
	
	
}
