package com.soulkitchen.bowlinggame.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.soulkitchen.bowlinggame.R;
import com.soulkitchen.bowlinggame.model.FrameModel;
import java.util.List;

  public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.Holder> {
  public static final String SPARE= "SPARE";
  public static final String STRIKE= "STRIKE";
  private List<FrameModel> list;

  public ScoreAdapter() {
  }

  public ScoreAdapter(List<FrameModel> list) {
    this.list = list;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View inflate = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false);
    return new Holder(inflate);
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    FrameModel model = list.get(position);
    if(model.isSpare()){
      holder.tvRound.setText(SPARE);
    }else if(model.isStrike()){
      holder.tvRound.setText( STRIKE);
    }else {
      holder.tvRound.setText(model.getCurrentScore() + "");
    }

  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  static class Holder extends RecyclerView.ViewHolder {

    TextView tvRound;


    Holder(View itemView) {
      super(itemView);
      tvRound = itemView.findViewById(R.id.tvRound);
    }
  }

}
