package model.entities;

import java.math.BigDecimal;

public class Payslip {
  private BigDecimal inss;
  private BigDecimal irrf;
  private BigDecimal netSalary;
  private BigDecimal monthlyGrossSalary;

  private Employee employee;

  public Payslip(BigDecimal inss, BigDecimal irrf, BigDecimal netSalary, Employee employee, BigDecimal monthlyGrossSalary) {
    this.inss = inss;
    this.irrf = irrf;
    this.netSalary = netSalary;
    this.employee = employee;
    this.monthlyGrossSalary = monthlyGrossSalary;
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

  public BigDecimal getMonthlyGrossSalary() {
    return monthlyGrossSalary;
  }

  @Override
  public String toString() {
    return "Payslip{" +
            "inss=" + inss +
            ", irrf=" + irrf +
            ", netSalary=" + netSalary +
            ", employee=" + employee +
            '}';
  }
}
