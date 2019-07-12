package com.wolf.gamefix.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.wolf.gamefix.R;
import com.wolf.gamefix.adapters.LeagueAdapter;
import com.wolf.gamefix.models.League;
import com.wolf.gamefix.services.LeagueService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.league_recycler_view)
    RecyclerView leagueRecyclerView;

    private LeagueAdapter leagueAdapter;

    private ArrayList<League> mLeagues = new ArrayList<>();

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Leagues");

        createProgressDialog();

        ButterKnife.bind(this);
        initRecyclerView();

    }

    public void initRecyclerView()
    {
        progressDialog.show();
        final LeagueService leagueService = new LeagueService();
        leagueService.getLeagues(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        progressDialog.hide();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mLeagues= leagueService.processGetAllLeaguesResults(response);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();
                        leagueAdapter = new LeagueAdapter(mLeagues,MainActivity.this);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        leagueRecyclerView.setLayoutManager(layoutManager);
                    /*    leagueRecyclerView.setAdapter(leagueAdapter);*/
                    }
                });
            }
        });
    }

    private void createProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Fetching Leagues...");
        progressDialog.setCancelable(false);
    }
}
