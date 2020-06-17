package com.tdtruong.iotlight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tdtruong.iotlight.Model.Notification;
import com.tdtruong.iotlight.R;

import java.util.ArrayList;

public class AdapterNotification extends ArrayAdapter {

    ArrayList<Notification> warniglist = new ArrayList<>();

    public AdapterNotification(@NonNull Context context, int resource , ArrayList object) {
        super(context, resource, object);

        warniglist = object;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.customview, null);
        TextView txttitle = (TextView) v.findViewById(R.id.title1);
        TextView txtcontent = (TextView) v.findViewById(R.id.content1);
        ImageView imageView = (ImageView) v.findViewById(R.id.imgwarning);

        txttitle.setText(warniglist.get(position).getTitle());
        txtcontent.setText(warniglist.get(position).getContent());
        imageView.setImageResource(warniglist.get(position).getWarningimage());
        return v;
    }
}
