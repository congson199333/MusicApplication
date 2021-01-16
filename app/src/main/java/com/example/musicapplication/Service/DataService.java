package com.example.musicapplication.Service;



import com.example.musicapplication.Model.Album;
import com.example.musicapplication.Model.Baihat;
import com.example.musicapplication.Model.ChuDe;
import com.example.musicapplication.Model.Playlist;
import com.example.musicapplication.Model.Quangcao;
import com.example.musicapplication.Model.TheLoai;
import com.example.musicapplication.Model.TheLoaiTrongNgay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> getPlayListCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<TheLoaiTrongNgay> getCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> getAlbumHot();

    @GET("baihatduocyeuthich.php")
    Call<List<Baihat>> getBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoQuangCao(@Field("idquangcao") String idQuangCao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoPlayList(@Field("idplaylist") String idPlayList);


    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> getDanhSachPlaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoTheLoai(@Field("idtheloai") String idTheLoai);

    @GET("tatcachude.php")
    Call<List<ChuDe>> getAllChuDe();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> getTheLoaiTheoChuDe(@Field("idchude") String idChuDe);

    @GET("tatcaalbum.php")
    Call<List<Album>> getAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getBaiHatTheoAlbum(@Field("idalbum") String idAlbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> updateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<Baihat>> getSearchBaiHat(@Field("tukhoa") String tuKhoa);

}
