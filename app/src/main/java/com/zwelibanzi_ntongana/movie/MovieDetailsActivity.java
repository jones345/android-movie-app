package com.zwelibanzi_ntongana.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {


    private TextView tvMovieDetailLargeText;
    private TextView tvMovieDetailMovieTitle;
    private ImageView ivMovieDetailBackdropPath;
    private ImageView ivMovieDetailPosterPath;

    private ImageView ivMovieRatingOne;
    private ImageView ivMovieRatingTwo;
    private ImageView ivMovieRatingThree;
    private ImageView ivMovieRatingFour;
    private ImageView ivMovieRatingFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        final String stMovieName = getIntent().getStringExtra("MovieTitle");
        final String stMovieRating = getIntent().getStringExtra("MovieRating");
        final String stPosterPath = getIntent().getStringExtra("PosterPath");
        final String stBackdropPath = getIntent().getStringExtra("BackdropPath");
        final String stMovieOverview = getIntent().getStringExtra("MovieOverview");
        final String stReleaseDate = getIntent().getStringExtra("ReleaseDate");


        tvMovieDetailLargeText = findViewById(R.id.tv_movie_detail_large_text);
        tvMovieDetailLargeText.setText(stMovieOverview);





        tvMovieDetailMovieTitle = findViewById(R.id.tv_movie_detail_title);
        tvMovieDetailMovieTitle.setText(stMovieName);

        ivMovieDetailPosterPath = findViewById(R.id.iv_movie_detail_poster_path);
        Picasso.get()
                .load(Constants.IMAGES_URL + stPosterPath)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivMovieDetailPosterPath);

        ivMovieRatingOne = findViewById(R.id.iv_movie_detail_rating_one);
        ivMovieRatingTwo = findViewById(R.id.iv_movie_detail_rating_two);
        ivMovieRatingThree = findViewById(R.id.iv_movie_detail_rating_three);
        ivMovieRatingFour = findViewById(R.id.iv_movie_detail_rating_four);
        ivMovieRatingFive = findViewById(R.id.iv_movie_detail_rating_five);

        Float rating = Float.parseFloat(stMovieRating);
        int movieRating = Math.round(rating);
        movieRating = movieRating/2;
        switch (movieRating){
            case 1:
                ivMovieRatingOne.setVisibility(View.VISIBLE);
                ivMovieRatingTwo.setVisibility(View.GONE);
                ivMovieRatingThree.setVisibility(View.GONE);
                ivMovieRatingFour.setVisibility(View.GONE);
                ivMovieRatingFive.setVisibility(View.GONE);
                break;
            case 2:
                ivMovieRatingOne.setVisibility(View.VISIBLE);
                ivMovieRatingTwo.setVisibility(View.VISIBLE);
                ivMovieRatingThree.setVisibility(View.GONE);
                ivMovieRatingFour.setVisibility(View.GONE);
                ivMovieRatingFive.setVisibility(View.GONE);
                break;
            case 3:
                ivMovieRatingOne.setVisibility(View.VISIBLE);
                ivMovieRatingTwo.setVisibility(View.VISIBLE);
                ivMovieRatingThree.setVisibility(View.VISIBLE);
                ivMovieRatingFour.setVisibility(View.GONE);
                ivMovieRatingFive.setVisibility(View.GONE);
                break;
            case 4:
                ivMovieRatingOne.setVisibility(View.VISIBLE);
                ivMovieRatingTwo.setVisibility(View.VISIBLE);
                ivMovieRatingThree.setVisibility(View.VISIBLE);
                ivMovieRatingFour.setVisibility(View.VISIBLE);
                ivMovieRatingFive.setVisibility(View.GONE);
                break;
            case 5:
                ivMovieRatingOne.setVisibility(View.VISIBLE);
                ivMovieRatingTwo.setVisibility(View.VISIBLE);
                ivMovieRatingThree.setVisibility(View.VISIBLE);
                ivMovieRatingFour.setVisibility(View.VISIBLE);
                ivMovieRatingFive.setVisibility(View.VISIBLE);
                break;
        }



    }
}
