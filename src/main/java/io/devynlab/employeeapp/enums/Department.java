package io.devynlab.employeeapp.enums;

public enum Department {
  SALES("Sales Ninjas"),
  MARKETING("Marketing Gurus"),
  IT("Tech Wizards"),
  HR("People Whisperers"),
  FINANCE("Money Masters");

  private final String teamName;

  Department(String teamName) {
    this.teamName = teamName;
  }

  public String getTeamName() {
    return teamName;
  }
}