package vignan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vignan.model.Placement;


@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {

	Placement getByRole(String role);

}
