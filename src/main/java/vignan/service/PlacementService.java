package vignan.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Placement;
import vignan.model.Student;
import vignan.repository.PlacementRepository;
import vignan.repository.StudentRepository;

@Service
public class PlacementService {
	@Autowired
	PlacementRepository placementRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	public Placement addPlacement(Placement placement) {
		return placementRepository.save(placement);
	}
	
	
	public List<Placement> getAll(){
		return placementRepository.findAll();
	}
	
	
	public Placement getByRole(String role) {
		return placementRepository.getByRole(role);
	}
	public String  deletePlacement(int id) {
		placementRepository.deleteById(id);
		return "deleted";
	}
	
	public Placement updatePlacement(String rollNo,Placement placement) {
		Student updateStudent=studentRepository.findByRollNo(rollNo);
		Set<Student> students=placement.getStudent();
		students.add(updateStudent);
		placement.setStudent(students);
		return placementRepository.save(placement);
	}
}
