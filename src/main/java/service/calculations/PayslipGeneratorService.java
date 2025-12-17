package service.calculations;

import model.entities.Employee;
import model.entities.Payslip;

import java.math.BigDecimal;

public class PayslipGeneratorService {
  private InssCalculationService inssService;
  private IrrfCalculationService irrfService;

  public PayslipGeneratorService(InssCalculationService inssService, IrrfCalculationService irrfService) {
    this.inssService = inssService;
    this.irrfService = irrfService;
  }

  public Payslip generate (Employee employee) {
    BigDecimal inssValue = inssService.calculate(employee.getGrossSalary());
    BigDecimal irrfValue = irrfService.calculate(employee.getGrossSalary().subtract(inssValue));
    BigDecimal netSalary = employee.getGrossSalary().subtract(inssValue).subtract(irrfValue);

    return new Payslip(inssValue, irrfValue, netSalary, employee);
  }
}
