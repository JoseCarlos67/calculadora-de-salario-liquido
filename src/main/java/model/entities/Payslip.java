package model.entities;

import java.math.BigDecimal;

public class Payslip {
  private BigDecimal inss;
  private BigDecimal irrf;
  private BigDecimal netSalary;

  private Employee employee;

  public Payslip(BigDecimal inss, BigDecimal irrf, BigDecimal netSalary, Employee employee) {
    this.inss = inss;
    this.irrf = irrf;
    this.netSalary = netSalary;
    this.employee = employee;
  }

  public BigDecimal getInss() {
    return inss;
  }

  public BigDecimal getIrrf() {
    return irrf;
  }

  public BigDecimal getNetSalary() {
    return netSalary;
  }

  public Employee getEmployee() {
    return employee;
  }
}
