package com.example.healthscanner.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthscanner.R;
import com.example.healthscanner.ui.list.database.DataEntity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<DataEntity> dataEntities;

    public RecyclerViewAdapter(List<DataEntity> dataEntities){
        this.dataEntities = dataEntities;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.onBind(dataEntities.get(position),position);
    }

    @Override
    public int getItemCount() {
        return dataEntities.size();
    }
    public void setDataEntities(List<DataEntity> dataEntities) {
        this.dataEntities = dataEntities;
        notifyDataSetChanged();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView key;
        private TextView title;
        private TextView date;
        private int index;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key);
            title = itemView.findViewById(R.id.memoTextView1);
            date = itemView.findViewById(R.id.memoTextView2);
        }

        public void onBind(DataEntity dataEntity, int position) {
            index = position;
            key.setText(index);
            title.setText(dataEntity.getTitle());
            date.setText(dataEntity.getDate());

        }
    }
}
