package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Contracts;
import hunre.chinh.it.landlord.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts,Long> {
  List<Contracts> findByHousesIdHouse(long idHouse);

  //@Query(value = "SELECT * FROM Contracts c WHERE c.house_id = :idHouse AND (c.room_id IN (SELECT r.room_id FROM rooms r WHERE r.room_name LIKE %:searchTerm%) OR c.tenant_id IN (SELECT t.tenant_id FROM tenants t WHERE t.name_tenant LIKE %:searchTerm%))", nativeQuery = true)
  //@Query(value = "SELECT c FROM Contracts c JOIN c.rooms r JOIN c.tenants t WHERE c.houses.idHouse = :idHouse AND (r.nameRoom LIKE %:searchTerm% OR t.nameTenant LIKE %:searchTerm%)")
  @Query(value = "SELECT * FROM contracts c WHERE c.house_id = :idHouse AND (c.room_id IN (SELECT r.room_id FROM rooms r WHERE r.room_name LIKE %:searchTerm%) OR c.tenant_id IN (SELECT t.tenant_id FROM tenants t WHERE t.name_tenant LIKE %:searchTerm%) OR c.contract_status LIKE %:searchTerm%)", nativeQuery = true)
  List<Contracts> searchContracts(@Param("searchTerm") String searchTerm, @Param("idHouse") long idHouse);
}
