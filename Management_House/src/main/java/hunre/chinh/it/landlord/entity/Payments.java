package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private long idPayment;

  @Column(name = "payment_money")
  private BigDecimal moneyPayment;

  @Column(name = "payment_reason")
  private String reasonPayment;

  @Column(name = "create_day_payment")
  private LocalDate createDayPayment;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private Houses houses;
}
