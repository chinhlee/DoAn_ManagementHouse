package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "houses")
public class Houses {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "house_id")
  private long idHouse;

  @Column(name = "house_name")
  private String nameHouse;

  @Column(name = "house_address")
  private String addressHouse;

  @Column(name = "house_floor")
  private int floorHouse;

  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
  private List<Rooms> rooms;

  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
  private List<Facilitys> facilitys;

  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
  private List<Tenants> tenants;

  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
  private List<Contracts> contracts;

  @OneToOne(mappedBy = "houses", cascade = CascadeType.ALL)
  private WaterElectricitys waterElectricitys;

//  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
//  private List<Bills> bills;

  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
  private List<Receipts> receipts;

  @OneToMany(mappedBy = "houses", cascade = CascadeType.ALL)
  private List<Payments> payments;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User users;
}
