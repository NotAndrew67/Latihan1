package com.example.latihan1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListSiswa extends AppCompatActivity {

    RecyclerView rvlistsiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_siswa);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvlistsiswa = findViewById(R.id.rvlistsiswa);
        ArrayList<SiswaModel> listdatasiswa = new ArrayList<>();

        listdatasiswa.add(new SiswaModel("Albay", "Kudus", "1", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Abdil", "Kudus", "2", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Zizou", "Mayong", "3", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Rahman", "Kudus", "4", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Haqi", "Kuningan", "5", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Bhisma", "Jakarta", "6", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Nesa", "Kudus", "7", R.drawable.putellas, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Diwa", "Blora", "8", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Devo", "Kudus", "9", R.drawable.bale, "Ini Profil Lengkapnya Albay"));
        listdatasiswa.add(new SiswaModel("Dzakiy", "Kudus", "10", R.drawable.bale, "Ini Profil Lengkapnya Albay"));

        AdapterListSiswa adapter = new AdapterListSiswa(listdatasiswa, new AdapterListSiswa.OnItemClickListener() {
            @Override
            public void onItemClick(SiswaModel siswa) {
                Intent in = new Intent(ListSiswa.this, detail_listsiswa.class);
                in.putExtra("DATA_SISWA", siswa);
                startActivity(in);
            }
        });

        rvlistsiswa.setLayoutManager(new LinearLayoutManager(this));
        rvlistsiswa.setAdapter(adapter);
    }
}
