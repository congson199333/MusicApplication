package com.example.musicapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.musicapplication.Activity.DanhsachbaihatActivity;
import com.example.musicapplication.Activity.DanhsachcacplaylistActivity;
import com.example.musicapplication.Adapter.PlayListAdapter;
import com.example.musicapplication.Model.Playlist;
import com.example.musicapplication.R;
import com.example.musicapplication.Service.APIService;
import com.example.musicapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Playlist extends Fragment {
    View view;
    ListView lvPlayList;
    TextView txtTitlePlayList,txtViewXemThemPlayList;
    PlayListAdapter playListAdapter;
    ArrayList<Playlist> arrayListPlayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        lvPlayList = view.findViewById(R.id.listviewplaylist);
        txtTitlePlayList = view.findViewById(R.id.textviewtitleplaylist);
        txtViewXemThemPlayList = view.findViewById(R.id.textviewmoreplaylist);
        getData();
        txtViewXemThemPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhsachcacplaylistActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void getData() {
        DataService dataService = APIService.getService();
        Call<List<Playlist>> callBack = dataService.getPlayListCurrentDay();
        callBack.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                arrayListPlayList = (ArrayList<Playlist>) response.body();
                playListAdapter = new PlayListAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayListPlayList);
                lvPlayList.setAdapter(playListAdapter);
                setListViewHeightBasedOnChildren(lvPlayList);
                lvPlayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                        intent.putExtra("itemplaylist", arrayListPlayList.get(position));
                        startActivity(intent);
                    }

                });
//               lvPlayList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//                   @Override
//                   public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                       Intent intent = new Intent(getActivity(), DanhSachBaiHatActivity.class);
//                       intent.putExtra("itemplaylist", arrayListPlayList.get(position));
//                       startActivity(intent);
//                       return true;
//                   }
//               });

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
