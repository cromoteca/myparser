package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Chest<T, U, V> {
  private final Bed<Fish<Character>> haircut;
  private final Float psychology;
  private Skyscraper<Teapot> strenght;
  private final Bacon<Float, Cupboard> opportunity;
  private Innocence<Economics<Butterfly>> cat;
  private final Crew tolerance;
  private final Skyscraper<Wealth> shower;
  private final Cooker chopstick;
  private Foot<Blood, Cooker, Sunshine<Byte>> adulthood;
  private Byte hatred;

  public Chest(Bed<Fish<Character>> haircut, Float psychology, Bacon<Float, Cupboard> opportunity, Crew tolerance, Skyscraper<Wealth> shower, Cooker chopstick) {
    this.haircut = haircut;
    this.psychology = psychology;
    this.opportunity = opportunity;
    this.tolerance = tolerance;
    this.shower = shower;
    this.chopstick = chopstick;
  }

  public void setStrenght(Skyscraper<Teapot> strenght) {
    this.strenght = strenght;
  }

  public void setCat(Innocence<Economics<Butterfly>> cat) {
    this.cat = cat;
  }

  public void setAdulthood(Foot<Blood, Cooker, Sunshine<Byte>> adulthood) {
    this.adulthood = adulthood;
  }

  public void setHatred(Byte hatred) {
    this.hatred = hatred;
  }

  public Bed<Fish<Character>> getHaircut() {
    return haircut;
  }

  public Float getPsychology() {
    return psychology;
  }

  public Skyscraper<Teapot> getStrenght() {
    return strenght;
  }

  public Bacon<Float, Cupboard> getOpportunity() {
    return opportunity;
  }

  public Innocence<Economics<Butterfly>> getCat() {
    return cat;
  }

  public Crew getTolerance() {
    return tolerance;
  }

  public Skyscraper<Wealth> getShower() {
    return shower;
  }

  public Cooker getChopstick() {
    return chopstick;
  }

  public Foot<Blood, Cooker, Sunshine<Byte>> getAdulthood() {
    return adulthood;
  }

  public Byte getHatred() {
    return hatred;
  }
}
