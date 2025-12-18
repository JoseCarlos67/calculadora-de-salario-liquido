package service.io;

import model.entities.ClockRecord;
import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Employee readCsv() {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/csvFiles/in.csv"))) {
      String[] dataEmployee = bufferedReader.readLine().split(",");
      Employee employee = new Employee(dataEmployee[0], dataEmployee[1], new BigDecimal(dataEmployee[2]));
      List<ClockRecord> clockRecordList = new ArrayList<>();
      String line = bufferedReader.readLine();
      while (line != null) {
          String[] clockData = line.split(",");
          ClockRecord clockRecord = new ClockRecord(LocalDate.parse(clockData[0], dtf), LocalTime.parse(clockData[1]), LocalTime.parse(clockData[2]), LocalTime.parse(clockData[3]), LocalTime.parse(clockData[4]));
          employee.addClockRecord(clockRecord);
          line = bufferedReader.readLine();
      }
      System.out.println(employee);
      return employee;
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }
}
