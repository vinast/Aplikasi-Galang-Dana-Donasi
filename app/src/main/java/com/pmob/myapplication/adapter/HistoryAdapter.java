package com.pmob.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pmob.myapplication.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    List<com.pmob.myapplication.model.ModelDatabase> modelDatabase;
    Context mContext;
    RiwayatAdapterCallback mAdapterCallback;

    public HistoryAdapter(Context context, List<com.pmob.myapplication.model.ModelDatabase> modelInputList,
                          RiwayatAdapterCallback adapterCallback) {
        this.mContext = context;
        this.modelDatabase = modelInputList;
        this.mAdapterCallback = adapterCallback;
    }

    public void setDataAdapter(List<com.pmob.myapplication.model.ModelDatabase> items) {
        modelDatabase.clear();
        modelDatabase.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_riwayat,
                parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        final com.pmob.myapplication.model.ModelDatabase data = modelDatabase.get(position);

        holder.tvJumlahDonasi.setText(com.pmob.myapplication.util.FunctionHelper.rupiahFormat(data.jmlUang));
        holder.tvTanggal.setText(com.pmob.myapplication.util.FunctionHelper.setDataTime());
    }

    @Override
    public int getItemCount() {
        return modelDatabase.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvJumlahDonasi, tvTanggal;
        public ImageView imageDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJumlahDonasi = itemView.findViewById(R.id.tvJumlahDonasi);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            imageDelete = itemView.findViewById(R.id.imageDelete);

            imageDelete.setOnClickListener(view -> {
                com.pmob.myapplication.model.ModelDatabase modelLaundry = modelDatabase.get(getAdapterPosition());
                mAdapterCallback.onDelete(modelLaundry);
            });
        }
    }

    public interface RiwayatAdapterCallback {
        void onDelete(com.pmob.myapplication.model.ModelDatabase modelDatabase);
    }

}

