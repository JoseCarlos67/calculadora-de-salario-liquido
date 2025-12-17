package model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClockRecord {
  private LocalDate date;
  private LocalTime clockIn;
  private LocalTime clockOut;
  private LocalTime lunchBreakStart;
  private LocalTime lunchBreakEnd;

  public ClockRecord(LocalDate date, LocalTime clockIn, LocalTime clockOut, LocalTime lunchBreakStart, LocalTime lunchBreakEnd) {
    this.date = date;
    this.clockIn = clockIn;
    this.clockOut = clockOut;
    this.lunchBreakStart = lunchBreakStart;
    this.lunchBreakEnd = lunchBreakEnd;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getClockIn() {
    return clockIn;
  }

  public LocalTime getClockOut() {
    return clockOut;
  }

  public LocalTime getLunchBreakStart() {
    return lunchBreakStart;
  }

  public LocalTime getLunchBreakEnd() {
    return lunchBreakEnd;
  }
}
