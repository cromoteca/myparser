package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Thunderstorm<T> {
  private final Frog footprint;
  private final Handcuff insanity;
  private Insanity countdown;
  private final Skyscraper<Aunt> cotton;
  private final Greenhouse battlefield;

  public Thunderstorm(Frog footprint, Handcuff insanity, Skyscraper<Aunt> cotton, Greenhouse battlefield) {
    this.footprint = footprint;
    this.insanity = insanity;
    this.cotton = cotton;
    this.battlefield = battlefield;
  }

  public void setCountdown(Insanity countdown) {
    this.countdown = countdown;
  }

  public Frog getFootprint() {
    return footprint;
  }

  public Handcuff getInsanity() {
    return insanity;
  }

  public Insanity getCountdown() {
    return countdown;
  }

  public Skyscraper<Aunt> getCotton() {
    return cotton;
  }

  public Greenhouse getBattlefield() {
    return battlefield;
  }
}
