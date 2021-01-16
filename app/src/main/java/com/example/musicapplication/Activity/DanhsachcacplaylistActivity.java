package com.example.musicapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.musicapplication.Adapter.DanhSachCacPlaylistAdapter;
import com.example.musicapplication.Model.Playlist;
import com.example.musicapplication.R;
import com.example.musicapplication.Service.APIService;
import com.example.musicapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcacplaylistActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewDanhSachPlaylist;
    DanhSachCacPlaylistAdapter danhSachPlaylistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcacplaylist);
        anhXa();
        init();
        getData();
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<Playlist>> callBack = dataService.getDanhSachPlaylist();
        callBack.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangPlaylist = (ArrayList<Playlist>) response.body();
                danhSachPlaylistAdapter = new DanhSachCacPlaylistAdapter(DanhsachcacplaylistActivity.this,mangPlaylist);
                recyclerViewDanhSachPlaylist.setLayoutManager(new GridLayoutManager(DanhsachcacplaylistActivity.this,2));
                recyclerViewDanhSachPlaylist.setAdapter(danhSachPlaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Playlists");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        toolbar = findViewById(R.id.toolbardanhsachplaylist);
        recyclerViewDanhSachPlaylist = findViewById(R.id.recycleviewdanhsachplaylist);

    }
}