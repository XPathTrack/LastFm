package com.refactor.lastfm.popular_artists.view;

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
import com.refactor.lastfm.popular_artists.model.data_model.Artist;

import java.util.LinkedList;
import java.util.List;

public class PopularArtistsAdapter extends RecyclerView.Adapter<PopularArtistsAdapter.PopArtsHolder> {

    private final List<Artist> artists = new LinkedList<>();
    private final OnPopArtClick onPopArtClick;

    public PopularArtistsAdapter(OnPopArtClick onPopArtClick) {
        this.onPopArtClick = onPopArtClick;
    }

    @NonNull
    @Override
    public PopArtsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_card, parent, false);
        return new PopArtsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopArtsHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.tvPopArtsName.setText(artist.getName());
        holder.tvPopArtsPlaycount.setText(artist.getPlaycount());
        holder.tvPopArtsListeners.setText(artist.getListeners());
        holder.tvPopArtsWeb.setText(artist.getUrl());
        Glide.with(holder.itemView).load(artist.getImages()[2].getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivPopArts);
        holder.itemView.setOnClickListener(view -> {
            onPopArtClick.onClick(artist);
        });
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void setArtists(List<Artist> newArtists) {
        if (newArtists == null || newArtists.isEmpty()) {
            int size = artists.size();
            artists.clear();
            notifyItemRangeRemoved(0, size);
            return;
        }

        artists.addAll(newArtists);
        notifyItemRangeInserted(0, artists.size());
    }

    public static class PopArtsHolder extends RecyclerView.ViewHolder {

        private final ImageView ivPopArts;
        private final TextView tvPopArtsName;
        private final TextView tvPopArtsPlaycount;
        private final TextView tvPopArtsListeners;
        private final TextView tvPopArtsWeb;

        public PopArtsHolder(@NonNull View itemView) {
            super(itemView);
            ivPopArts = itemView.findViewById(R.id.iv_popular_artist);
            tvPopArtsName = itemView.findViewById(R.id.tv_popular_artist_name);
            tvPopArtsPlaycount = itemView.findViewById(R.id.tv_popular_artist_playcount);
            tvPopArtsListeners = itemView.findViewById(R.id.tv_popular_artist_listeners);
            tvPopArtsWeb = itemView.findViewById(R.id.tv_popular_artist_web);
        }
    }

    public interface OnPopArtClick {
        void onClick(Artist artist);
    }
}
