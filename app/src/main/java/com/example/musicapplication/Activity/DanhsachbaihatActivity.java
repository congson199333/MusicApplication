package com.example.musicapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.musicapplication.Adapter.DanhsachbaihatAdapter;
import com.example.musicapplication.Model.Album;
import com.example.musicapplication.Model.Baihat;
import com.example.musicapplication.Model.Playlist;
import com.example.musicapplication.Model.Quangcao;
import com.example.musicapplication.Model.TheLoai;
import com.example.musicapplication.R;
import com.example.musicapplication.Service.APIService;
import com.example.musicapplication.Service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewDanhSachBaiHat;
    FloatingActionButton floatingActionButton;
    ImageView imgDanhSachCaKhuc;
    ArrayList<Baihat> mangBaiHat;
    DanhsachbaihatAdapter danhSachBaiHatAdapter;
    Quangcao quangCao;
    Playlist playList;
    TheLoai theLoai;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);

        DataIntent();
        anhxa();
        init();
        if(quangCao != null && !quangCao.getTenBaiHat().equals("")){
            setValueInView(quangCao.getTenBaiHat(),quangCao.getHinhBaiHat());
            getDataQuangCao(quangCao.getIdQuangCao());
        }
        if(playList != null && !playList.getTen().equals("")){
            setValueInView(playList.getTen(),playList.getHinhnen());
            getDataPlayList(playList.getIdPlayList());
        }
        if(theLoai != null && !theLoai.getTenTheLoai().equals("")){
            setValueInView(theLoai.getTenTheLoai(),theLoai.getHinhTheLoai());
            getDataTheLoai(theLoai.getIdTheLoai());
        }

        if(album != null && !album.getTenAlbum().equals("")){
            setValueInView(album.getTenAlbum(),album.getHinhAlbum());
            getDataAlbum(album.getIdAlbum());
        }
    }

    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
//            if (android.os.Build.VERSION.SDK_INT > 9) {
//                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//                StrictMode.setThreadPolicy(policy);
//            }
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgDanhSachCaKhuc);
    }
    private void getDataTheLoai(String idTheLoai){
        DataService dataService = APIService.getService();
        Call<List<Baihat>> callBack = dataService.getDanhSachBaiHatTheoTheLoai(idTheLoai);
        callBack.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangBaiHat = (ArrayList<Baihat>) response.body();
                danhSachBaiHatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangBaiHat);
                recyclerViewDanhSachBaiHat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewDanhSachBaiHat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void getDataPlayList(String idPlayList) {
        DataService dataService = APIService.getService();
        Call<List<Baihat>> callBack = dataService.getDanhSachBaiHatTheoPlayList(idPlayList);
        callBack.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangBaiHat = (ArrayList<Baihat>) response.body();
                danhSachBaiHatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangBaiHat);
                recyclerViewDanhSachBaiHat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewDanhSachBaiHat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
    private void getDataQuangCao(String idQuangCao) {
        DataService dataService = APIService.getService();
        Call<List<Baihat>> callBack = dataService.getDanhSachBaiHatTheoQuangCao(idQuangCao);
        callBack.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangBaiHat = (ArrayList<Baihat>) response.body();
                danhSachBaiHatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangBaiHat);
                recyclerViewDanhSachBaiHat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewDanhSachBaiHat.setAdapter(danhSachBaiHatAdapter);
                eventClick();


            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
    private void getDataAlbum(String idAlbum) {
        DataService dataService = APIService.getService();
        Call<List<Baihat>> callBack = dataService.getBaiHatTheoAlbum(idAlbum);
        callBack.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangBaiHat = (ArrayList<Baihat>) response.body();
                danhSachBaiHatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangBaiHat);
                recyclerViewDanhSachBaiHat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewDanhSachBaiHat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewDanhSachBaiHat = findViewById(R.id.recycleviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgDanhSachCaKhuc = findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangCao = (Quangcao) intent.getSerializableExtra("banner");
            }
            if (intent.hasExtra("itemplaylist")){
                playList = (Playlist) intent.getSerializableExtra("itemplaylist");
            }
            if(intent.hasExtra("idtheloai")){
                theLoai = (TheLoai) intent.getSerializableExtra("idtheloai");
            }
            if(intent.hasExtra("album")){
                album = (Album) intent.getSerializableExtra("album");
            }

        }
    }

    private void eventClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhsachbaihatActivity.this,PlayNhacActivity.class);
                intent.putExtra("cacbaihat",mangBaiHat);
                startActivity(intent);
            }
        });
    }
}