package vignan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Department;
import vignan.model.Staff;
import vignan.model.Student;
import vignan.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Department> getall()
	{
		return departmentRepository.findAll();
	}
	
	
	
	public Department getByDepartmentName(String branch) {
		return departmentRepository.findBydepartmentName(branch);
	}
	
	public String  deleteDepartment(Integer id) {
		departmentRepository.deleteById(id);
		return "deleted";
	}
	
	public Department updateDepartmentStudent(String branch , Student student) {
		Department newDepartment=getByDepartmentName(branch);
		List<Student> newStudents=newDepartment.getStudent();
		newStudents.add(student);
		newDepartment.setStudent(newStudents);
		return departmentRepository.save(newDepartment);
	}
	
	public Department updateDepartmentStaff(String branch , Staff staff) {
		Department newDepartment=getByDepartmentName(branch);
		List<Staff> newStaff=newDepartment.getStaff();
		newStaff.add(staff);
		newDepartment.setStaff(newStaff);
		return departmentRepository.save(newDepartment);
	}
	
	public HashMap<String, Integer>  departmentPlacementCount()
	{
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		List<Department> departments=getall();
		departments.forEach(depart -> map.put(depart.getDepartmentName(), 
				(int) depart.getStudent().stream().filter(i->i.isPlaced()==true).count()));
		
		return map;
	}
	
	public int totalPlacements()
	{
		int placments = 0;
		HashMap<String, Integer> map=departmentPlacementCount();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			placments+=entry.getValue();
			
		}
		return placments;
		
	}
	
	//section wise placements
	public HashMap<String, Integer> sectionPlacements(String branch)
	{
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		Department d=getByDepartmentName(branch);
		List<Student> std=d.getStudent();
		for(Student s : std)
		{
			map.put(s.getSection(),
					(int) std.stream().filter(i->i.getSection()==s.getSection()).map(i->i.isPlaced()).count()
					
					);
		}
		
		return map;
		
	}
	
	
}

