package hunre.chinh.it.landlord.service;

import org.springframework.stereotype.Service;

@Service
public class BillsService {
//  @Autowired
//  private BillsRepository bRepo;
//
//  @Autowired
//  private RoomsService roomsService;
//
//  @Autowired
//  private WaterElectricitysService waterElectricitysService;
//
//  @Autowired
//  private FacilitysService facilitysService;

//  public BillsService(BillsRepository bRepo, RoomsService roomsService, WaterElectricitysService waterElectricitysService, FacilitysService facilitysService) {
//    this.bRepo = bRepo;
//    this.roomsService = roomsService;
//    this.waterElectricitysService = waterElectricitysService;
//    this.facilitysService = facilitysService;
//  }
//
////  public void saveBills(Bills b) {
////    bRepo.save(b);
////  }
//
//  public List<Bills> getAllBills() {
//    return bRepo.findAll();
//  }
//
//  public Bills getBillsById(long idBill) {
//    return bRepo.findById(idBill).get();
//  }
//
//  public void deleteById(long idBill) {
//    bRepo.deleteById(idBill);
//  }
//
//  public void saveBills(Bills b) {
//    // Tính toán các giá trị của hóa đơn trước khi lưu vào cơ sở dữ liệu
//    calculateBillValues(b);
//    bRepo.save(b);
//  }
//
//  public void calculateBillValues(Bills b) {
//    // Lấy giá trị từ các bảng khác
//    Long idRoom = b.getRooms().getIdRoom();
//    Long idWaterElectricity = b.getWaterElectricitys().getIdWaterElectricity();
//    double roomPrice = roomsService.getPriceRoomByIdRoom(idRoom);
//    int numberOfPeople = roomsService.getPeopleByIdRoom(idRoom);
//    double electricityPrice = waterElectricitysService.getPriceElectricityByIdWaterElectricity(idWaterElectricity);
//    double waterPrice = waterElectricitysService.getPriceWaterByIdWaterElectricity(idWaterElectricity);
//
//    // Tính tổng tiền dịch vụ
//    double facilityFee = 0.0;
//    for (Facilitys facilitys : b.getFacilitys()) {
//      facilityFee += facilitys.getPriceFacility();
//    }
//    // Thực hiện tính toán giá trị hóa đơn
//    // Ví dụ:
//    double roomFee = roomPrice;
//    double electricityFee = (b.getNewIndex() - b.getOldIndex()) * electricityPrice;
//    double waterFee = b.getNumberOfPeople() * waterPrice;
//    double totalFee = roomFee + electricityFee + waterFee + facilityFee;
//
//
//    // Set các giá trị đã tính vào hóa đơn
//    b.setRoomFee(roomFee);
//    b.setElectricityFee(electricityFee);
//    b.setWaterFee(waterFee);
//    b.setFacilityFee(facilityFee);
//    b.setTotalFee(totalFee);
//  }
//
//  public List<Bills> getAllBillsByIdHouse(long idHouse) {
//    return bRepo.findByHousesIdHouse(idHouse);
//  }
}
