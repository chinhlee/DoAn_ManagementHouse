package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Payments;
import hunre.chinh.it.landlord.entity.Receipts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepository  extends JpaRepository<Payments,Long> {
  List<Payments> findByHousesIdHouse(long idHouse);
  @Query(value = "SELECT * FROM payments p WHERE p.house_id = :idHouse AND DATE_FORMAT(p.create_day_payment, '%m-%Y') = :searchTerm", nativeQuery = true)
  List<Payments> searchPayments(@Param("searchTerm") String searchTerm, @Param("idHouse") long idHouse);
}
