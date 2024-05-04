package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facilitys")
public class Facilitys {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "facility_id")
  private long idFacility;

  @Column(name = "facility_name")
  private String nameFacility;

  @Column(name = "facility_price")
  private double priceFacility;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private Houses houses;

//  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "facilitys")
//  private Set<Facilitys> facilitys = new HashSet<>();
}
