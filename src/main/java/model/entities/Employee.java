package model.entities;

import java.math.BigDecimal;

public class Employee {
  private String fullName;
  private String cpf;
  private BigDecimal grossSalary;

  public Employee(String fullName, String cpf, BigDecimal grossSalary) {
    this.fullName = fullName;
    this.cpf = cpf;
    this.grossSalary = grossSalary;
  }

  public String getFullName() {
    return fullName;
  }

  public String getCpf() {
    return cpf;
  }

  public BigDecimal getGrossSalary() {
    return grossSalary;
  }

  public void setGrossSalary(BigDecimal value) {
    grossSalary = value;
  }
}
