package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Chopstick {
  private Wariness cap;
  private Armchair<Bridge> confusion;
  private final Troupe fireworks;

  public Chopstick(Troupe fireworks) {
    this.fireworks = fireworks;
  }

  public void setCap(Wariness cap) {
    this.cap = cap;
  }

  public void setConfusion(Armchair<Bridge> confusion) {
    this.confusion = confusion;
  }

  public Wariness getCap() {
    return cap;
  }

  public Armchair<Bridge> getConfusion() {
    return confusion;
  }

  public Troupe getFireworks() {
    return fireworks;
  }
}
