package com.codehub.android_course;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AbstractActivity implements View.OnLongClickListener {
    @Nullable
    Toolbar toolbar;
    @Nullable
    RecyclerView recyclerView;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initLayout() {
        //RecyclerView recyclerView = findViewById(R.id.recycler);

//        Date timestamp = new Date(System.currentTimeMillis());
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
//
//        play_now_adapter adapter = new play_now_adapter(new PlayNowDiffUtils());
//        if(recyclerView != null){
//            recyclerView.setAdapter(adapter);
//        }


//        List<ChannelsModel> data = new ArrayList<ChannelsModel>();
//        data.add(new ChannelsModel("teo",sdf.format(timestamp), R.drawable.ic_channel_ant1, 0));
//        data.add(new PlayNowString("teo",sdf.format(timestamp), R.drawable.ic_channel_alpha, 0));
//        data.add(new PlayNowString("teo",sdf.format(timestamp), R.drawable.ic_channel_star, 0));
//        adapter.submitList(data);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, R.string.app_name, Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        Button btn1 = findViewById(R.id.btn2);
        btn1.setOnLongClickListener(this);

        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public void runOperation() {

        if(toolbar != null){
            toolbar.setTitle(getString(R.string.app_name));
        }

        makeAnAPICall();
    }

    @Override
    public void stopOperation() {

    }

    @Override
    public void destroyLayout() {

    }

    private void makeAnAPICall(){

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://tv-zapping.herokuapp.com/v2/tv";

        GsonRequest<ProgramModel> gsonRequest = new GsonRequest<ProgramModel>(url, ProgramModel.class, new HashMap<String, String>(), new Response.Listener<ProgramModel>() {
            @Override
            public void onResponse(ProgramModel response) {

                if(recyclerView == null) {
                   return;
                }

                RecyclerView.Adapter usedAdapter = recyclerView.getAdapter();
                if(usedAdapter instanceof play_now_adapter){
                    ((play_now_adapter) usedAdapter).submitList(response.getChannels());
                }else{
                    play_now_adapter adapter = new play_now_adapter(new PlayNowDiffUtils());
                    recyclerView.setAdapter(adapter);
                    adapter.submitList(response.getChannels());
                }
               // Log.i("RESPONSE", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(gsonRequest);

        // Request a string response from the provided URL.
       // StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
     //           new Response.Listener<String>() {
      //              @Override
      //              public void onResponse(String response) {
      //                  // Display the first 500 characters of the response string.
       //                 //textView.setText("Response is: "+ response.substring(0,500));
       //                 Log.i("Response",response);
       //             }
       //         }, new Response.ErrorListener() {
       //     @Override
       //     public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
       //     }});


    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, this.getString(R.string.app_name), Toast.LENGTH_LONG).show();
        return  false;
    }

}
