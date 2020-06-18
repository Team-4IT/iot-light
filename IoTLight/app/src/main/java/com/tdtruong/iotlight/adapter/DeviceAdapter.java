package com.tdtruong.iotlight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tdtruong.iotlight.Model.Device;
import com.tdtruong.iotlight.R;

import java.util.ArrayList;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Device> mDevices;

    public DeviceAdapter (Context mContext, ArrayList<Device> mDevices){
        this.mContext = mContext;
        this.mDevices = mDevices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View deviceView = inflater.inflate(R.layout.custom_list_device, parent, false);
        ViewHolder viewHolder = new ViewHolder(deviceView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Device device = mDevices.get(position);
        holder.mDeviceName.setText(device.getId());
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mDeviceName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mDeviceName = itemView.findViewById(R.id.tvDeviceName);
        }
    }
}
