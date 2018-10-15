package com.newmind.seobackstage.common.model;

import java.util.List;

public class PageInput
{
  private int pageNumber;
  private int pageSize;
  private List<OrderByInput> orders;

  public int getPageNumber()
  {
    return this.pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public List<OrderByInput> getOrders() {
    return this.orders;
  }

  public void setOrders(List<OrderByInput> orders) {
    this.orders = orders;
  }
}