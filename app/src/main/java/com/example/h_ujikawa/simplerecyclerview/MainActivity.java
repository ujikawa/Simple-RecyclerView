package com.example.h_ujikawa.simplerecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.h_ujikawa.simplerecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(getListData());
        binding.recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<String> getListData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("睦月");
        list.add("如月");
        list.add("弥生");
        list.add("卯月");
        list.add("皐月");
        list.add("水無月");
        list.add("文月");
        list.add("葉月");
        list.add("長月");
        list.add("神無月");
        list.add("霜月");
        list.add("師走");
        return list;
    }
}
