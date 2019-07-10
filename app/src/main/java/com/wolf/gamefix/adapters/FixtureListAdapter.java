package com.wolf.gamefix.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wolf.gamefix.R;
import com.wolf.gamefix.models.Fixture;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FixtureListAdapter extends RecyclerView.Adapter<FixtureListAdapter.FixtureViewHolder> {
    private ArrayList<Fixture> mFixtures = new ArrayList<>();
    private Context mContext;


    public FixtureListAdapter(Context context, ArrayList<Fixture> fixtures) {
        mContext = context;
        mFixtures = fixtures;
    }
    @Override
    public FixtureListAdapter.FixtureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_list_item, parent, false);
        FixtureViewHolder viewHolder = new FixtureViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FixtureListAdapter.FixtureViewHolder holder, int position) {
        holder.bindFixture(mFixtures.get(position));
    }

    @Override
    public int getItemCount() {
        return mFixtures.size();
    }

    public class FixtureViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.awayNameTextView)
        TextView awayNameTextView;
        @BindView(R.id.homeNameTextView) TextView homeNameTextView;
        @BindView(R.id.venueTextView) TextView venueTextView;


        private Context mContext;

        public FixtureViewHolder (View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindFixture(Fixture fixture) {
            homeNameTextView.setText(fixture.getHomeName(""));
            awayNameTextView.setText(fixture.getAwayName(""));
            venueTextView.setText(fixture.getVenue(""));
        }
    }


}


