package com.refactor.lastfm.top_songs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.refactor.lastfm.R;
import com.refactor.lastfm.top_songs.model.data_model.Song;

import java.util.LinkedList;
import java.util.List;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsHolder> {

    private final List<Song> songs = new LinkedList<>();

    @NonNull
    @Override
    public TopSongsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_card, parent, false);
        return new TopSongsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSongsHolder holder, int position) {
        Song song = songs.get(position);
        holder.tvTopSongsName.setText(song.getName());
        holder.tvTopSongsPlaycount.setText(song.getPlaycount());
        holder.tvTopSongsListeners.setText(song.getListeners());
        holder.tvTopSongsWeb.setText(song.getUrl());
        Glide.with(holder.itemView).load(song.getImages()[2].getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivTopSongs);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void setSongs(List<Song> newSongs) {
        if (newSongs == null || newSongs.isEmpty()) {
            int size = songs.size();
            songs.clear();
            notifyItemRangeRemoved(0, size);
            return;
        }

        songs.addAll(newSongs);
        notifyItemRangeInserted(0, songs.size());
    }

    public static class TopSongsHolder extends RecyclerView.ViewHolder {

        private final ImageView ivTopSongs;
        private final TextView tvTopSongsName;
        private final TextView tvTopSongsPlaycount;
        private final TextView tvTopSongsListeners;
        private final TextView tvTopSongsWeb;

        public TopSongsHolder(@NonNull View itemView) {
            super(itemView);
            ivTopSongs = itemView.findViewById(R.id.iv_popular_artist);
            tvTopSongsName = itemView.findViewById(R.id.tv_popular_artist_name);
            tvTopSongsPlaycount = itemView.findViewById(R.id.tv_popular_artist_playcount);
            tvTopSongsListeners = itemView.findViewById(R.id.tv_popular_artist_listeners);
            tvTopSongsWeb = itemView.findViewById(R.id.tv_popular_artist_web);
            tvTopSongsPlaycount.setVisibility(View.VISIBLE);
        }
    }
}
