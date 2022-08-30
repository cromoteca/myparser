package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Balloon<T> {
  private final Bunch importance;
  private final Partnership yourself;
  private Warmth blender;
  private final Notebook desk;
  private Staff sunshine;
  private Kindness everybody;
  private Orchestra business;

  public Balloon(Bunch importance, Partnership yourself, Notebook desk) {
    this.importance = importance;
    this.yourself = yourself;
    this.desk = desk;
  }

  public void setBlender(Warmth blender) {
    this.blender = blender;
  }

  public void setSunshine(Staff sunshine) {
    this.sunshine = sunshine;
  }

  public void setEverybody(Kindness everybody) {
    this.everybody = everybody;
  }

  public void setBusiness(Orchestra business) {
    this.business = business;
  }

  public Bunch getImportance() {
    return importance;
  }

  public Partnership getYourself() {
    return yourself;
  }

  public Warmth getBlender() {
    return blender;
  }

  public Notebook getDesk() {
    return desk;
  }

  public Staff getSunshine() {
    return sunshine;
  }

  public Kindness getEverybody() {
    return everybody;
  }

  public Orchestra getBusiness() {
    return business;
  }
}
