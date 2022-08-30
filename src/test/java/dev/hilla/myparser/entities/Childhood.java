package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Childhood {
  private final Danger chaos;
  private final Education<Law<Cleverness, Partnership>> music;
  private Kindness hate;
  private Daydream<Homework> blood;
  private final Double homework;

  public Childhood(Danger chaos, Education<Law<Cleverness, Partnership>> music, Double homework) {
    this.chaos = chaos;
    this.music = music;
    this.homework = homework;
  }

  public void setHate(Kindness hate) {
    this.hate = hate;
  }

  public void setBlood(Daydream<Homework> blood) {
    this.blood = blood;
  }

  public Danger getChaos() {
    return chaos;
  }

  public Education<Law<Cleverness, Partnership>> getMusic() {
    return music;
  }

  public Kindness getHate() {
    return hate;
  }

  public Daydream<Homework> getBlood() {
    return blood;
  }

  public Double getHomework() {
    return homework;
  }
}
