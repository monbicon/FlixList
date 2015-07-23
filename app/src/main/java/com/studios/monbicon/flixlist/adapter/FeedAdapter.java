package com.studios.monbicon.flixlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studios.monbicon.flixlist.R;
import com.studios.monbicon.flixlist.model.Movie;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by monbicon on 23/07/15.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ItemFeedViewHolder> {

    Context context;
    Movie[] mMovies;

    public FeedAdapter(Context context, Movie[] movies) {
        this.context = context;
        mMovies = movies;
    }


    @Override
    public FeedAdapter.ItemFeedViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_feed, viewGroup, false);
        final ItemFeedViewHolder itemFeedViewHolder = new ItemFeedViewHolder(view);
        return itemFeedViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemFeedViewHolder viewHolder, int position) {
    viewHolder.bindMovie(mMovies[position]);
    }

    @Override
    public int getItemCount() {
        return mMovies.length;
    }

    public class ItemFeedViewHolder extends RecyclerView.ViewHolder {

        @Bind (R.id.mvTitle)
        TextView mvTitle;

        public ItemFeedViewHolder (View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindMovie (Movie movie) {
            mvTitle.setText(movie.getTitle());
        }
    }
}
