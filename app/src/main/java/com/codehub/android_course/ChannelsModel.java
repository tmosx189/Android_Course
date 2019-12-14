package com.codehub.android_course;

import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ChannelsModel {
    private String channelName;
    private List<ShowsModel> shows;

    public String getChannelName() {
        return channelName;
    }

    public List<ShowsModel> getShows() {
        return shows;
    }

    public ShowsModel getPlayNow() {
        int position = getPlayNowPosition();

        if (position > 0 && position < shows.size()) {
            return shows.get(position);
        }

        return null;
    }

    public int getPlayNowPosition() {
        Calendar calendar = Calendar.getInstance(new Locale("el", "GR"));

        long timestamp = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);

        int playNow = playNow(timestamp);
        if (playNow == 0) {
            timestamp = timestamp + 24 * 60;

            return playNow(timestamp);
        }

        return playNow;
    }

    private int playNow(long timestamp) {
        for (int position = 0; position < shows.size(); position++) {
            ShowsModel response = shows.get(position);
            if (timestamp >= response.getStartTime() && timestamp <= response.getEndTime()) {
                return position;
            }
        }

        return 0;
    }

    public int getDrawableIcon(){
        if(channelName.equals("ΒΟΥΛΗ"))
        {return R.drawable.ic_channel_vouli;}
        else if (channelName.equals("ΕΡΤ1"))
        {return R.drawable.ic_channel_ert1;}
        else if (channelName.equals("ΕΡΤ2"))
        {return R.drawable.ic_channel_ert2;}
        else{return R.mipmap.ic_launcher;}

    }

}