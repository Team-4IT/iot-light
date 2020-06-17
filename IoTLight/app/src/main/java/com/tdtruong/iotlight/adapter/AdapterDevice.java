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

public class AdapterDevice extends RecyclerView.Adapter<AdapterDevice.DeviceViewHolder>{
    private ArrayList<Device> mDevices;

    public AdapterDevice(ArrayList<Device> devices) {
        mDevices = devices;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.device_item, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        Device device = mDevices.get(position);
        holder.txtDeviceName.setText(device.getId());
        holder.txtPosition.setText(device.getPosition());
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder{

        private TextView txtDeviceName;
        private TextView txtPosition;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDeviceName = itemView.findViewById(R.id.device_id);
            txtPosition = itemView.findViewById(R.id.device_position);
        }

    }
}
