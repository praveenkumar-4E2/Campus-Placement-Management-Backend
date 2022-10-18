package vignan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import vignan.model.Department;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	public Department findBydepartmentName(String branch);
}
