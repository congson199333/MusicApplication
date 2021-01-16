package com.example.musicapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicapplication.Model.Playlist;
import com.example.musicapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayListAdapter extends ArrayAdapter<Playlist> {

    public PlayListAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txtTenPlayList;
        ImageView imgBackGround, imgPlayList;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.dong_playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.txtTenPlayList = convertView.findViewById(R.id.textviewtenplaylist);
            viewHolder.imgPlayList = convertView.findViewById(R.id.imageviewplaylist);
            viewHolder.imgBackGround = convertView.findViewById(R.id.imagebackgroundplaylist);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playList = getItem(position);
//        Picasso.with(getContext()).load(playList.getHinhnen()).into(viewHolder.imgBackGround);
        Picasso.with(getContext()).load(playList.getHinhnen()).into(viewHolder.imgBackGround);
        Picasso.with(getContext()).load(playList.getHinhicon()).into(viewHolder.imgPlayList);
        Log.d("BBB", playList.getHinhnen()+" ===== "+ playList.getHinhicon());
        viewHolder.txtTenPlayList.setText(playList.getTen());

       /* convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"m",Toast.LENGTH_SHORT).show();
            }
        });*/

        return convertView;
    }
}
