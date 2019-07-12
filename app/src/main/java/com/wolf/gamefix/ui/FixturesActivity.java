package com.wolf.gamefix.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wolf.gamefix.R;
import com.wolf.gamefix.adapters.FixtureAdapter;
import com.wolf.gamefix.models.Fixture;
import com.wolf.gamefix.services.LeagueService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FixturesActivity extends AppCompatActivity {

    @BindView(R.id.fixtures_recycler)
    RecyclerView fixturesRecyclerView;

    private FixtureAdapter fixtureAdapter;

    private ArrayList<Fixture> mFixture = new ArrayList<>();

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures2);

        setTitle("Fixtures");

        ButterKnife.bind(this);

        createProgressDialog();
        initRecyclerView(getIntent().getStringExtra("league_id"));
    }

    public void initRecyclerView(String leagueId)
    {
        progressDialog.show();
        final LeagueService leagueService = new LeagueService();

        leagueService.getFixtures(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                FixturesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();

                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mFixture = leagueService.processGetFixturesResults(response);

                FixturesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();


                        fixtureAdapter = new FixtureAdapter(mFixture,FixturesActivity.this);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FixturesActivity.this);
                        fixturesRecyclerView.setLayoutManager(layoutManager);
                        fixturesRecyclerView.setAdapter(fixtureAdapter);
                    }
                });
            }
        },leagueId);
    }

    private void createProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait...");
        progressDialog.setMessage("Getting Fixtures...");
        progressDialog.setCancelable(false);
    }
}