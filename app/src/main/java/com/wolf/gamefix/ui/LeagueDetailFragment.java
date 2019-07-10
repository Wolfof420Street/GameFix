package com.wolf.gamefix.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.gamefix.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeagueDetailFragment extends Fragment {


    public LeagueDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league_detail, container, false);
    }

}
