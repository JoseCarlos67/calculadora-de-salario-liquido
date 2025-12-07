package service.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InssCalculationService {
  // TABELA INSS 2025
  private static final BigDecimal BAND_LIMIT_1 = BigDecimal.valueOf(1518);
  private static final BigDecimal BAND_LIMIT_2 = BigDecimal.valueOf(2793.88);
  private static final BigDecimal BAND_LIMIT_3 = BigDecimal.valueOf(4190.83);

  private static final BigDecimal TAX_RANGE_1 = BigDecimal.valueOf(0.075);
  private static final BigDecimal TAX_RANGE_2 = BigDecimal.valueOf(0.09);
  private static final BigDecimal TAX_RANGE_3 = BigDecimal.valueOf(0.12);
  private static final BigDecimal TAX_RANGE_4 = BigDecimal.valueOf(0.14);

  private static final BigDecimal DEDUCTION_1 = BigDecimal.valueOf(0);
  private static final BigDecimal DEDUCTION_2 = BigDecimal.valueOf(22.77);
  private static final BigDecimal DEDUCTION_3 = BigDecimal.valueOf(106.59);
  private static final BigDecimal DEDUCTION_4 = BigDecimal.valueOf(190.40);

  public BigDecimal calculate(BigDecimal grossSalary) {
    if (grossSalary.compareTo(BAND_LIMIT_1) <= 0) {
      BigDecimal result = grossSalary.multiply(TAX_RANGE_1).subtract(DEDUCTION_1);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else if (grossSalary.compareTo(BAND_LIMIT_1) > 0 && grossSalary.compareTo(BAND_LIMIT_2) <= 0) {
      BigDecimal result = grossSalary.multiply(TAX_RANGE_2).subtract(DEDUCTION_2);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else if (grossSalary.compareTo(BAND_LIMIT_2) > 0 && grossSalary.compareTo(BAND_LIMIT_3) <= 0) {
      BigDecimal result = grossSalary.multiply(TAX_RANGE_3).subtract(DEDUCTION_3);
      return result.setScale(2, RoundingMode.HALF_UP);
    } else {
      BigDecimal result = grossSalary.multiply(TAX_RANGE_4).subtract(DEDUCTION_4);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
  }
}
