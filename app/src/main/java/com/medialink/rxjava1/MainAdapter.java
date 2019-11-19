package com.medialink.rxjava1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.medialink.rxjava1.model.Pimpinan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private static final String TAG = "MainAdapter";

    private Context mContext;
    private List<Pimpinan> mList;
    private AdapterCallback mCallback;

    public MainAdapter(Context mContext, AdapterCallback mCallback) {
        this.mContext = mContext;
        this.mCallback = mCallback;
    }

    public void setData(ArrayList<Pimpinan> list) {
        if (mList == null) mList = new ArrayList<>();
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.rv_main_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pimpinan item = mList.get(position);
        holder.tvJabatan.setText(item.getJabatan());
        holder.tvNmPimpinan.setText(item.getNmPimpinan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onRowClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nm_pimpinan)
        TextView tvNmPimpinan;
        @BindView(R.id.tv_jabatan)
        TextView tvJabatan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface AdapterCallback {
        void onRowClick(Pimpinan data);
    }

}
