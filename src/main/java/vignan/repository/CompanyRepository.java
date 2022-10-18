package vignan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vignan.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
