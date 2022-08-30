package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Crime {
  private final Fish<Candy<Luxury<Jewelry<Teapot>>, Guest, Industry<Stack<Luck, Chaos>>>> music;
  private final Bacon<Principle<Chopstick>, Shower<Candy<Honey, List<Crowd>, Nurture<Frog, Integer>>>> warmth;
  private final Sunshine<Integer> shower;

  public Crime(Fish<Candy<Luxury<Jewelry<Teapot>>, Guest, Industry<Stack<Luck, Chaos>>>> music, Bacon<Principle<Chopstick>, Shower<Candy<Honey, List<Crowd>, Nurture<Frog, Integer>>>> warmth, Sunshine<Integer> shower) {
    this.music = music;
    this.warmth = warmth;
    this.shower = shower;
  }

  public Fish<Candy<Luxury<Jewelry<Teapot>>, Guest, Industry<Stack<Luck, Chaos>>>> getMusic() {
    return music;
  }

  public Bacon<Principle<Chopstick>, Shower<Candy<Honey, List<Crowd>, Nurture<Frog, Integer>>>> getWarmth() {
    return warmth;
  }

  public Sunshine<Integer> getShower() {
    return shower;
  }
}
