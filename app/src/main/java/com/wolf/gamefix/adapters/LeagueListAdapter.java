package com.wolf.gamefix.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wolf.gamefix.R;
import com.wolf.gamefix.models.League;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LeagueListAdapter extends RecyclerView.Adapter<LeagueListAdapter.LeagueViewHolder> {
    private ArrayList<League> mLeagues = new ArrayList<>();
    private Context mContext;


    public LeagueListAdapter(Context context, ArrayList<League> leagues) {
        mContext = context;
        mLeagues = leagues;
    }
    @Override
    public LeagueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.league_list_item, parent, false);
        LeagueViewHolder viewHolder = new LeagueViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LeagueViewHolder holder, int position) {
        holder.bindFixture(mLeagues.get(position));
    }

    @Override
    public int getItemCount() {
        return mLeagues.size();
    }

    public class LeagueViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.awayNameTextView)
        TextView awayNameTextView;
        @BindView(R.id.homeNameTextView) TextView homeNameTextView;
        @BindView(R.id.venueTextView) TextView venueTextView;
        @BindView(R.id.logoImageView)
        ImageView logoImageView;


        private Context mContext;

        public LeagueViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindFixture(League league) {
            Picasso.get().load(league.getLogo("")).into(logoImageView);
            homeNameTextView.setText(league.getName(""));
            awayNameTextView.setText(league.getCountry(""));
            venueTextView.setText(league.getSeason(""));
        }
    }


}


