package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.WaterElectricitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterElectricitysRepository extends JpaRepository<WaterElectricitys, Long> {

  List<WaterElectricitys> findByHousesIdHouse(long idHouse);

  List<WaterElectricitys> findByIdWaterElectricityAndHousesIdHouse(long idWaterElectricity, long idHouse);
}
