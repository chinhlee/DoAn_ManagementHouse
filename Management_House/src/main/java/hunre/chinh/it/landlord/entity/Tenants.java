package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenants")
public class Tenants {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tenant_id")
  private long idTenant;

  @Column(name = "cccd_tenant")
  private String cccdTenant;

  @Column(name = "name_tenant")
  private String nameTenant;

  @Column(name = "gender_tenant")
  private String genderTenant;

  @Column(name = "birthday_tenant")
  private String birthdayTenant;

  @Column(name = "country")
  private String country;

  @Column(name = "job")
  private String job;

  @Column(name = "phone_tenant")
  private String phoneTenant;

  @ManyToOne
  @JoinColumn(name = "room_id")
  private Rooms rooms;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private Houses houses;

  @OneToOne(mappedBy = "tenants", cascade = CascadeType.ALL)
  private Contracts contracts;
}
