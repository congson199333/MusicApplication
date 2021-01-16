package com.example.musicapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.Adapter.DanhSachAlbumAdapter;
import com.example.musicapplication.Model.Album;
import com.example.musicapplication.R;
import com.example.musicapplication.Service.APIService;
import com.example.musicapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachAlbumActivity extends AppCompatActivity {
    RecyclerView recyclerViewAlbum;
    Toolbar toolbarAlbum;
    DanhSachAlbumAdapter danhSachAlbumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_album);
        init();
        GetData();
    }


    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> callBack = dataService.getAlbum();
        callBack.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangAlbum = (ArrayList<Album>) response.body();
                danhSachAlbumAdapter = new DanhSachAlbumAdapter(DanhSachAlbumActivity.this,mangAlbum);
                recyclerViewAlbum.setLayoutManager(new GridLayoutManager(DanhSachAlbumActivity.this,2));
                recyclerViewAlbum.setAdapter(danhSachAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
    private void init() {
        recyclerViewAlbum = findViewById(R.id.recycleviewallalbum);
        toolbarAlbum = findViewById(R.id.toolbaralbum);
        setSupportActionBar(toolbarAlbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Các Album");
        toolbarAlbum.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbarAlbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}