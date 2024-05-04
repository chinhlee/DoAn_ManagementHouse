package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Houses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousesRepository extends JpaRepository<Houses,Long> {
  List<Houses> findByNameHouse(String nameHouse);
//  List<Houses> findHousesByUserId(Long id);
}
