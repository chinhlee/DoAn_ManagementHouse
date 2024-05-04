package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.entity.Rooms;
import hunre.chinh.it.landlord.repositories.RoomsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService {
  private final RoomsRepository rRepo;

  public RoomsService(RoomsRepository rRepo) {
    this.rRepo = rRepo;
  }

  public void saveRooms(Rooms r) {
    r.setStatusRoom(r.getPeople() > 0 ? "Đang ở" : "Đang trống");
    rRepo.save(r);
  }

  public List<Rooms> getAllRooms() {
    return rRepo.findAll();
  }

  public Rooms getRoomsById(long idRoom) {
    return rRepo.findById(idRoom).get();
  }

  public void deleteById(long idRoom) {
    rRepo.deleteById(idRoom);
  }

//  public double findPriceRoomByIdRoom(long idRoom) {
//    return rRepo.findPriceRoomByIdRoom(idRoom);
//  }
  public double getPriceRoomByIdRoom(Long idRoom) {
    Rooms rooms = rRepo.findById(idRoom).orElse(null);
    if (rooms != null) {
      return rooms.getPriceRoom();
    } else {
      // Xử lý khi không tìm thấy phòng
      return 0.0;
    }
  }
  public int getPeopleByIdRoom (Long idRoom){
      Rooms room = rRepo.findById(idRoom).orElse(null);
      return room != null ? room.getPeople() : 0; // hoặc giá trị mặc định tùy vào logic của bạn
  }


  public List<Rooms> getAllRoomsByIdHouse(long idHouse) {
    return rRepo.findByHousesIdHouse(idHouse);
  }

  public List<Rooms> getRoomsByIdHouse(long idHouse) {
    return rRepo.findByHousesIdHouse(idHouse);
  }

  public List<Rooms> searchRooms(String searchTerm, long idHouse) {
    return rRepo.searchRooms(searchTerm, idHouse);
  }
}
