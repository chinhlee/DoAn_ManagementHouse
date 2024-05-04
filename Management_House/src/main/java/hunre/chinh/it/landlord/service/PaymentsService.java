package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Payments;
import hunre.chinh.it.landlord.repositories.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {
  private final PaymentsRepository pRepo;
  public PaymentsService(PaymentsRepository pRepo) {
    this.pRepo = pRepo;
  }

  public void savePayments(Payments p) {
    pRepo.save(p);
  }

  public List<Payments> getAllPayments() {
    return pRepo.findAll();
  }

  public Payments getPaymentsById(long idPayment) {
    return pRepo.findById(idPayment).get();
  }

  public void deleteById(long idPayment) {
    pRepo.deleteById(idPayment);
  }

  public List<Payments> getAllPaymentsByIdHouse(long idHouse) {
    return pRepo.findByHousesIdHouse(idHouse);
  }

  public List<Payments> searchPayments(String searchTerm, long idHouse) {
    return pRepo.searchPayments(searchTerm, idHouse);
  }
}
