package com.soulkitchen.bowlinggame.presenter;

import com.soulkitchen.bowlinggame.MainContract;
import com.soulkitchen.bowlinggame.MainContract.View;
import com.soulkitchen.bowlinggame.model.FrameModel;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {

  private MainContract.View view;
  private List<FrameModel> listOfFrameModel;
  private List<Integer> listOfTotalScore;
  private boolean isStrike;
  private boolean isSpare;
  private boolean isLastRoundStrike;
  private boolean isLastRoundSpare;

  int currentFrameScore = 0;
  int lastFrameScore = 0;
  int scoreAfterStrike = 10;
  int scoreAfterSpare = 0;
  int counterFrame = 0;
  int counterStrike = 0;
  int counterSpare = 0;
  int totalScore = 0;

  public MainPresenter(View view, List<FrameModel> listOfScore,
      ArrayList<Integer> listOfTotalScore) {
    this.view = view;
    this.listOfFrameModel = listOfScore;
    this.listOfTotalScore = listOfTotalScore;

  }


  @Override
  public void enterScore(String input) {
    if ((input != null && !input.isEmpty()) || (isSpare || isStrike)) {
      FrameModel model = new FrameModel(isStrike, isSpare);
      if (!isSpare && !isStrike) {
        model.setCurrentScore(Integer.valueOf(input));
      }

      view.clearMessageInput();
      calculateScore(model);
      if (isStrike) {
        FrameModel newModel = new FrameModel();
        newModel.setTotalScore(10);
        addFrame(newModel);
      }
      addFrame(model);
    }
  }

  @Override
  public void calculateScore(FrameModel model) {
    counterFrame++;
    currentFrameScore = currentFrameScore + model.getCurrentScore();

    if (isStrike) {

      if (isLastRoundStrike) {
        checkRoundAddForStrike();
      } else if (isLastRoundSpare) {
        checkRoundAddForSpare(model);
      }
      isLastRoundStrike = true;
      scoreAfterStrike = scoreAfterStrike + model.getCurrentScore();

    } else if (isSpare) {
      if (isLastRoundStrike) {

        checkRoundAddForStrike();
      } else if (isLastRoundSpare) {
        checkRoundAddForSpare(model);
      }else{
        isLastRoundSpare = true;
        scoreAfterSpare = scoreAfterSpare + 10;
        counterFrame = 0;
        totalScore=totalScore+10;
        lastFrameScore = 10;
        currentFrameScore = 0;
      }

    } else {
      if (isLastRoundStrike) {
        scoreAfterStrike = scoreAfterStrike + model.getCurrentScore();
        checkRoundAddForStrike();


      } else if (isLastRoundSpare) {
        checkRoundAddForSpare(model);

      }

    }
    if (counterFrame >= 2 && !isLastRoundStrike && !isLastRoundSpare) {
      setEndOfCurrentFrame();
    }

  }

  private void setEndOfCurrentFrame() {
    lastFrameScore = currentFrameScore;
    totalScore = totalScore + lastFrameScore;
    counterFrame = 0;
    currentFrameScore = 0;
    listOfTotalScore.add(totalScore);
    view.notifyItemAddedToTotal(listOfTotalScore.size());
  }

  private void checkRoundAddForSpare(FrameModel model) {
    scoreAfterSpare = scoreAfterSpare + model.getCurrentScore();
    counterSpare++;
    if (counterSpare >= 1) {
      totalScore = totalScore + scoreAfterSpare;
      counterSpare = 0;
      isLastRoundSpare = false;
      scoreAfterSpare = 0;
      listOfTotalScore.add(totalScore);
      view.notifyItemAddedToTotal(listOfTotalScore.size());
    }
  }

  private void checkRoundAddForStrike() {
    scoreAfterStrike = scoreAfterStrike + 10;
    counterStrike++;
    if (counterStrike >= 2) {
      totalScore = totalScore + scoreAfterStrike;
      scoreAfterStrike = 10;
      counterStrike = 0;
      isLastRoundStrike = false;
      listOfTotalScore.add(totalScore);
      view.notifyItemAddedToTotal(listOfTotalScore.size());
    }
  }


  @Override
  public void addFrame(FrameModel model) {
    listOfFrameModel.add(model);
    view.notifyItemAdded(listOfFrameModel.size());
    isStrike = false;
    isSpare = false;

  }

  @Override
  public void clickStrikeButton(boolean b) {
    isStrike = b;
  }

  @Override
  public void clickSpareButton(boolean b) {
    isSpare = b;
  }

  public List<FrameModel> getListOfFrameModel() {
    return listOfFrameModel;
  }

  public boolean isStrike() {
    return isStrike;
  }

  public boolean isSpare() {
    return isSpare;
  }

  public int getTotalScore() {
    return totalScore;
  }

}
