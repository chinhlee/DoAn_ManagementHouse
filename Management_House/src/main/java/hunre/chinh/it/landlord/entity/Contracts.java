package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contracts")
public class Contracts {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "contract_id")
  private long idContract;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private Houses houses;

  @OneToOne
  @JoinColumn(name = "room_id")
  private Rooms rooms;

  @OneToOne
  @JoinColumn(name = "tenant_id")
  private Tenants tenants;

  @Column(name = "start_day")
  private LocalDate startday;

  @Column(name = "end_day")
  private LocalDate endday;

  @Column(name = "contract_status")
  private String statusContract;
}
