package vignan.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vignan.model.Department;
import vignan.model.Placement;
import vignan.model.Student;
import vignan.repository.PlacementRepository;
import vignan.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository  studentRepository;
	@Autowired
	private PlacementRepository placementRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	public Department saveStudent(String branch, Student student)
	{
		Student savedStudent= studentRepository.save(student);
		
		return departmentService.updateDepartmentStudent(branch, savedStudent);
	}
	
	public Student getByUserRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }
	
	public Student getByName(String firstName) {
        return studentRepository.findByName(firstName);
    }
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}

	
	public String deleteByRollNo(String rollNo)
	{
		 studentRepository.deleteByRollNo(rollNo);
		return "student "+rollNo + " deleted";

		
	}
	
	
	public Student update(Student student)
	{
		Student existingStudent=studentRepository.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setSection(student.getSection());
		existingStudent.setMarks(student.getMarks());
		existingStudent.setMail(student.getMail());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setMobileNo(student.getMobileNo());
		existingStudent.setPassingYear(student.getPassingYear());
		existingStudent.setPlaced(student.isPlaced());
		return studentRepository.save(existingStudent);
	}
	
	
	//to add placements
	public Student updatePlacment(String offer,String rollNo) {
		Student oldStudent=studentRepository.findByName(rollNo);
		Placement placement=placementRepository.getByRole(offer);
		Set<Placement> placements=oldStudent.getPlacement();
		placements.add(placement);
		oldStudent.setPlacement(placements);
		return studentRepository.save(oldStudent);
		
	}
	
	
	
}
