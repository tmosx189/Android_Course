package com.codehub.android_course;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class play_now_adapter extends ListAdapter<ChannelsModel, PlayNowHolder> {

    public ItemClickListener listener;

    protected play_now_adapter(@NonNull DiffUtil.ItemCallback diffCallback, ItemClickListener listener) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PlayNowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return new PlayNowHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayNowHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    protected ChannelsModel getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.holder_play_now;
    }
}
