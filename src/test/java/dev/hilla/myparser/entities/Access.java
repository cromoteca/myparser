package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Access {
  private final Long hamburger;
  private Contentment need;
  private Cooker cap;
  private final Footprint<Crew, Insanity> film;
  private final Boolean bunch;
  private Chaos balloon;

  public Access(Long hamburger, Footprint<Crew, Insanity> film, Boolean bunch) {
    this.hamburger = hamburger;
    this.film = film;
    this.bunch = bunch;
  }

  public void setNeed(Contentment need) {
    this.need = need;
  }

  public void setCap(Cooker cap) {
    this.cap = cap;
  }

  public void setBalloon(Chaos balloon) {
    this.balloon = balloon;
  }

  public Long getHamburger() {
    return hamburger;
  }

  public Contentment getNeed() {
    return need;
  }

  public Cooker getCap() {
    return cap;
  }

  public Footprint<Crew, Insanity> getFilm() {
    return film;
  }

  public Boolean getBunch() {
    return bunch;
  }

  public Chaos getBalloon() {
    return balloon;
  }
}
