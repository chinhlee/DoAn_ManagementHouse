package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.WaterElectricitys;
import hunre.chinh.it.landlord.repositories.WaterElectricitysRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterElectricitysService {
  private final WaterElectricitysRepository wRepo;

  public WaterElectricitysService(WaterElectricitysRepository wRepo) {
    this.wRepo = wRepo;
  }

  public void saveWaterElectricitys(WaterElectricitys w) {
    wRepo.save(w);
  }

  public List<WaterElectricitys> getAllWaterElectricitys() {
    return wRepo.findAll();
  }

  public WaterElectricitys getWaterElectricitysById(long idWaterElectricity) {
    return wRepo.findById(idWaterElectricity).get();
  }

  public void deleteById(long idWaterElectricity) {
    wRepo.deleteById(idWaterElectricity);
  }

  public List<WaterElectricitys> getAllWaterElectricitysByIdHouse(long idHouse) {
    return wRepo.findByHousesIdHouse(idHouse);
  }

  public double getPriceElectricityByIdWaterElectricity(Long idWaterElectricity) {
    WaterElectricitys waterElectricitys = wRepo.findById(idWaterElectricity).orElse(null);
    if (waterElectricitys != null) {
      return waterElectricitys.getPriceElectricity();
    } else {
      // Xử lý khi không tìm thấy phòng
      return 0.0;
    }
  }
  public double getPriceWaterByIdWaterElectricity(Long idWaterElectricity) {
    WaterElectricitys waterElectricitys = wRepo.findById(idWaterElectricity).orElse(null);
    if (waterElectricitys != null) {
      return waterElectricitys.getPriceWater();
    } else {
      // Xử lý khi không tìm thấy phòng
      return 0.0;
    }
  }

  public List<WaterElectricitys> getWaterElectricitysByIdWaterElectricity(long idWaterElectricity, long idHouse) {
    return wRepo.findByIdWaterElectricityAndHousesIdHouse(idWaterElectricity,idHouse);
  }
}
