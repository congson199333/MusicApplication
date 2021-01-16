package com.example.musicapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapplication.Activity.PlayNhacActivity;
import com.example.musicapplication.Model.Baihat;
import com.example.musicapplication.R;
import com.example.musicapplication.Service.APIService;
import com.example.musicapplication.Service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangBaiHat;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihat> mangBaiHat) {
        this.context = context;
        this.mangBaiHat = mangBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_danh_sach_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baiHat = mangBaiHat.get(position);
        holder.txtCaSi.setText(baiHat.getCaSi());
        holder.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.txtIndex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtIndex, txtTenBaiHat, txtCaSi;
        ImageView imgLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCaSi = itemView.findViewById(R.id.textviewtencasi);
            txtIndex = itemView.findViewById(R.id.textviewdanhsachindex);
            txtTenBaiHat = itemView.findViewById(R.id.textviewtenbaihat);
            imgLuotThich = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);
            imgLuotThich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgLuotThich.setImageResource(R.drawable.iconloved);
                    DataService dataService = APIService.getService();
                    Call<String> callBack = dataService.updateLuotThich("1",mangBaiHat.get(getPosition()).getIdBaiHat());
                    callBack.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketQua = response.body();
                            if (ketQua.equals("Success")){
                                Toast.makeText(context,"Đã Thích",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context,"Bị Lỗi",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgLuotThich.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", mangBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
