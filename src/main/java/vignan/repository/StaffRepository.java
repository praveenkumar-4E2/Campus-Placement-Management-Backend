package vignan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vignan.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
