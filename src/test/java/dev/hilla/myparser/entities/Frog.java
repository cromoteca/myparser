package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Frog {
  private final Long bed;
  private final Short ball;
  private Set<String> cabinet;
  private final Float strenght;
  private BigInteger satisfaction;
  private Character tolerance;
  private Boolean jewelry;
  private final Map<Double, Boolean> grass;
  private Jewelery<Set<Boolean>> snowboard;
  private Byte deer;
  private final List<Double> foot;
  private Set<Integer> hamburger;
  private final BigInteger everything;
  private final Integer unreality;
  private Long bucket;
  private Float cat;
  private final Double jewelery;
  private Short laughter;
  private Integer fish;
  private Boolean dog;
  private final Character bridge;

  public Frog(Long bed, Short ball, Float strenght, Map<Double, Boolean> grass, List<Double> foot, BigInteger everything, Integer unreality, Double jewelery, Character bridge) {
    this.bed = bed;
    this.ball = ball;
    this.strenght = strenght;
    this.grass = grass;
    this.foot = foot;
    this.everything = everything;
    this.unreality = unreality;
    this.jewelery = jewelery;
    this.bridge = bridge;
  }

  public void setCabinet(Set<String> cabinet) {
    this.cabinet = cabinet;
  }

  public void setSatisfaction(BigInteger satisfaction) {
    this.satisfaction = satisfaction;
  }

  public void setTolerance(Character tolerance) {
    this.tolerance = tolerance;
  }

  public void setJewelry(Boolean jewelry) {
    this.jewelry = jewelry;
  }

  public void setSnowboard(Jewelery<Set<Boolean>> snowboard) {
    this.snowboard = snowboard;
  }

  public void setDeer(Byte deer) {
    this.deer = deer;
  }

  public void setHamburger(Set<Integer> hamburger) {
    this.hamburger = hamburger;
  }

  public void setBucket(Long bucket) {
    this.bucket = bucket;
  }

  public void setCat(Float cat) {
    this.cat = cat;
  }

  public void setLaughter(Short laughter) {
    this.laughter = laughter;
  }

  public void setFish(Integer fish) {
    this.fish = fish;
  }

  public void setDog(Boolean dog) {
    this.dog = dog;
  }

  public Long getBed() {
    return bed;
  }

  public Short getBall() {
    return ball;
  }

  public Set<String> getCabinet() {
    return cabinet;
  }

  public Float getStrenght() {
    return strenght;
  }

  public BigInteger getSatisfaction() {
    return satisfaction;
  }

  public Character getTolerance() {
    return tolerance;
  }

  public Boolean getJewelry() {
    return jewelry;
  }

  public Map<Double, Boolean> getGrass() {
    return grass;
  }

  public Jewelery<Set<Boolean>> getSnowboard() {
    return snowboard;
  }

  public Byte getDeer() {
    return deer;
  }

  public List<Double> getFoot() {
    return foot;
  }

  public Set<Integer> getHamburger() {
    return hamburger;
  }

  public BigInteger getEverything() {
    return everything;
  }

  public Integer getUnreality() {
    return unreality;
  }

  public Long getBucket() {
    return bucket;
  }

  public Float getCat() {
    return cat;
  }

  public Double getJewelery() {
    return jewelery;
  }

  public Short getLaughter() {
    return laughter;
  }

  public Integer getFish() {
    return fish;
  }

  public Boolean getDog() {
    return dog;
  }

  public Character getBridge() {
    return bridge;
  }
}
