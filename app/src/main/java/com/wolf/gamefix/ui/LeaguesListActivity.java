package com.wolf.gamefix.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wolf.gamefix.R;

import com.wolf.gamefix.adapters.LeagueListAdapter;

import com.wolf.gamefix.models.League;
import com.wolf.gamefix.services.LeagueService;


import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LeaguesListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private LeagueListAdapter mAdapter;
    public static final String TAG = LeaguesListActivity.class.getSimpleName();
    private ArrayList<League> leagues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leagues);
        ButterKnife.bind(this);
    }

    private  void getLeagues(String season) {
        final LeagueService leagueService = new LeagueService();

        leagueService.findSeason(season, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                leagues = leagueService.processResults(response);

                LeaguesListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new LeagueListAdapter(getApplicationContext(), leagues);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(LeaguesListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });

            }
        });
    }
}
