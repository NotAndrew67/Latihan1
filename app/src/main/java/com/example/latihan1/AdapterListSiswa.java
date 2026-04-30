package com.example.latihan1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListSiswa extends RecyclerView.Adapter<AdapterListSiswa.ViewHolder> {

    private List<SiswaModel> listSiswa;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(SiswaModel siswa);
    }

    public AdapterListSiswa(List<SiswaModel> listSiswa, OnItemClickListener listener) {
        this.listSiswa = listSiswa;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAbsen, tvAlamat;
        ImageView ivProfil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvAbsen = itemView.findViewById(R.id.tvAbsen);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            ivProfil = itemView.findViewById(R.id.ivProfil);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_siswa_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SiswaModel siswa = listSiswa.get(position);

        holder.tvNama.setText(siswa.getNama());
        holder.tvAbsen.setText(siswa.getAbsen());
        holder.tvAlamat.setText(siswa.getAlamat());
        holder.ivProfil.setImageResource(siswa.getImageuser());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(siswa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }
}