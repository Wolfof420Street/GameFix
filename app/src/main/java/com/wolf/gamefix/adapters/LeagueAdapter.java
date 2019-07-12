package com.wolf.gamefix.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;
import com.wolf.gamefix.R;
import com.wolf.gamefix.models.League;
import com.wolf.gamefix.ui.FixturesActivity;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {
    private List<League> mLeagues = new ArrayList<>();
    private Context mContext;

    public LeagueAdapter(List<League> mLeagues, Context mContext) {
        this.mLeagues = mLeagues;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.league_item, parent, false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder holder, int position) {
        holder.bindLeague(mLeagues.get(position));
    }

    @Override
    public int getItemCount() {
        return mLeagues.size();
    }

    public class LeagueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.league_image)
        ImageView leagueImage;
        @BindView(R.id.league_name)
        TextView leagueName;
        @BindView(R.id.league_start_date)
        TextView leagueStartDate;
        @BindView(R.id.league_end_date)
        TextView leagueEndDate;
        @BindView(R.id.league_country_name)
        TextView leagueCountryName;

        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(this);
        }

        public void bindLeague(League league)
        {
            Picasso.get().load(league.getLogo("")).into(leagueImage);
            leagueName.setText(league.getName(""));
            leagueStartDate.setText(league.getSeasonStart());
            leagueEndDate.setText(league.getSeasonEnd());
            leagueCountryName.setText(league.getCountry(""));

        }

        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent =new Intent(mContext, FixturesActivity.class);
            intent.putExtra("league_id",String.valueOf(mLeagues.get(itemPosition).getLeagueId()));
            mContext.startActivity(intent);
        }
    }
}