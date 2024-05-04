package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantsRepository extends JpaRepository<Tenants,Long> {
  List<Tenants> findByHousesIdHouse(long idHouse);
  @Query(value = "SELECT * FROM tenants t WHERE t.house_id = :idHouse AND (t.name_tenant LIKE %:searchTerm% OR t.room_id IN (SELECT r.room_id FROM rooms r WHERE r.room_name LIKE %:searchTerm%))", nativeQuery = true)
  List<Tenants> searchTenants(@Param("searchTerm") String searchTerm, @Param("idHouse") long idHouse);

}
