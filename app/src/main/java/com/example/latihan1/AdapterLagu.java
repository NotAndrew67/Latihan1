package com.example.latihan1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterLagu extends RecyclerView.Adapter<AdapterLagu.ViewHolder> {
    private ArrayList<LaguModel> listLagu;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(LaguModel lagu);
    }

    public AdapterLagu(ArrayList<LaguModel> listLagu, OnItemClickListener listener) {
        this.listLagu = listLagu;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lagu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LaguModel lagu = listLagu.get(position);
        holder.tvJudul.setText(lagu.getJudul());
        holder.tvPenyanyi.setText(lagu.getPenyanyi());
        holder.ivCover.setImageResource(lagu.getImageCover());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(lagu));
    }

    @Override
    public int getItemCount() {
        return listLagu.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPenyanyi;
        ImageView ivCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvPenyanyi = itemView.findViewById(R.id.tvPenyanyi);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}