package com.newmind.seobackstage.common.model;

import java.util.List;

public class PageContent<T>
{
  private List<T> items;
  private int count;

  public PageContent() {
  }

  public PageContent(List<T> items, int count)
  {
    this.items = items;
    this.count = count;
  }

  public List<T> getItems()
  {
    return this.items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}