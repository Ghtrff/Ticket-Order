package com.example.projectppb;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Calendar;

public class TransportActivity extends AppCompatActivity {
    // Deklarasi variabel
    private EditText editTextNama, editTextTanggal;
    private Spinner spinnerKeberangkatan, spinnerTujuan;
    private Button btnMinus, btnPlus, btnPesan;
    private TextView tvJumlah;
    private int jumlahPenumpang = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        // Inisialisasi view
        editTextNama = findViewById(R.id.editTextNama);
        editTextTanggal = findViewById(R.id.editTextTanggal);
        spinnerKeberangkatan = findViewById(R.id.spinnerKeberangkatan);
        spinnerTujuan = findViewById(R.id.spinnerTujuan);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnPesan = findViewById(R.id.btnPesan);
        tvJumlah = findViewById(R.id.tvJumlah);

        // Setup spinner
        String[] kota = {"Jakarta", "Surabaya", "Bandung", "Yogyakarta", "Semarang"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, kota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerKeberangkatan.setAdapter(adapter);
        spinnerTujuan.setAdapter(adapter);

        // Setup tombol tambah/kurang
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahPenumpang++;
                tvJumlah.setText(String.valueOf(jumlahPenumpang));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jumlahPenumpang > 0) {
                    jumlahPenumpang--;
                    tvJumlah.setText(String.valueOf(jumlahPenumpang));
                }
            }
        });

        editTextTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int tahun = c.get(Calendar.YEAR);
                int bulan = c.get(Calendar.MONTH);
                int hari = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TransportActivity.this,
                        new OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                editTextTanggal.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, tahun, bulan, hari);
                datePickerDialog.show();
            }
        });

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String tanggal = editTextTanggal.getText().toString();
                String dari = spinnerKeberangkatan.getSelectedItem().toString();
                String tujuan = spinnerTujuan.getSelectedItem().toString();

                String pesan = "Pemesanan tiket:\n" +
                        "Nama: " + nama + "\n" +
                        "Dari: " + dari + "\n" +
                        "Tujuan: " + tujuan + "\n" +
                        "Tanggal: " + tanggal + "\n" +
                        "Jumlah Penumpang: " + jumlahPenumpang;

                Toast.makeText(TransportActivity.this, pesan, Toast.LENGTH_LONG).show();
            }
        });
    }
}