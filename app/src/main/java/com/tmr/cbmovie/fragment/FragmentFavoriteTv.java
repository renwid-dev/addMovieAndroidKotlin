package com.tmr.cbmovie.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tmr.cbmovie.R;
import com.tmr.cbmovie.activities.DetailTelevisionActivity;
import com.tmr.cbmovie.adapter.TvAdapter;
import com.tmr.cbmovie.model.ModelTV;
import com.tmr.cbmovie.realm.RealmHelper;

import java.util.ArrayList;
import java.util.List;
/**
 *Created by temanrendy 2020
 */
public class FragmentFavoriteTv extends Fragment implements TvAdapter.onSelectData {

    private RecyclerView rvMovieFav;
    private List<ModelTV> modelTV = new ArrayList<>();
    private RealmHelper helper;
    private TextView txtNoData;

    public FragmentFavoriteTv() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite_film, container, false);

        helper = new RealmHelper(getActivity());

        txtNoData = rootView.findViewById(R.id.tvNotFound);
        rvMovieFav = rootView.findViewById(R.id.rvMovieFav);
        rvMovieFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovieFav.setAdapter(new TvAdapter(getActivity(), modelTV, this));
        rvMovieFav.setHasFixedSize(true);

        setData();
        return rootView;
    }

    private void setData() {
        modelTV = helper.showFavoriteTV();
        if (modelTV.size() == 0) {
            txtNoData.setVisibility(View.VISIBLE);
            rvMovieFav.setVisibility(View.GONE);
        } else {
            txtNoData.setVisibility(View.GONE);
            rvMovieFav.setVisibility(View.VISIBLE);
            rvMovieFav.setAdapter(new TvAdapter(getActivity(), modelTV, this));
        }
    }

    @Override
    public void onSelected(ModelTV modelTV) {
        Intent intent = new Intent(getActivity(), DetailTelevisionActivity.class);
        intent.putExtra("detailTV", modelTV);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }
}
