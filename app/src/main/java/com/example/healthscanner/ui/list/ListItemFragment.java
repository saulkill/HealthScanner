package com.example.healthscanner.ui.list;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.healthscanner.MainActivity;
import com.example.healthscanner.R;
import com.example.healthscanner.databinding.FragmentListBinding;
import com.example.healthscanner.ui.list.database.DataViewModer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListItemFragment extends Fragment {
    public FragmentListBinding binding;
    public ListItemFragment(){

    }
    MainActivity activity;

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<>());
        binding.reviewlist.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.reviewlist.setAdapter(recyclerViewAdapter);

        DataViewModer viewModer = ViewModelProviders.of(this).get(DataViewModer.class);

        viewModer.getLiveData().observe(ListItemFragment.this,recyclerViewAdapter::setDataEntities);
//        Button buttonSaveFragment = root.findViewById(R.id.button3);
//        buttonSaveFragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                activity.onFragmentChange(1);
//            }
//        });
        return root;
    }
}