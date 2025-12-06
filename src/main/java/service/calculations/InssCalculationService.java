package service.calculations;

import java.math.BigDecimal;

public class InssCalculationService {
  public BigDecimal calculate(BigDecimal grossSalary) {
    if (grossSalary.compareTo(BigDecimal.valueOf(1412)) <= 0) {
      return grossSalary.multiply(BigDecimal.valueOf(0.075));
    }
    else if (grossSalary.compareTo(BigDecimal.valueOf(1412)) > 0 && grossSalary.compareTo(BigDecimal.valueOf(2666.68)) <= 0) {
      BigDecimal taxOnfirstPart = BigDecimal.valueOf(1412).multiply(BigDecimal.valueOf(0.075));

      BigDecimal restPart = grossSalary.subtract(BigDecimal.valueOf(1412));

      BigDecimal taxOnRestPart = restPart.multiply(BigDecimal.valueOf(0.09));

      return taxOnfirstPart.add(taxOnRestPart);
    }
    else if (grossSalary.compareTo(BigDecimal.valueOf(2666.68)) > 0 && grossSalary.compareTo(BigDecimal.valueOf(4000.03)) <= 0) {
      BigDecimal taxOnfirstPart = BigDecimal.valueOf(1412).multiply(BigDecimal.valueOf(0.075));

      BigDecimal secondPart = BigDecimal.valueOf(2666.68).subtract(BigDecimal.valueOf(1412));

      BigDecimal taxOnSecondPart = secondPart.multiply(BigDecimal.valueOf(0.09));

      BigDecimal restPart = grossSalary.subtract(BigDecimal.valueOf(2666.68));

      BigDecimal taxOnRestPart = restPart.multiply(BigDecimal.valueOf(0.12));

      return taxOnfirstPart.add(taxOnSecondPart).add(taxOnRestPart);
    } else {
      BigDecimal baseCalculation = grossSalary;
      if (grossSalary.compareTo(BigDecimal.valueOf(7786.02)) > 0) {
        baseCalculation = BigDecimal.valueOf(7786.02);
      }

      BigDecimal taxOnFirstPart = BigDecimal.valueOf(1412).multiply(BigDecimal.valueOf(0.075));

      BigDecimal range2Diff = BigDecimal.valueOf(2666.68).subtract(BigDecimal.valueOf(1412));
      BigDecimal taxOnSecondPart = range2Diff.multiply(BigDecimal.valueOf(0.09));

      BigDecimal range3Diff = BigDecimal.valueOf(4000.03).subtract(BigDecimal.valueOf(2666.68));
      BigDecimal taxOnThirdPart = range3Diff.multiply(BigDecimal.valueOf(0.12));

      BigDecimal restPart = baseCalculation.subtract(BigDecimal.valueOf(4000.03));
      BigDecimal taxOnRestPart = restPart.multiply(BigDecimal.valueOf(0.14));

      return taxOnFirstPart.add(taxOnRestPart).add(taxOnThirdPart).add(taxOnRestPart);
    }
  }
}
