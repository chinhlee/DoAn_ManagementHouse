package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Facilitys;
import hunre.chinh.it.landlord.entity.Receipts;
import hunre.chinh.it.landlord.repositories.FacilitysRepository;
import hunre.chinh.it.landlord.repositories.ReceiptsRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ReceiptsService {
  private final ReceiptsRepository reRepo;
  public ReceiptsService(ReceiptsRepository reRepo) {
    this.reRepo = reRepo;
  }

  public void saveReceipts(Receipts re) {
    reRepo.save(re);
  }

  public List<Receipts> getAllReceipts() {
    return reRepo.findAll();
  }

  public Receipts getReceiptsById(long idReceipt) {
    return reRepo.findById(idReceipt).get();
  }

  public void deleteById(long idReceipt) {
    reRepo.deleteById(idReceipt);
  }

  public List<Receipts> getAllReceiptsByIdHouse(long idHouse) {
    return reRepo.findByHousesIdHouse(idHouse);
  }

  public List<Receipts> searchReceipts(String searchTerm, long idHouse) {
    return reRepo.searchReceipts(searchTerm, idHouse);
  }



}
