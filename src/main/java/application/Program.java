package application;

import model.entities.Employee;
import model.entities.Payslip;
import service.calculations.InssCalculationService;
import service.calculations.IrrfCalculationService;
import service.calculations.PayslipGeneratorService;
import service.calculations.SalaryService;
import service.io.CsvReaderService;
import service.io.CsvWriterService;

import java.math.BigDecimal;

public class Program {
  public static void main(String[] args) {
    CsvReaderService csvReader = new CsvReaderService();
    Employee employee;
    employee = csvReader.readCsv("src/main/java/csvFiles/in.csv");

    InssCalculationService inssCalculationService = new InssCalculationService();
    IrrfCalculationService irrfCalculationService = new IrrfCalculationService();
    SalaryService salaryService = new SalaryService();

    PayslipGeneratorService payslipGeneratorService = new PayslipGeneratorService(inssCalculationService, irrfCalculationService, salaryService, employee);

    Payslip payslip = payslipGeneratorService.generate();

    CsvWriterService csvWriterService = new CsvWriterService();
    csvWriterService.writerCsv(payslip);
  }
}
