package application;

import model.entities.Employee;
import service.calculations.InssCalculationService;
import service.io.CsvReaderService;

import java.math.BigDecimal;

public class Program {
  public static void main(String[] args) {
    CsvReaderService csvReader = new CsvReaderService();
    csvReader.readCsv();
  }
}
