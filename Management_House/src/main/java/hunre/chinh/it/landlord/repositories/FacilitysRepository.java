package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Facilitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilitysRepository extends JpaRepository<Facilitys,Long> {
  List<Facilitys> findByHousesIdHouse(long idHouse);

 // List<Facilitys> findByNameFacilityAndIdHouse(String nameFacility, long idHouse);

  List<Facilitys> findByNameFacilityAndHousesIdHouse(String nameFacility, long idHouse);

//  List<Facilitys> findByNameFacility(String nameFacility, long idHouse);
//
//  List<Facilitys> findByIdHouseAndNameFacility(String nameFacility, long idHouse);
}
