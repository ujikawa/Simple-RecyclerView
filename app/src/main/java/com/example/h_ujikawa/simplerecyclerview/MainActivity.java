package com.example.h_ujikawa.simplerecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.h_ujikawa.simplerecyclerview.databinding.ActivityMainBinding;
import com.example.h_ujikawa.simplerecyclerview.databinding.RowBinding;

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

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List<String> dataSet;

        class ViewHolder extends RecyclerView.ViewHolder {
            final RowBinding binding;

            ViewHolder(RowBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

        RecyclerViewAdapter(List<String> myDataSet) {
            dataSet = myDataSet;
        }

        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RowBinding binding = RowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String text = dataSet.get(position);
            holder.binding.rowTextView.setText(text);
            holder.binding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

    }
}
