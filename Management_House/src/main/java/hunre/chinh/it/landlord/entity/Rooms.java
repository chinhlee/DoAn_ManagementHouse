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
@Table(name = "rooms")
public class Rooms {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "room_id")
  private long idRoom;

  @Column(name = "room_name")
  private String nameRoom;

  @Column(name = "room_floor")
  private String floorRoom;

  @Column(name = "room_type")
  private String type;

  @Column(name = "room_acreage")
  private double acreage;

  @Column(name = "room_price")
  private double priceRoom;

  @Column(name = "room_deposit")
  private double deposit;

  @Column(name = "room_people")
  private int people;

  @Column(name = "room_status")
  private String statusRoom;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private Houses houses;

  @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
  private List<Tenants> tenants;

  @OneToOne(mappedBy = "rooms", cascade = CascadeType.ALL)
  private Contracts contracts;

//  @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
//  private List<Bills> bills;
}
