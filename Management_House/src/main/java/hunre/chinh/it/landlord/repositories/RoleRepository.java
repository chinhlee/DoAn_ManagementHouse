package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
