package hunre.chinh.it.landlord.repositories;


import hunre.chinh.it.landlord.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
