package com.codehub.android_course;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PlayNowHolder extends RecyclerView.ViewHolder {


    public PlayNowHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(PlayNowString data){
        TextView textView = itemView.findViewById(R.id.holder_play_now_title);
        textView.setText(data.getVar1());

        TextView textView1 = itemView.findViewById(R.id.holder_play_now_timestamp);
        textView1.setText(data.getVar2());

        ImageView imageView1 = itemView.findViewById(R.id.holder_play_now_channel);
        imageView1.setImageResource(data.getVar3());
    }
}