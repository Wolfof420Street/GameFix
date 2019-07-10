package com.wolf.gamefix.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wolf.gamefix.models.Fixture;
import com.wolf.gamefix.adapters.FixtureListAdapter;
import com.wolf.gamefix.R;
import com.wolf.gamefix.services.SportService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FixturesActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private FixtureListAdapter mAdapter;
    public static final String TAG = FixturesActivity.class.getSimpleName();
    private ArrayList<Fixture> fixtures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);
        ButterKnife.bind(this);
    }

    private  void getFixtures(String date) {
        final SportService sportService = new SportService();

        sportService.findFixtures(date, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                fixtures = sportService.processResults(response);

                FixturesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new FixtureListAdapter(getApplicationContext(), fixtures);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(FixturesActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });

            }
        });
    }
}
