package io.devynlab.employeeapp.enums;

public enum Position {
  MANAGER("Big Boss"),
  ASSISTANT_MANAGER("Mini Boss"),
  TEAM_LEADER("Lead Brain"),
  SENIOR_DEVELOPER("Code Ninja"),
  JUNIOR_DEVELOPER("Code Padawan"),
  ANALYST("Data Detective"),
  SPECIALIST("Wizard of Whatever");

  private final String title;

  Position(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }
}