package com.example.musicapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.Activity.DanhsachbaihatActivity;
import com.example.musicapplication.Model.Album;
import com.example.musicapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachAlbumAdapter extends RecyclerView.Adapter<DanhSachAlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> albumArrayList = new ArrayList<>();

    public DanhSachAlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_all_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imgAlbum);
        holder.txtAlbum.setText(album.getTenAlbum());
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgAlbum;
        TextView txtAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.imageviewdanhsachalbum);
            txtAlbum = itemView.findViewById(R.id.textviewdanhsachalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album",albumArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
