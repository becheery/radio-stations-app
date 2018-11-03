package com.example.avni.avnisradio.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avni.avnisradio.Activities.MainActivity;
import com.example.avni.avnisradio.Holders.StationsViewHolder;
import com.example.avni.avnisradio.Model.Station;
import com.example.avni.avnisradio.R;

import java.util.ArrayList;

import static com.example.avni.avnisradio.R.*;

public class StationsAdapter extends RecyclerView.Adapter<StationsViewHolder> {

    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @NonNull
    @Override
    public StationsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View stationCard = LayoutInflater.from(viewGroup.getContext()).inflate(layout.card_station, viewGroup, false);

        return new StationsViewHolder(stationCard);
    }

    @Override
    public void onBindViewHolder(@NonNull StationsViewHolder stationsViewHolder, int i) {
        final Station station = stations.get(i);
        stationsViewHolder.updateUI(station);

        stationsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Load the detail screen
                MainActivity.getMainActivity().loadDetailScreen(station);
            }
        });
    }
}
