package com.example.healthscanner.ui.list;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.healthscanner.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListItemFragment extends Fragment {
    ArrayList<ListData> listData;
    ListView customListView;
    private static ListViewAdapter listViewAdapter;
    String json = "";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        //data를 가져와서 어답터와 연결해 준다. 서버에서 가져오는게 대부분 이다.


        listData = new ArrayList<>();

            try{
                JSONObject jsonObject = new JSONObject(json);

                JSONArray diseaseArray = jsonObject.getJSONArray("Movies");

                for(int i=0; i<diseaseArray.length(); i++)
                {
                    JSONObject diseaseObject = diseaseArray.getJSONObject(i);

                    ListData diseaselistData = new ListData();

                    diseaselistData.setTitleStr(diseaseObject.getString("title"));
                    diseaselistData.setDescStr(diseaseObject.getString("grade"));
                    diseaselistData.setImageResourceID(diseaseObject.getString("category"));

                    listData.add(diseaselistData);
                }
            }catch (JSONException e) {
                e.printStackTrace();
            }

        customListView = (ListView) rootView.findViewById(R.id.list);
        listViewAdapter = new ListViewAdapter(getContext(),listData);
        customListView.setAdapter(listViewAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String) view.findViewById(R.id.textView1).getTag().toString();
                Toast.makeText(getContext(), "Clicked: " + position +" " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
    private String getJsonString()
    {

        AssetManager assetManager = getResources().getAssets();
        try {
            InputStream is = assetManager.open("jsons/test.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return json;
    }



}