package com.zwelibanzi_ntongana.movie;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<MovieClass> TRENDING_MOVIES_LIST;
    private Context context;
    private Activity activity;

    public MoviesAdapter(List<MovieClass> TRENDING_MOVIES_LIST, Activity activity) {
        this.TRENDING_MOVIES_LIST = TRENDING_MOVIES_LIST;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MovieClass movieClass = TRENDING_MOVIES_LIST.get(position);

        Picasso.get()
                .load(Constants.IMAGES_URL + movieClass.getStMoviePosterPath())
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, MovieDetailsActivity.class);
                intent.putExtra("MovieTitle", movieClass.getStMovieTitle());
                intent.putExtra("MovieRating", movieClass.getStMovieRating());
                intent.putExtra("PosterPath", movieClass.getStMoviePosterPath());
                intent.putExtra("BackdropPath", movieClass.getStMovieBackdropPath());
                intent.putExtra("MovieOverview", movieClass.getStMovieOverview());
                intent.putExtra("ReleaseDate", movieClass.getStMovieReleaseDate());

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(activity, holder.imageView, "posterImage");

                activity.startActivity(intent, activityOptions.toBundle());
            }
        });


    }

    @Override
    public int getItemCount() {
        return TRENDING_MOVIES_LIST.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_trending_movie_view);
        }
    }
}
