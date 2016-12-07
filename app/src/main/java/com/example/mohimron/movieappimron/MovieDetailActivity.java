package com.example.mohimron.movieappimron;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by MOHIMRON on 03-Dec-16.
 */
public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "movie";

    private Movie mMovie;
    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;
    TextView release_year;
    TextView voteaverage;
    TextView duration;
    String release_date;
    TextView trailers;
    TextView trailer1;
    TextView trailer2;
    ImageView play1;
    ImageView play2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        if (getIntent().hasExtra(EXTRA_MOVIE)) {
            mMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        } else {
            throw new IllegalArgumentException("Detail activity must receive a movie parcelable");
        }

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.showOverflowMenu();
        //setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } // it's getSupportActionBar() if you're using AppCompatActivity, not getActionBar()

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(mMovie.getTitle());
        initToolbar();
        //backdrop = (ImageView) findViewById(R.id.backdrop);
        //title = (TextView) findViewById(R.id.movie_title);
        description = (TextView) findViewById(R.id.tv_desc);
        poster = (ImageView) findViewById(R.id.iv_poster);
        release_year=(TextView) findViewById(R.id.tv_year);
        voteaverage=(TextView) findViewById(R.id.tv_rating);
        duration=(TextView) findViewById(R.id.tv_duration);
//        trailers=(TextView) findViewById(R.id.tv_Trailer);
//        trailer1=(TextView) findViewById(R.id.tv_trailer1);
//        trailer2=(TextView) findViewById(R.id.tv_trailer2);
//        play1=(ImageView) findViewById(R.id.iv_play);
//        play2=(ImageView) findViewById(R.id.iv_play2);

        //title.setText(mMovie.getTitle());
        release_year.setText(mMovie.setReleaseyear(release_date));
        description.setText(mMovie.getDescription());
        voteaverage.setText(mMovie.getVoteaverage() + "/10");
        duration.setText("120min");
        Picasso.with(this)
                .load(mMovie.getPoster())
                .into(poster);
       // Picasso.with(this)
        //        .load(mMovie.getBackdrop())
        //        .into(backdrop);

    }

    private void initToolbar() {
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.showOverflowMenu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_share) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_share:
                // app icon in action bar clicked; go home
                //Intent intent = new Intent(this, MainActivity.class);
               // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(intent);
                return true;
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // for review and video trailer










}
