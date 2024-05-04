package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Facilitys;
import hunre.chinh.it.landlord.repositories.FacilitysRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FacilitysService {
  private final FacilitysRepository fRepo;

  public FacilitysService(FacilitysRepository fRepo) {
    this.fRepo = fRepo;
  }

  public void saveFacilitys(Facilitys f) {
    fRepo.save(f);
  }

  public List<Facilitys> getAllFacilitys() {
    return fRepo.findAll();
  }

  public Facilitys getFacilitysById(long idFacility) {
    return fRepo.findById(idFacility).get();
  }

  public void deleteById(long idFacility) {
    fRepo.deleteById(idFacility);
  }

  public List<Facilitys> getAllFacilitysByIdHouse(long idHouse) {
    return fRepo.findByHousesIdHouse(idHouse);
  }

  public List<Facilitys> getFacilitysByNameFacility(String nameFacility, long idHouse) {
    return fRepo.findByNameFacilityAndHousesIdHouse(nameFacility,idHouse);
  }


//  public List<Facilitys> getFacilitysByHousesAndNameFacility(String nameFacility, long idHouse) {
//    return fRepo.findByIdHouseAndNameFacility(nameFacility,idHouse);
//  }

//  public double getTotalFacilityPrice(Set<Facilitys> facilitys) {
//    double totalFacilityPrice = 0;
//    for (Facilitys facility : facilitys) {
//      totalFacilityPrice += facility.getPriceFacility();
//    }
//    return totalFacilityPrice;
//  }
}
