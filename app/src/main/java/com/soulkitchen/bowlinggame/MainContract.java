package com.soulkitchen.bowlinggame;

import com.soulkitchen.bowlinggame.model.FrameModel;

public interface MainContract {


  interface Presenter {

    void enterScore(String score);

    void calculateScore(FrameModel model);

    void addFrame(FrameModel model);

    void clickStrikeButton(boolean b);

    void clickSpareButton(boolean b);
  }

  interface View {

    void setStrike();

    void clickSendButton();

    void setSpare();

    void notifyItemAdded(int position);

    void notifyItemAddedToTotal(int position);

    void clearMessageInput();

  }
}

