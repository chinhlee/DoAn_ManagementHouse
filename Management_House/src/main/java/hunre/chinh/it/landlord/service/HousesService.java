package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.repositories.HousesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousesService {
  private final HousesRepository hRepo;

  public HousesService(HousesRepository hRepo) {
    this.hRepo = hRepo;
  }

  public void saveHouses(Houses h) {
    hRepo.save(h);
  }

  public List<Houses> getAllHouses() {
    return hRepo.findAll();
  }

  public Houses getHousesById(long idHouse) {
    return hRepo.findById(idHouse).get();
  }

  public void deleteById(long idHouse) {
    hRepo.deleteById(idHouse);
  }

  public List<Houses> getHousesByNameHouse(String nameHouse) {
    return hRepo.findByNameHouse(nameHouse);
  }

//  public List<Houses> findHousesByUserId(Long id) {
//    return hRepo.findHousesByUserId(id);
//  }


//  public List<Houses> getHousesByUserId(Long id) {
//    return hRepo.findByUserId(id);
//  }

}
