package com.soulkitchen.bowlinggame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.os.Build;
import com.soulkitchen.bowlinggame.presenter.MainPresenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class PresenterTest {

  @Mock
  private MainPresenter presenter;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }


  @Test
  public void sendMessage_EmptyInput_NoMessageSent() {
    presenter.enterScore("");
    verify(presenter).enterScore("");
  }


  @Test
  public void sendMessage_NullInput_NoMessageSent() {
    presenter.enterScore(null);
    verify(presenter).enterScore(null);
  }

  @Test
  public void sendMessage_NotNullInput_NoMessageSent() {
    presenter.enterScore("text");
    verify(presenter).enterScore("text");
  }

  @Test
  public void sendMessage_NoNullInput_NoMessageSent() {
    presenter.addFrame(anyObject());
    verify(presenter).addFrame(anyObject());
  }



  @Test
  public void sendMessage_NormalInput_getTotalScore() {
    when(presenter.getTotalScore()).thenReturn(5);

    assertThat(presenter.getTotalScore(), is(5));
  }

  @Test
  public void sendMessage_NormalddInput_getTotalScore() {
    when(presenter.getTotalScore()).thenReturn(5);
    presenter.enterScore("1");
    presenter.enterScore("4");

    when(presenter.getTotalScore()).thenReturn(14);
    presenter.enterScore("4");
    presenter.enterScore("5");
    assertThat(presenter.getTotalScore(), is(14));
  }
}
