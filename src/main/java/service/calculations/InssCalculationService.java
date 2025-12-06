package service.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InssCalculationService {
  private static final BigDecimal BAND_LIMIT_1 = BigDecimal.valueOf(1412);
  private static final BigDecimal BAND_LIMIT_2 = BigDecimal.valueOf(2666.68);
  private static final BigDecimal BAND_LIMIT_3 = BigDecimal.valueOf(4000.03);
  private static final BigDecimal BAND_LIMIT_4 = BigDecimal.valueOf(7786.02);

  private static final BigDecimal TAX_RANGE_1 = BigDecimal.valueOf(0.075);
  private static final BigDecimal TAX_RANGE_2 = BigDecimal.valueOf(0.09);
  private static final BigDecimal TAX_RANGE_3 = BigDecimal.valueOf(0.12);
  private static final BigDecimal TAX_RANGE_4 = BigDecimal.valueOf(0.14);

  public BigDecimal calculate(BigDecimal grossSalary) {
    if (grossSalary.compareTo(BAND_LIMIT_1) <= 0) {
      BigDecimal result = grossSalary.multiply(TAX_RANGE_1);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else if (grossSalary.compareTo(BAND_LIMIT_1) > 0 && grossSalary.compareTo(BAND_LIMIT_2) <= 0) {
      BigDecimal taxOnfirstPart = BAND_LIMIT_1.multiply(TAX_RANGE_1);

      BigDecimal restPart = grossSalary.subtract(BAND_LIMIT_1);

      BigDecimal taxOnRestPart = restPart.multiply(TAX_RANGE_2);

      BigDecimal result = taxOnfirstPart.add(taxOnRestPart);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
    else if (grossSalary.compareTo(BAND_LIMIT_2) > 0 && grossSalary.compareTo(BAND_LIMIT_3) <= 0) {
      BigDecimal taxOnfirstPart = BAND_LIMIT_1.multiply(TAX_RANGE_1);

      BigDecimal secondPart = BAND_LIMIT_2.subtract(BAND_LIMIT_1);

      BigDecimal taxOnSecondPart = secondPart.multiply(TAX_RANGE_2);

      BigDecimal restPart = grossSalary.subtract(BAND_LIMIT_2);

      BigDecimal taxOnRestPart = restPart.multiply(TAX_RANGE_3);

      BigDecimal result = taxOnfirstPart.add(taxOnSecondPart).add(taxOnRestPart);
      return result.setScale(2, RoundingMode.HALF_UP);
    } else {
      BigDecimal baseCalculation = grossSalary;
      if (grossSalary.compareTo(BAND_LIMIT_4) > 0) {
        baseCalculation = BAND_LIMIT_4;
      }

      BigDecimal taxOnFirstPart = BAND_LIMIT_1.multiply(TAX_RANGE_1);

      BigDecimal range2Diff = BAND_LIMIT_2.subtract(BAND_LIMIT_1);
      BigDecimal taxOnSecondPart = range2Diff.multiply(TAX_RANGE_2);

      BigDecimal range3Diff = BAND_LIMIT_3.subtract(BAND_LIMIT_2);
      BigDecimal taxOnThirdPart = range3Diff.multiply(TAX_RANGE_3);

      BigDecimal restPart = baseCalculation.subtract(BAND_LIMIT_3);
      BigDecimal taxOnRestPart = restPart.multiply(TAX_RANGE_4);

      BigDecimal result = taxOnFirstPart.add(taxOnSecondPart).add(taxOnThirdPart).add(taxOnRestPart);
      return result.setScale(2, RoundingMode.HALF_UP);
    }
  }
}
