package hunre.chinh.it.landlord.repositories;

import hunre.chinh.it.landlord.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms,Long> {
  List<Rooms> findByHousesIdHouse(long houseId);
  //@Query(value ="SELECT * FROM Rooms r WHERE r.room_name LIKE %:searchTerm% OR r.room_floor LIKE %:searchTerm% OR r.room_type LIKE %:searchTerm% OR r.room_price LIKE %:searchTerm% OR r.room_status LIKE %:searchTerm%", nativeQuery = true)
  //@Query(value="SELECT r FROM Rooms r WHERE r.room_name LIKE %:name% OR r.room_floor = :floor OR r.room_type = :roomType OR r.room_price = :price OR r.room_status = :status", nativeQuery = true)
  //List<Rooms> searchRooms(@Param("name") String name, @Param("floor") int floor, @Param("roomType") String roomType, @Param("price") double price, @Param("status") String status);
  @Query(value ="SELECT * FROM Rooms r WHERE r.house_id = :idHouse AND (r.room_name LIKE %:searchTerm% OR r.room_floor = :searchTerm OR r.room_type LIKE %:searchTerm% OR r.room_price LIKE %:searchTerm% OR r.room_status LIKE %:searchTerm%)", nativeQuery = true)
  List<Rooms> searchRooms(@Param("searchTerm") String searchTerm, @Param("idHouse") long idHouse);
//  double findPriceRoomByIdRoom(long idRoom);
}
