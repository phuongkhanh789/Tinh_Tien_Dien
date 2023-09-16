package com.example.tiendien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText EdtCSD,EdtCSC,EdtSOKW,EdtTong,EdtThue,EdtTongTien;
    Button Tinh,Thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getall();
        Event();
    }
    private void Event()
    {
        Tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EdtCSC.getText().toString().isEmpty() || EdtCSD.getText().toString().isEmpty()) {
                    Toast.makeText(getApplication(), "Vui Lòng Nhập Đủ Chỉ Số Đầu Và Cuối", Toast.LENGTH_LONG).show();
                } else {
                    int CSD = Integer.parseInt(EdtCSD.getText().toString());
                    int CSC = Integer.parseInt(EdtCSC.getText().toString());
                    if (CSD >= CSC)
                        Toast.makeText(getApplication(), "Vui Lòng Nhập Đúng Chỉ Số Đầu Và Cuối", Toast.LENGTH_LONG).show();
                    else {
                        double Tong = 0;
                        double SoKW = CSC - CSD;
                        if (SoKW < 100)
                            Tong = SoKW * 2000;
                        else {
                            if (SoKW <= 200)
                                Tong = (99 * 2000) + (SoKW - 99) * 2500;
                            else {
                                if (SoKW > 200)
                                    Tong = (99 * 2000) + (101 * 2500) + (SoKW - 200) * 3000;
                            }
                        }
                        double Thue = Tong * 0.1;
                        EdtTong.setText(String.valueOf(Tong));
                        EdtSOKW.setText(String.valueOf(SoKW));
                        EdtThue.setText(String.valueOf(Thue));
                        double TongTien = Tong + Thue;
                        EdtTongTien.setText(String.valueOf(TongTien));
                    }
                }
            }
        });
        Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void getall()
    {
        EdtCSD=(EditText)findViewById(R.id.chisodau);
        EdtCSC=(EditText)findViewById(R.id.chisocuoi);
        EdtSOKW=(EditText)findViewById(R.id.SoKwSuDung);
        EdtTong=(EditText)findViewById(R.id.TongTien);
        EdtThue=(EditText)findViewById(R.id.ThueVAT);
        EdtTongTien=(EditText)findViewById(R.id.TongTienSauThue);
        Tinh=(Button)findViewById(R.id.BtnTinh);
        Thoat=(Button)findViewById(R.id.BtnThoat);
    }
}