package com.example.avni.avnisradio.Holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avni.avnisradio.Model.Station;
import com.example.avni.avnisradio.R;

public class StationsViewHolder extends RecyclerView.ViewHolder {

    private ImageView mainImage;
    private TextView titleTextView;

    public StationsViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mainImage = (ImageView) itemView.findViewById(R.id.main_image);
        this.titleTextView = (TextView) itemView.findViewById(R.id.main_text);
    }

    public void updateUI (Station station) {
        String uri = station.getImgUri();
        int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);

        titleTextView.setText(station.getStationTitle());
    }
}
