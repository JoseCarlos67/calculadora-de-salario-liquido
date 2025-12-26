package service.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IrrfCalculationService implements DeductionService {
  // TABELA IRRF 2025
  private static final BigDecimal BAND_LIMIT_1 = BigDecimal.valueOf(2259.20);
  private static final BigDecimal BAND_LIMIT_2 = BigDecimal.valueOf(2826.65);
  private static final BigDecimal BAND_LIMIT_3 = BigDecimal.valueOf(3751.05);
  private static final BigDecimal BAND_LIMIT_4 = BigDecimal.valueOf(4664.68);

  private static final BigDecimal DEDUCTION_2 = BigDecimal.valueOf(169.44);
  private static final BigDecimal DEDUCTION_3 = BigDecimal.valueOf(381.44);
  private static final BigDecimal DEDUCTION_4 = BigDecimal.valueOf(662.77);
  private static final BigDecimal DEDUCTION_5 = BigDecimal.valueOf(896.00);

  private static final BigDecimal TAX_RANGE_2 = BigDecimal.valueOf(0.075);
  private static final BigDecimal TAX_RANGE_3 = BigDecimal.valueOf(0.15);
  private static final BigDecimal TAX_RANGE_4 = BigDecimal.valueOf(0.225);
  private static final BigDecimal TAX_RANGE_5 = BigDecimal.valueOf(0.275);

  @Override
  public BigDecimal calculate(BigDecimal calculationBasis) {
    if (calculationBasis.compareTo(BAND_LIMIT_1) <=0 ) {
      return BigDecimal.ZERO;
    }
    else if (calculationBasis.compareTo(BAND_LIMIT_2) <=0) {
      BigDecimal result = calculationBasis.multiply(TAX_RANGE_2).subtract(DEDUCTION_2);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else if (calculationBasis.compareTo(BAND_LIMIT_3) <= 0) {
      BigDecimal result = calculationBasis.multiply(TAX_RANGE_3).subtract(DEDUCTION_3);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else if (calculationBasis.compareTo(BAND_LIMIT_4) <= 0) {
      BigDecimal result = calculationBasis.multiply(TAX_RANGE_4).subtract(DEDUCTION_4);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else {
      BigDecimal result = calculationBasis.multiply(TAX_RANGE_5).subtract(DEDUCTION_5);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
  }
}
