package com.example.latihan1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailLagu extends AppCompatActivity {

    ImageView ivDetailCover;
    TextView tvDetailJudul, tvDetailPenyanyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lagu);

        ivDetailCover = findViewById(R.id.ivDetailCover);
        tvDetailJudul = findViewById(R.id.tvDetailJudul);
        tvDetailPenyanyi = findViewById(R.id.tvDetailPenyanyi);

        LaguModel dataLagu = (LaguModel) getIntent().getSerializableExtra("DATA_LAGU");

        if (dataLagu != null) {
            tvDetailJudul.setText(dataLagu.getJudul());
            tvDetailPenyanyi.setText(dataLagu.getPenyanyi());
            ivDetailCover.setImageResource(dataLagu.getImageCover());

            ivDetailCover.setOnClickListener(v -> {
                String url = dataLagu.getLinkSpotify();
                if (url != null && !url.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });

            tvDetailPenyanyi.setOnClickListener(view -> {
                String wiki = dataLagu.getLinkWiki();
                if (wiki != null && !wiki.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(wiki));
                    startActivity(intent);
                }
            });
        }
    }
}