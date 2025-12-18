package model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Employee {
  private String fullName;
  private String cpf;
  private BigDecimal grossSalary;
  private List<ClockRecord> clockRecordList;

  public Employee(String fullName, String cpf, BigDecimal grossSalary) {
    this.fullName = fullName;
    this.cpf = cpf;
    this.grossSalary = grossSalary;
    clockRecordList = new ArrayList<>();
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

  public void addClockRecord(ClockRecord record) {
    clockRecordList.add(record);
  }

  @Override
  public String toString() {
    return "Employee{" +
            "fullName='" + fullName + '\'' +
            ", cpf='" + cpf + '\'' +
            ", grossSalary=" + grossSalary +
            ", clockRecordList=" + clockRecordList +
            '}';
  }
}
