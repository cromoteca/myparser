package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Crew {
  private final Principle<Film> cheeks;
  private final Aircraft<Growth, Float> fan;
  private Laughter inflation;
  private final Byte joy;
  private final Satisfaction book;
  private final Jewelery<BigDecimal> moonlight;
  private Byte guest;
  private Cooker tiredness;
  private Wealth blender;
  private Double tolerance;

  public Crew(Principle<Film> cheeks, Aircraft<Growth, Float> fan, Byte joy, Satisfaction book, Jewelery<BigDecimal> moonlight) {
    this.cheeks = cheeks;
    this.fan = fan;
    this.joy = joy;
    this.book = book;
    this.moonlight = moonlight;
  }

  public void setInflation(Laughter inflation) {
    this.inflation = inflation;
  }

  public void setGuest(Byte guest) {
    this.guest = guest;
  }

  public void setTiredness(Cooker tiredness) {
    this.tiredness = tiredness;
  }

  public void setBlender(Wealth blender) {
    this.blender = blender;
  }

  public void setTolerance(Double tolerance) {
    this.tolerance = tolerance;
  }

  public Principle<Film> getCheeks() {
    return cheeks;
  }

  public Aircraft<Growth, Float> getFan() {
    return fan;
  }

  public Laughter getInflation() {
    return inflation;
  }

  public Byte getJoy() {
    return joy;
  }

  public Satisfaction getBook() {
    return book;
  }

  public Jewelery<BigDecimal> getMoonlight() {
    return moonlight;
  }

  public Byte getGuest() {
    return guest;
  }

  public Cooker getTiredness() {
    return tiredness;
  }

  public Wealth getBlender() {
    return blender;
  }

  public Double getTolerance() {
    return tolerance;
  }
}
