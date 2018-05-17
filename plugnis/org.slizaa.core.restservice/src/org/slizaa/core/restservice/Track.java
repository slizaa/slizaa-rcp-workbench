package org.slizaa.core.restservice;

public class Track {

  String title;

  String singer;

  /**
   * <p>
   * Creates a new instance of type {@link Track}.
   * </p>
   *
   * @param title
   * @param singer
   */
  public Track(String title, String singer) {
    this.title = title;
    this.singer = singer;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSinger() {
    return this.singer;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }

  @Override
  public String toString() {
    return "Track [title=" + this.title + ", singer=" + this.singer + "]";
  }

}