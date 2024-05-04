package hunre.chinh.it.landlord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipts {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "receipt_id")
  private long idReceipt;

  @Column(name = "receipt_money")
  private BigDecimal moneyReceipt;

  @Column(name = "receipt_reason")
  private String reasonReceipt;

  @Column(name = "create_day_receipt")
  private LocalDate createDayReceipt;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private Houses houses;

}
