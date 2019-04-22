package com.soulkitchen.bowlinggame.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.soulkitchen.bowlinggame.MainContract.View;
import com.soulkitchen.bowlinggame.R;
import com.soulkitchen.bowlinggame.model.FrameModel;
import com.soulkitchen.bowlinggame.presenter.MainPresenter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements View {

  @BindView(R.id.etScoreInput)
  EditText etScoreInput;

  @BindView(R.id.buttonSend)
  Button sendButton;

  @BindView(R.id.btnStrike)
  Button btnStrike;

  @BindView(R.id.btnSpare)
  Button btnSpare;

  @BindView(R.id.rvCurrent)
  RecyclerView recyclerView;

  @BindView(R.id.rvtotal)
  RecyclerView recyclerViewTotal;

  MainPresenter presenter;
  private List<FrameModel> listOfScore;
  private ArrayList<Integer> listOfTotalScore;
  private ScoreAdapter adapter;
  private CustomAdapter customAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    listOfScore = new ArrayList<>();
    listOfTotalScore = new ArrayList<>();
    presenter = new MainPresenter(this, listOfScore, listOfTotalScore);

    adapter = new ScoreAdapter(listOfScore);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    recyclerViewTotal.setLayoutManager(new LinearLayoutManager(this));
    customAdapter = new CustomAdapter( listOfTotalScore);
    recyclerViewTotal.setAdapter(customAdapter);

    setupListeners();
  }

  private void setupListeners() {

    sendButton
        .setOnClickListener(v -> clickSendButton());
    btnSpare
        .setOnClickListener(v -> setSpare());
    btnStrike
        .setOnClickListener(v -> setStrike());
  }

  @Override
  public void notifyItemAdded(int position) {
    adapter.notifyItemInserted(position);
  }

  @Override
  public void notifyItemAddedToTotal(int position) {
    customAdapter.notifyItemChanged(position);
  }

  @Override
  public void clearMessageInput() {
    etScoreInput.setText("");
  }


  @Override
  public void setStrike() {
    presenter.clickStrikeButton(true);
    btnSpare.setEnabled(false);
    etScoreInput.setEnabled(false);
    clickSendButton();
  }

  @Override
  public void clickSendButton() {
    presenter.enterScore(etScoreInput.getText().toString());
    btnSpare.setEnabled(true);
    btnStrike.setEnabled(true);
    etScoreInput.setEnabled(true);
  }

  @Override
  public void setSpare() {
    presenter.clickSpareButton(true);
    btnStrike.setEnabled(false);
    etScoreInput.setEnabled(false);
    clickSendButton();
  }


  public void setAdapter(ScoreAdapter adapter) {
    this.adapter = adapter;
  }

  public void setListOfScore(List<FrameModel> listOfScoreList) {
    this.listOfScore = listOfScoreList;
  }

  public void setPresenter(MainPresenter presenter) {
    this.presenter = presenter;
  }
}
