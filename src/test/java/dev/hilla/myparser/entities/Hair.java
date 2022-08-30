package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Hair {
  private final Adulthood donkey;
  private Integer childhood;
  private final Frog battlefield;

  public Hair(Adulthood donkey, Frog battlefield) {
    this.donkey = donkey;
    this.battlefield = battlefield;
  }

  public void setChildhood(Integer childhood) {
    this.childhood = childhood;
  }

  public Adulthood getDonkey() {
    return donkey;
  }

  public Integer getChildhood() {
    return childhood;
  }

  public Frog getBattlefield() {
    return battlefield;
  }
}
