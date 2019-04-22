package com.soulkitchen.bowlinggame.model;

public class FrameModel {

  private int currentScore;
  private int totalScore;
  private boolean isStrike;
  private boolean isSpare;

  public FrameModel(int currentScore, int totalScore, boolean isStrike, boolean isSpare) {
    this.currentScore = currentScore;
    this.totalScore = totalScore;
    this.isStrike = isStrike;
    this.isSpare = isSpare;
  }

  public FrameModel(boolean isStrike, boolean isSpare) {
    this.isStrike = isStrike;
    this.isSpare = isSpare;
  }

  public FrameModel() {

  }

  public int getCurrentScore() {
    return currentScore;
  }

  public void setCurrentScore(int currentScore) {
    this.currentScore = currentScore;
  }

  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }

  public boolean isStrike() {
    return isStrike;
  }

  public void setStrike(boolean strike) {
    isStrike = strike;
  }

  public boolean isSpare() {
    return isSpare;
  }

  public void setSpare(boolean spare) {
    isSpare = spare;
  }
}
