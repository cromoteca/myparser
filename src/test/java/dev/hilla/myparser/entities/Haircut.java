package dev.hilla.myparser.entities;

import java.math.*;
import java.util.*;

public class Haircut {
  private final Troupe bed;
  private Cupboard haircut;
  private final Education<Skyscraper<Need<Sunshine<Butterfly>>>> growth;
  private final Float chair;
  private Cooker orchestra;
  private final Foot<Danger, Jewelery<Need<Victory>>, Troupe> photocopy;
  private Detective meat;
  private Houseboat<Chest<Teapot, Contentment, Byte>, Panel<Long>> gang;
  private final Shower<Integer> confidence;
  private final Cupboard moonlight;
  private Jewelery<Staff> duty;
  private Film music;
  private final Footprint<String, Handcuff> linguistics;
  private final Danger hallway;
  private Industry<Victory> fireworks;

  public Haircut(Troupe bed, Education<Skyscraper<Need<Sunshine<Butterfly>>>> growth, Float chair, Foot<Danger, Jewelery<Need<Victory>>, Troupe> photocopy, Shower<Integer> confidence, Cupboard moonlight, Footprint<String, Handcuff> linguistics, Danger hallway) {
    this.bed = bed;
    this.growth = growth;
    this.chair = chair;
    this.photocopy = photocopy;
    this.confidence = confidence;
    this.moonlight = moonlight;
    this.linguistics = linguistics;
    this.hallway = hallway;
  }

  public void setHaircut(Cupboard haircut) {
    this.haircut = haircut;
  }

  public void setOrchestra(Cooker orchestra) {
    this.orchestra = orchestra;
  }

  public void setMeat(Detective meat) {
    this.meat = meat;
  }

  public void setGang(Houseboat<Chest<Teapot, Contentment, Byte>, Panel<Long>> gang) {
    this.gang = gang;
  }

  public void setDuty(Jewelery<Staff> duty) {
    this.duty = duty;
  }

  public void setMusic(Film music) {
    this.music = music;
  }

  public void setFireworks(Industry<Victory> fireworks) {
    this.fireworks = fireworks;
  }

  public Troupe getBed() {
    return bed;
  }

  public Cupboard getHaircut() {
    return haircut;
  }

  public Education<Skyscraper<Need<Sunshine<Butterfly>>>> getGrowth() {
    return growth;
  }

  public Float getChair() {
    return chair;
  }

  public Cooker getOrchestra() {
    return orchestra;
  }

  public Foot<Danger, Jewelery<Need<Victory>>, Troupe> getPhotocopy() {
    return photocopy;
  }

  public Detective getMeat() {
    return meat;
  }

  public Houseboat<Chest<Teapot, Contentment, Byte>, Panel<Long>> getGang() {
    return gang;
  }

  public Shower<Integer> getConfidence() {
    return confidence;
  }

  public Cupboard getMoonlight() {
    return moonlight;
  }

  public Jewelery<Staff> getDuty() {
    return duty;
  }

  public Film getMusic() {
    return music;
  }

  public Footprint<String, Handcuff> getLinguistics() {
    return linguistics;
  }

  public Danger getHallway() {
    return hallway;
  }

  public Industry<Victory> getFireworks() {
    return fireworks;
  }
}
