package com.example.h_ujikawa.simplerecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.h_ujikawa.simplerecyclerview.databinding.ActivityMainBinding;
import com.example.h_ujikawa.simplerecyclerview.databinding.RowBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter recyclerViewAdapter;
    private List<String> dataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(getListData());
        binding.recyclerView.setAdapter(recyclerViewAdapter);

        ItemTouchHelper mIth = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        final int toPos = target.getAdapterPosition();
                        recyclerViewAdapter.notifyItemMoved(fromPos, toPos);
                        return true;// true if moved, false otherwise
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        dataset.remove(fromPos);
                        recyclerViewAdapter.notifyItemRemoved(fromPos);
                    }
                }
        );
        mIth.attachToRecyclerView(binding.recyclerView);
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
        dataset = list;
        return list;
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List<String> dataSet;

        RecyclerViewAdapter(List<String> myDataSet) {
            dataSet = myDataSet;
        }

        @Override //ViewHolderを返す
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RowBinding binding = RowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);
        }

        @Override //ViewHolderを貰ってデータと紐付け
        public void onBindViewHolder(ViewHolder holder, int position) {
            String text = dataSet.get(position);
            holder.binding.rowTextView.setText(text);
            holder.binding.executePendingBindings();
        }

        @Override //このカウント数分のonBindViewHolderが呼ばれる
        public int getItemCount() {
            return dataSet.size();
        }

        //Viewへの参照を持つ
        class ViewHolder extends RecyclerView.ViewHolder {
            final RowBinding binding;

            ViewHolder(RowBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

    }
}
