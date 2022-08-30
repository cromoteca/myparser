package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Danger {
  private Boolean group;
  private Jewelery<Map<Short, BigDecimal>> clothing;
  private List<Bacon<Double, String>> staff;
  private Map<Love<Love<String>>, Film> troupe;
  private Bridge trend;
  private Jewelery<Character> detective;
  private final Boolean dresser;
  private final Float hunger;
  private final Wariness fan;
  private final Jewelery<Character> contentment;
  private Byte pile;
  private Integer loneliness;
  private final Love<Integer> dog;

  public Danger(Boolean dresser, Float hunger, Wariness fan, Jewelery<Character> contentment, Love<Integer> dog) {
    this.dresser = dresser;
    this.hunger = hunger;
    this.fan = fan;
    this.contentment = contentment;
    this.dog = dog;
  }

  public void setGroup(Boolean group) {
    this.group = group;
  }

  public void setClothing(Jewelery<Map<Short, BigDecimal>> clothing) {
    this.clothing = clothing;
  }

  public void setStaff(List<Bacon<Double, String>> staff) {
    this.staff = staff;
  }

  public void setTroupe(Map<Love<Love<String>>, Film> troupe) {
    this.troupe = troupe;
  }

  public void setTrend(Bridge trend) {
    this.trend = trend;
  }

  public void setDetective(Jewelery<Character> detective) {
    this.detective = detective;
  }

  public void setPile(Byte pile) {
    this.pile = pile;
  }

  public void setLoneliness(Integer loneliness) {
    this.loneliness = loneliness;
  }

  public Boolean getGroup() {
    return group;
  }

  public Jewelery<Map<Short, BigDecimal>> getClothing() {
    return clothing;
  }

  public List<Bacon<Double, String>> getStaff() {
    return staff;
  }

  public Map<Love<Love<String>>, Film> getTroupe() {
    return troupe;
  }

  public Bridge getTrend() {
    return trend;
  }

  public Jewelery<Character> getDetective() {
    return detective;
  }

  public Boolean getDresser() {
    return dresser;
  }

  public Float getHunger() {
    return hunger;
  }

  public Wariness getFan() {
    return fan;
  }

  public Jewelery<Character> getContentment() {
    return contentment;
  }

  public Byte getPile() {
    return pile;
  }

  public Integer getLoneliness() {
    return loneliness;
  }

  public Love<Integer> getDog() {
    return dog;
  }
}
