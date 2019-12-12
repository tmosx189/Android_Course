package com.codehub.android_course;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AbstractActivity {
    @Nullable
    Toolbar toolbar;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initLayout() {
        RecyclerView recyclerView = findViewById(R.id.recycler);

        Date timestamp = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());

        play_now_adapter adapter = new play_now_adapter(new PlayNowDiffUtils());
        recyclerView.setAdapter(adapter);

        List<PlayNowString> data = new ArrayList<PlayNowString>();
        data.add(new PlayNowString("teo",sdf.format(timestamp), R.drawable.ic_channel_ant1, 0));
        data.add(new PlayNowString("teo",sdf.format(timestamp), R.drawable.ic_channel_alpha, 0));
        data.add(new PlayNowString("teo",sdf.format(timestamp), R.drawable.ic_channel_star, 0));
        

        adapter.submitList(data);
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public void runOperation() {

        if(toolbar != null){
            toolbar.setTitle(getString(R.string.app_name));
        }
    }

    @Override
    public void stopOperation() {

    }

    @Override
    public void destroyLayout() {

    }
}
