package com.codehub.android_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ChannelActivity extends AbstractActivity {


    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    public void initLayout() {
        Bundle parameters = getIntent().getExtras();
        parameters.getString("variable");
        parameters.getBoolean("variableBoolean");
    }

    @Override
    public void runOperation() {

    }

    @Override
    public void stopOperation() {

    }

    @Override
    public void destroyLayout() {

    }

    private void gotoChannel(){
        //to interact with a another activity use intent
        Intent intent = new Intent(this, ChannelActivity.class);

        //before startactivity create a bundle
        Bundle parameters = new Bundle();
        parameters.putString("variable","Vassilis");
        parameters.putBoolean("variableBoolean",true);

        intent.putExtras(parameters);

        startActivity(intent);
    }
}
