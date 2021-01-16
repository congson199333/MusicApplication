package com.example.musicapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.Adapter.DanhsachtatcachudeAdapter;
import com.example.musicapplication.Model.ChuDe;
import com.example.musicapplication.R;
import com.example.musicapplication.Service.APIService;
import com.example.musicapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcachudeActivity extends AppCompatActivity {
    RecyclerView recyclerViewChuDe;
    Toolbar toolbarChuDe;
    DanhsachtatcachudeAdapter danhSachChuDeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);

        init();
        getData();
    }
    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<ChuDe>> callBack = dataService.getAllChuDe();
        callBack.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangChuDe = (ArrayList<ChuDe>) response.body();
                danhSachChuDeAdapter = new DanhsachtatcachudeAdapter(DanhsachtatcachudeActivity.this,mangChuDe);
                recyclerViewChuDe.setLayoutManager(new GridLayoutManager(DanhsachtatcachudeActivity.this,1));
                recyclerViewChuDe.setAdapter(danhSachChuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }


    private void init() {
        recyclerViewChuDe = findViewById(R.id.recycleviewchude);
        toolbarChuDe = findViewById(R.id.toolbarchude);
        setSupportActionBar(toolbarChuDe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarChuDe.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbarChuDe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}