package vignan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Department;
import vignan.model.Staff;
import vignan.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private DepartmentService departmentService;
	
	
	public Department saveStaff(String branch ,Staff staff)
	{
		Staff newStaff=staffRepository.save(staff);
		return  departmentService.updateDepartmentStaff(branch, newStaff);
	}
	
	public List<Staff> getAllStaff()
	{
		return staffRepository.findAll();
	}
	
	
	public String deleteStaff(int id)
	{
		staffRepository.deleteById(id);
		return "staff deleted";
	}
}
