package com.soulkitchen.bowlinggame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import com.soulkitchen.bowlinggame.model.FrameModel;
import com.soulkitchen.bowlinggame.presenter.MainPresenter;
import com.soulkitchen.bowlinggame.view.MainActivity;
import com.soulkitchen.bowlinggame.view.ScoreAdapter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class MainActivityTest {

  private MainActivity activity;
  private EditText messageInput;
  private Button sendButton;
  private Button btnStrike;
  private Button btnSpare;

  @Mock
  private ScoreAdapter adapter;
  @Mock
  private List<FrameModel> listOfScoreList;
  @Mock
  private ArrayList<Integer> listOfTotalScoreList;
  @Mock
  private MainPresenter presenter;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    activity = Robolectric.setupActivity(MainActivity.class);
    messageInput = activity.findViewById(R.id.etScoreInput);
    sendButton = activity.findViewById(R.id.buttonSend);
    btnStrike = activity.findViewById(R.id.btnStrike);
    btnSpare = activity.findViewById(R.id.btnSpare);
    adapter = new ScoreAdapter(listOfScoreList);
    adapter = new ScoreAdapter(listOfScoreList);
    activity.setAdapter(adapter);
    activity.setListOfScore(listOfScoreList);
    when(listOfScoreList.size()).thenReturn(0);
  }


  @Test
  public void clearMessageInput_WasEmpty_ClearedMessageInput() {
    activity.clearMessageInput();
    assertThat(messageInput.getText().toString(), is(""));
  }

  @Test
  public void clearMessageInput_WastntEmpty_ClearedMessageInput() {
    messageInput.setText("Some text");
    activity.clearMessageInput();
    assertThat(messageInput.getText().toString(), is(""));
  }

  @Test
  public void getTotalScore_enterNumberInput_totalOutput() {
    when(presenter.getTotalScore()).thenReturn(43);
    presenter.enterScore(43 + "");
    assertEquals(presenter.getTotalScore(), 43);
  }

  @Test
  public void getTotalScore_NormalInput_sumOfOutput() {
    when(presenter.getTotalScore()).thenReturn(5);
    presenter.enterScore("2");
    presenter.enterScore("3");
    assertThat(presenter.getTotalScore(), is(5));
  }


}
