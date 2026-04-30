package com.example.latihan1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button; // Tambahan import
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list_lagu extends AppCompatActivity {
    RecyclerView rvListLagu;
    TextView tvUsername;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lagu);

        tvUsername = findViewById(R.id.tvUsername);
        btnLogout = findViewById(R.id.btnLogout);
        rvListLagu = findViewById(R.id.rvlistlagu);

        SharedPreferences sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE);
        String namaUser = sharedPref.getString("username_key", "Guest");
        tvUsername.setText("Halo, " + namaUser);

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(list_lagu.this, MainActivity.class);
            startActivity(intent);

            finish();
        });

        ArrayList<LaguModel> listDataLagu = new ArrayList<>();
        listDataLagu.add(new LaguModel("Fly Me to the Moon", "Frank Sinatra", R.drawable.cover1, "https://open.spotify.com/track/7FXj7Qg3YorUxdrzvrcY25?si=be23550691a64e89", "https://id.wikipedia.org/wiki/Frank_Sinatra"));
        listDataLagu.add(new LaguModel("Everything", "Michael Buble", R.drawable.cover2, "https://open.spotify.com/track/4T6HLdP6OcAtqC6tGnQelG?si=04cc7ba48e7e4f9f", "https://id.wikipedia.org/wiki/Michael_Bubl%C3%A9"));
        listDataLagu.add(new LaguModel("Moves Like Jagger", "Maroon 5", R.drawable.cover3, "https://open.spotify.com/track/3TahdwXB4gJRWVAI00Ejqa?si=f4c4bab6bdbe400c", "https://id.wikipedia.org/wiki/Maroon_5"));
        listDataLagu.add(new LaguModel("R U Mine?", "Arctic Monkeys", R.drawable.cover4,"https://open.spotify.com/track/2AT8iROs4FQueDv2c8q2KE?si=1aa22bcb983c47a5", "https://id.wikipedia.org/wiki/Arctic_Monkeys"));
        listDataLagu.add(new LaguModel("Forget Her", "Jeff Buckley", R.drawable.cover5, "https://open.spotify.com/track/6UuVONmxXwTKN1ISepuAoQ?si=094dedede1514187", "https://en.wikipedia.org/wiki/Jeff_Buckley"));
        listDataLagu.add(new LaguModel("Risk It All", "Bruno Mars", R.drawable.cover6, "https://open.spotify.com/track/5y2ijHECwFYWqcAHKTZgzD?si=ce46ab24c9b44f6e", "https://en.wikipedia.org/wiki/Bruno_Mars"));
        listDataLagu.add(new LaguModel("Bound 2", "Kanye West", R.drawable.cover7, "https://open.spotify.com/track/3sNVsP50132BTNlImLx70i?si=d57b23d7e5dc4a0f", "https://id.wikipedia.org/wiki/Kanye_West"));
        listDataLagu.add(new LaguModel("R.I.P", "Playboi Carti", R.drawable.cover8, "https://open.spotify.com/track/3L0IKstjUgDFVQAbQIRZRv?si=02475c883b074676", "https://en.wikipedia.org/wiki/Playboi_Carti"));
        listDataLagu.add(new LaguModel("I Bet You Look Good On The Dancefloor", "Arctic Monkeys", R.drawable.cover9, "https://open.spotify.com/track/3DQVgcqaP3iSMbaKsd57l5?si=a84b11191448412e", "https://id.wikipedia.org/wiki/Arctic_Monkeys"));
        listDataLagu.add(new LaguModel("Purple Rain", "Prince", R.drawable.cover10, "https://open.spotify.com/track/1uvyZBs4IZYRebHIB1747m?si=490d51771fea4866", "https://id.wikipedia.org/wiki/Prince_(musisi)"));
        listDataLagu.add(new LaguModel("Glimpse of Us", "Joji", R.drawable.cover11, "https://open.spotify.com/track/3aBGKDiAAvH2H7HLOyQ4US?si=4c75b3bf79054b47", "https://id.wikipedia.org/wiki/Joji_(penyanyi)"));
        listDataLagu.add(new LaguModel("Happier", "Olivia Rodrigo", R.drawable.cover12, "https://open.spotify.com/track/2tGvwE8GcFKwNdAXMnlbfl?si=51c6ebcc3c54485f", "https://id.wikipedia.org/wiki/Olivia_Rodrigo"));
        listDataLagu.add(new LaguModel("Another Love", "Tom Odell", R.drawable.cover13, "https://open.spotify.com/track/3JvKfv6T31zO0ini8iNItO?si=1677121cab284367", "https://id.wikipedia.org/wiki/Tom_Odell"));
        listDataLagu.add(new LaguModel("Chasing Pavements", "Adele", R.drawable.cover14, "https://open.spotify.com/track/0Z5ok0QLLttAKsujOZYOXf?si=9331d82383014d4e", "https://id.wikipedia.org/wiki/Adele"));
        listDataLagu.add(new LaguModel("The Night We Met", "Lord Huron", R.drawable.cover15, "https://open.spotify.com/track/5yJaXWIErrrsjQ3J0eR5aK?si=b009555e988c4803", "https://en.wikipedia.org/wiki/Lord_Huron"));

        AdapterLagu adapter = new AdapterLagu(listDataLagu, new AdapterLagu.OnItemClickListener() {
            @Override
            public void onItemClick(LaguModel lagu) {
                Intent in = new Intent(list_lagu.this, DetailLagu.class);
                in.putExtra("DATA_LAGU", lagu);
                startActivity(in);
            }
        });

        rvListLagu.setLayoutManager(new LinearLayoutManager(this));
        rvListLagu.setAdapter(adapter);
    }
}