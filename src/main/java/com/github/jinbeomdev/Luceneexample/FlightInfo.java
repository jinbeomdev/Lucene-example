package com.github.jinbeomdev.Luceneexample;

public class FlightInfo {
  /**
   * Following fields is in csv
   * Year,
   * Month,
   * DayofMonth,
   * DayOfWeek,
   * DepTime,
   * CRSDepTime,
   * ArrTime,
   * CRSArrTime,
   * UniqueCarrier,
   * FlightNum,
   * TailNum,
   * ActualElapsedTime,
   * CRSElapsedTime,
   * AirTime,
   * ArrDelay,
   * DepDelay,
   * Origin,
   * Dest,
   * Distance,
   * TaxiIn,
   * TaxiOut,
   * Cancelled,
   * CancellationCode,
   * Diverted,
   * CarrierDelay,
   * WeatherDelay,
   * NASDelay,
   * SecurityDelay,
   * LateAircraftDelay
   */

  private String year;

  private String month;

  private String uniqueCarrier;

  private String arrDelay;

  private String depDelay;

  private String Origin;

  private String Dest;

  private String Distance;

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public String getUniqueCarrier() {
    return uniqueCarrier;
  }

  public void setUniqueCarrier(String uniqueCarrier) {
    this.uniqueCarrier = uniqueCarrier;
  }

  public String getArrDelay() {
    return arrDelay;
  }

  public void setArrDelay(String arrDelay) {
    this.arrDelay = arrDelay;
  }

  public String getDepDelay() {
    return depDelay;
  }

  public void setDepDelay(String depDelay) {
    this.depDelay = depDelay;
  }

  public String getOrigin() {
    return Origin;
  }

  public void setOrigin(String origin) {
    Origin = origin;
  }

  public String getDest() {
    return Dest;
  }

  public void setDest(String dest) {
    Dest = dest;
  }

  public String getDistance() {
    return Distance;
  }

  public void setDistance(String distance) {
    Distance = distance;
  }
}
