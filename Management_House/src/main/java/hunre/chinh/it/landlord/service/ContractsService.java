package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Contracts;
import hunre.chinh.it.landlord.repositories.ContractsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractsService {
  private final ContractsRepository cRepo;

  public ContractsService(ContractsRepository cRepo) {
    this.cRepo = cRepo;
  }

  public void saveContracts(Contracts c) {

    LocalDate currentDate = LocalDate.now();
    if (c.getEndday().isAfter(currentDate.plusMonths(1))) {
      // Gửi thông báo "Đang trong thời hạn hợp đồng"
      c.setStatusContract("Đang trong thời hạn");
    } else if (c.getEndday().isAfter(currentDate) && c.getEndday().isBefore(currentDate.plusMonths(1))) {
      // Gửi thông báo "Đang báo kết thúc"
      c.setStatusContract("Sắp kết thúc");
    } else if (c.getEndday().isEqual(currentDate)) {
    // Gửi thông báo "Đang báo kết thúc"
      c.setStatusContract("Đang báo kết thúc");
    }else if (c.getEndday().isBefore(currentDate)) {
      // Gửi thông báo "Đã quá hạn"
      c.setStatusContract("Đã quá hạn");
    }
    cRepo.save(c);
  }

  public List<Contracts> getAllContracts() {
    return cRepo.findAll();
  }

  public Contracts getContractsById(long idContract) {
    return cRepo.findById(idContract).get();
  }

  public void deleteById(long idContract) {
    cRepo.deleteById(idContract);
  }

  public List<Contracts> getAllContractsByIdHouse(long idHouse) {
    return cRepo.findByHousesIdHouse(idHouse);
  }

  public List<Contracts> searchContracts(String searchTerm, long idHouse) {
    return cRepo.searchContracts(searchTerm, idHouse);
  }
}
