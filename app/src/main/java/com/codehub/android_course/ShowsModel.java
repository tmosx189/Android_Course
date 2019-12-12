package com.codehub.android_course;

import androidx.annotation.Nullable;

public class ShowsModel {
    @Nullable
    private Long endTime;
    @Nullable
    private String title;
    @Nullable
    private Long startTime;
    @Nullable
    private String startTimeCaption;
    @Nullable
    private String endTimeCaption;

    @Nullable
    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(@Nullable Long endTime) {
        this.endTime = endTime;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(@Nullable Long startTime) {
        this.startTime = startTime;
    }

    @Nullable
    public String getStartTimeCaption() {
        return startTimeCaption;
    }

    public void setStartTimeCpation(@Nullable String startTimeCaption) {
        this.startTimeCaption = startTimeCaption;
    }

    @Nullable
    public String getEndTimeCpation() {
        return endTimeCaption;
    }

    public void setEndTimeCpation(@Nullable String endTimeCaption) {
        this.endTimeCaption = endTimeCaption;
    }
}
