package com.codehub.android_course;

import androidx.annotation.Nullable;

public class ChannelsModel {
    @Nullable
    private ShowsModel Show;

    @Nullable
    public ShowsModel getShow() {
        return Show;
    }

    public void setShow(@Nullable ShowsModel show) {
        Show = show;
    }
}
