package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Briefcase {
  private Horsefly crew;
  private final Bridge dancing;

  public Briefcase(Bridge dancing) {
    this.dancing = dancing;
  }

  public void setCrew(Horsefly crew) {
    this.crew = crew;
  }

  public Horsefly getCrew() {
    return crew;
  }

  public Bridge getDancing() {
    return dancing;
  }
}
