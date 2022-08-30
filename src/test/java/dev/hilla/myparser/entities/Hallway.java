package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Hallway<T, U, V> {
  private final Danger designer;
  private final Drum<Footprint<Fall<Education<U>>, Teapot>> happiness;
  private final Troupe education;
  private final U car;
  private final Set<Psychology> daydream;
  private final Crew kindness;

  public Hallway(Danger designer, Drum<Footprint<Fall<Education<U>>, Teapot>> happiness, Troupe education, U car, Set<Psychology> daydream, Crew kindness) {
    this.designer = designer;
    this.happiness = happiness;
    this.education = education;
    this.car = car;
    this.daydream = daydream;
    this.kindness = kindness;
  }

  public Danger getDesigner() {
    return designer;
  }

  public Drum<Footprint<Fall<Education<U>>, Teapot>> getHappiness() {
    return happiness;
  }

  public Troupe getEducation() {
    return education;
  }

  public U getCar() {
    return car;
  }

  public Set<Psychology> getDaydream() {
    return daydream;
  }

  public Crew getKindness() {
    return kindness;
  }
}
