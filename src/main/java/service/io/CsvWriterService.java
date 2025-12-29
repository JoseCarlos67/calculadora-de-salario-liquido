package service.io;

import model.entities.Payslip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;

public class CsvWriterService {
  public void writerCsv(Payslip payslip) {
    File csvFileFolder = new File("src/main/java/csvFiles");
    if (!csvFileFolder.exists()) {
      csvFileFolder.mkdirs();
    }

    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/csvFiles/"+ payslip.getEmployee().getFullName() + ".csv"))) {
        String dataEmploy = payslip.getEmployee().getFullName() + ";" + payslip.getEmployee().getCpf() + ";R$" + String.format(new Locale("pt", "BR"), "%.2f", payslip.getEmployee().getGrossSalary());

        String dataPayslip = ";R$" + String.format(new Locale("pt", "BR"), "%.2f", payslip.getMonthlyGrossSalary()) + ";R$ " + String.format(new Locale("pt", "BR"), "%.2f", payslip.getInss()) + ";R$" + String.format(new Locale("pt", "BR"), "%.2f", payslip.getIrrf()) + ";R$" + String.format(new Locale("pt", "BR"), "%.2f", payslip.getNetSalary());

        bufferedWriter.write("Nome;CPF;Salário base;Rendimento bruto mensal;INSS; IRRF;Salário líquido");
        bufferedWriter.newLine();
        bufferedWriter.write(dataEmploy);
        bufferedWriter.write(dataPayslip);
    } catch (Exception e) {
      System.out.printf("Error: " + e.getMessage());
    }
  }
}
