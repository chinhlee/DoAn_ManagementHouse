package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "bills")
public class Bills {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "bill_id")
//  private long idBill;
//
//  @ManyToOne
//  @JoinColumn(name = "house_id")
//  private Houses houses;
//
//  @ManyToOne
//  @JoinColumn(name = "room_id")
//  private Rooms rooms;
//
//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(name = "bills_facilitys",
//      joinColumns = @JoinColumn(name = "bill_id"),
//      inverseJoinColumns = @JoinColumn(name = "facility_id"))
//  private Set<Facilitys> facilitys = new HashSet<>();
//
//
//  @OneToOne(mappedBy = "bills", cascade = CascadeType.ALL)
//  private WaterElectricitys waterElectricitys;
//
//  @Column(name = "room_fee")
//  private double roomFee;
//
//  @Column(name = "electricity_old_index")
//  private int oldIndex;
//
//  @Column(name = "electricity_new_index")
//  private int newIndex;
//
//  @Column(name = "electricity_fee")
//  private double electricityFee;
//
//  @Column(name = "number_of_people")
//  private int numberOfPeople;
//
//  @Column(name = "water_fee")
//  private double waterFee;
//
//  @Column(name = "facility_fee")
//  private double facilityFee;
//
//  @Column(name = "total_fee")
//  private double totalFee;
//
//  @Column(name = "bill_create_day")
//  private String createDayBill;
//
//  @Column(name = "bill_status")
//  private String statusBill;

//  public Bills() {
//    // Khởi tạo ngày lập hóa đơn là ngày hiện tại
//    //this.createdDate = LocalDate.now();
//    // Mặc định trạng thái là "Chưa thanh toán"
//    this.statusBill = "Chưa thanh toán";
//  }
}
