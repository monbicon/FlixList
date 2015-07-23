package com.studios.monbicon.flixlist.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.studios.monbicon.flixlist.R;
import com.studios.monbicon.flixlist.adapter.FeedAdapter;
import com.studios.monbicon.flixlist.model.Movie;

import butterknife.Bind;


public class MainActivity extends BaseActivity {

    @Bind (R.id.movieList) RecyclerView movieList;

    private FeedAdapter feedAdapter;
    private String[] tempMovies = {"Silence of lambs", "Jumunji", "Alladin", "Jumunji", "Alladin", "Jumunji", "Alladin", "Jumunji", "Alladin", "Jumunji", "Alladin", "Jumunji", "Alladin", "Jumunji", "Alladin"};
    private Movie[] mMovies;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovies = populateMovieList();
        setUpMovieList();
    }

    private Movie[] populateMovieList() {
        Movie[] movies = new Movie[tempMovies.length];
        for (int i = 0; i < tempMovies.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(tempMovies[i]);
            movies[i] = movie;
        }
        return movies;
    }

    private void setUpMovieList() {
        feedAdapter = new FeedAdapter(this, mMovies);
        movieList.setAdapter(feedAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        movieList.setLayoutManager(linearLayoutManager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
