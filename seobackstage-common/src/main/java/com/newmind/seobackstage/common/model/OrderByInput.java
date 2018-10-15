package com.newmind.seobackstage.common.model;

public class OrderByInput
{
  private String propertyName;
  private boolean isDescending;

  public OrderByInput() {
  }

  public OrderByInput(String propertyName, boolean isDescending) {
    this.propertyName = propertyName;
    this.isDescending = isDescending;
  }

  public String getPropertyName()
  {
    return this.propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public boolean isDescending() {
    return this.isDescending;
  }

  public void setDescending(boolean descending) {
    this.isDescending = descending;
  }
}