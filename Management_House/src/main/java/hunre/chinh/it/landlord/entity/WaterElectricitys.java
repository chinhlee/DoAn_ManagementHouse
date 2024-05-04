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
@Table(name = "waterElectricitys")
public class WaterElectricitys {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "water_electricity_id")
  private long idWaterElectricity;

  @Column(name = "electricity_price")
  private double priceElectricity;

  @Column(name = "water_price")
  private double priceWater;

  @OneToOne
  @JoinColumn(name = "house_id")
  private Houses houses;

//  @OneToOne
//  @JoinColumn(name = "bill_id")
//  private Bills bills;
}
