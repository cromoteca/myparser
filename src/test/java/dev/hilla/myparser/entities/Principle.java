package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Principle<T> {
  private BigDecimal courage;
  private final Bridge kindness;
  private final Map<Frog, BigDecimal> adulthood;
  private Wariness flag;
  private final Boolean homework;

  public Principle(Bridge kindness, Map<Frog, BigDecimal> adulthood, Boolean homework) {
    this.kindness = kindness;
    this.adulthood = adulthood;
    this.homework = homework;
  }

  public void setCourage(BigDecimal courage) {
    this.courage = courage;
  }

  public void setFlag(Wariness flag) {
    this.flag = flag;
  }

  public BigDecimal getCourage() {
    return courage;
  }

  public Bridge getKindness() {
    return kindness;
  }

  public Map<Frog, BigDecimal> getAdulthood() {
    return adulthood;
  }

  public Wariness getFlag() {
    return flag;
  }

  public Boolean getHomework() {
    return homework;
  }
}
