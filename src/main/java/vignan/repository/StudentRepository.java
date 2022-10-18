package vignan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vignan.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByRollNo(String rollNo);
	Student findByName(String firstName);
	String deleteByRollNo(String rollNo);


}

