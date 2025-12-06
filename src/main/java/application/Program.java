package application;

import model.entities.Employee;
import service.calculations.InssCalculationService;

import java.math.BigDecimal;

public class Program {
  public static void main(String[] args) {
    Employee employee = new Employee("José Carlos Esteves", "000.000.00-00", BigDecimal.valueOf(3000));

    InssCalculationService inss = new InssCalculationService();

    BigDecimal result = inss.calculate(employee.getGrossSalary());

    System.out.println("INSS = " + result);
  }
}
