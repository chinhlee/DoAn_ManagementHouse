package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Rooms;
import hunre.chinh.it.landlord.entity.Tenants;
import hunre.chinh.it.landlord.repositories.TenantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantsService {
  private final TenantsRepository tRepo;

  public TenantsService(TenantsRepository tRepo) {
    this.tRepo = tRepo;
  }

  public void saveTenants(Tenants t) {
    tRepo.save(t);
  }

  public List<Tenants> getAllTenants() {
    return tRepo.findAll();
  }

  public Tenants getTenantsById(long idTenant) {
    return tRepo.findById(idTenant).get();
  }

  public void deleteById(long idTenant) {
    tRepo.deleteById(idTenant);
  }

  public List<Tenants> getAllTenantsByIdHouse(long idHouse) {
    return tRepo.findByHousesIdHouse(idHouse);
  }

//  public List<Tenants> getTenantsByIdRoom(long idRoom) {
//    return tRepo.findByRoomsIdRoom(idRoom);
//  }

  public List<Tenants> getTenantsByIdHouse(long idHouse) {
    return tRepo.findByHousesIdHouse(idHouse);
  }


  public List<Tenants> searchTenants(String searchTerm, long idHouse) {
    return tRepo.searchTenants(searchTerm, idHouse);
  }
}
