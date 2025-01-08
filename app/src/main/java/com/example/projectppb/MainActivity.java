package com.example.projectppb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.example.projectppb.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvUsername;
    private EditText editTextSearch;
    private CardView cardPesawat, cardKapal, cardKereta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);
        editTextSearch = findViewById(R.id.editTextSearch);
        cardPesawat = findViewById(R.id.cardPesawat);
        cardKapal = findViewById(R.id.cardKapal);
        cardKereta = findViewById(R.id.cardKereta);

        tvUsername.setText("Muhammad Raka");

        cardPesawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransportActivity("Pesawat");
            }
        });

        cardKapal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransportActivity("Kapal Laut");
            }
        });

        cardKereta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransportActivity("Kereta");
            }
        });
    }

    private void openTransportActivity(String transportType) {
        Intent intent = new Intent(MainActivity.this, com.example.projectppb.TransportActivity.class);
        intent.putExtra("jenis_transportasi", transportType);
        startActivity(intent);
    }
}