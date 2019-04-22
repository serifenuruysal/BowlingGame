package com.soulkitchen.bowlinggame.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.soulkitchen.bowlinggame.R;
import java.util.ArrayList;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

  private ArrayList<Integer> list;

  public CustomAdapter( ArrayList<Integer> list) {
    this.list = list;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
    MyViewHolder holder = new MyViewHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.tvTotalScore.setText(list.get(position)+"");
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tvTotalScore;

    public MyViewHolder(View itemView) {
      super(itemView);
      tvTotalScore = (TextView) itemView.findViewById(R.id.tvTotalScor);
    }
  }
}
