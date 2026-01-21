package com.diazt.projectpretest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_page2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView btnBack = findViewById(R.id.btnBack);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnMaps = findViewById(R.id.btnMaps);

        btnBack.setOnClickListener( v -> {
            Intent intent = new Intent(DetailPage2.this, MainActivity.class);
            startActivity(intent);
        });

        btnMaps.setOnClickListener( v -> {
            Uri IntentUri = Uri.parse("geo:0,0?q=Pantai+Parangtritis+Yogyakarta");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, IntentUri);

            mapIntent.setPackage("com.google.android.apps.maps");

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        });

        btnCall.setOnClickListener( v -> {
            String nomor = "0813-6478-0043";
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + nomor));
            startActivity(call);
        });
    }
}