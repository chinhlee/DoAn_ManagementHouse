package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Receipts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptsRepository extends JpaRepository<Receipts,Long> {
  List<Receipts> findByHousesIdHouse(long idHouse);
  //@Query(value = "SELECT * FROM receipts re WHERE re.house_id = :idHouse AND MONTH(re.create_day_receipt) LIKE %:searchTerm% AND YEAR(re.create_day_receipt) LIKE %:searchTerm%", nativeQuery = true)
  @Query(value = "SELECT * FROM receipts re WHERE re.house_id = :idHouse AND DATE_FORMAT(re.create_day_receipt, '%m-%Y') = :searchTerm", nativeQuery = true)
  List<Receipts> searchReceipts(@Param("searchTerm") String searchTerm, @Param("idHouse") long idHouse);
}
