package com.example.avni.avnisradio.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.avni.avnisradio.Fragments.DetailsFragment;
import com.example.avni.avnisradio.Fragments.MainFragment;
import com.example.avni.avnisradio.Model.Station;
import com.example.avni.avnisradio.R;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager manager = getSupportFragmentManager();
        MainFragment fragment = (MainFragment) manager.findFragmentById(R.id.container_main);

        if(fragment == null) {
            fragment = MainFragment.newInstance("blah","kah");
            manager.beginTransaction().add(R.id.container_main, fragment).commit();
        }
    }

    public void loadDetailScreen(Station selectedStation) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_main, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
