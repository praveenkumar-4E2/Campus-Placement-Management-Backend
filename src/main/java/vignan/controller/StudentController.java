package vignan.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vignan.model.Department;
import vignan.model.Student;
import vignan.service.StudentService;

@CrossOrigin("http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("student/{branch}")
	public Department addStudent(@PathVariable String branch, @RequestBody Student student)
	{
		return studentService.saveStudent(branch, student);
	}
	
	
	@PutMapping("student/{roll}/{rollNo}")
	public Student addStudentPlacement(@PathVariable String roll, String rollNo)
	{
		return studentService.updatePlacment(roll, rollNo);
	}
	
	
	
	
	@GetMapping("student/name/{Name}")
	public Student findByUserName(@PathVariable String Name) {
        return studentService.getByName(Name);
    }
	
	@GetMapping("student/{rollNo}")
	public Student findbyRoll(@PathVariable String rollNo)
	{
		return studentService.getByUserRollNo(rollNo);
	}
	
	@GetMapping("student")
	public List<Student> findAll()
	{
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("student/{rollNo}")
	public String deleteStudent(@PathVariable String rollNo)
	{
		return studentService.deleteByRollNo(rollNo);
		
	}
	
	@PutMapping("student/update")
	public Student updateStudent(@PathVariable Student student)
	{
		return studentService.update(student);
	}
	
	

}
