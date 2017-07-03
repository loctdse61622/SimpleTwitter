package com.loctd.coderschool.simpletwitter.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loctd.coderschool.simpletwitter.R;
import com.loctd.coderschool.simpletwitter.activity.MainActivity;
import com.loctd.coderschool.simpletwitter.adapters.TimeLineAdapter;
import com.loctd.coderschool.simpletwitter.model.Tweet;
import com.loctd.coderschool.simpletwitter.rest.RestClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MentionPageFragment extends Fragment {
    RestClient restClient;
    int page;
    List<Tweet> mTweets;
    TimeLineAdapter mAdapter;
    private Activity mActivity;
    private Context mContext;

    @BindView(R.id.btnAdd)
    FloatingActionButton btnAdd;
    @BindView(R.id.rvTimeline)
    RecyclerView rvTimeline;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;


    public static MentionPageFragment newInstance(){
        Bundle bundle = new Bundle();
        MentionPageFragment fragment = new MentionPageFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mActivity = (MainActivity) context;
        }
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweets, container, false);
        Realm.init(mContext);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        page = 1;
        ButterKnife.bind(this, view);
        return view;
    }


}
