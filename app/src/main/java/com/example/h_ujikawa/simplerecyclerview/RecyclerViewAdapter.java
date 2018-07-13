package com.example.h_ujikawa.simplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.h_ujikawa.simplerecyclerview.databinding.RowBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> dataSet;

    static class ViewHolder extends RecyclerView.ViewHolder {
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