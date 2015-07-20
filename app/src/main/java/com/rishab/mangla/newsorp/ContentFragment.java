/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rishab.mangla.newsorp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rishab.mangla.newsorp.Adapter.RVAdapter;
import com.rishab.mangla.newsorp.Data.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple Fragment used to display some meaningful content for each page in the sample's
 * {@link android.support.v4.view.ViewPager}.
 */
public class ContentFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private static final String KEY_INDICATOR_COLOR = "indicator_color";
    private static final String KEY_DIVIDER_COLOR = "divider_color";

    private List<News> newsFeed;
    RecyclerView newsList;
    /**
     * @return a new instance of {@link ContentFragment}, adding the parameters into a bundle and
     * setting them as arguments.
     */
    public static ContentFragment newInstance(CharSequence title) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            newsList = (RecyclerView) view.findViewById(R.id.rv);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            newsList.setLayoutManager(llm);

            initializeData();
            initializeAdapter();
        }
    }

    public void initializeData(){
        newsFeed = new ArrayList<>();
        newsFeed.add(new News("NEWS", "the headline", R.drawable.abc_popup_background_mtrl_mult));
        newsFeed.add(new News("ORP", "the content", R.drawable.abc_popup_background_mtrl_mult));
        newsFeed.add(new News("FEEDS", "the url", R.drawable.abc_popup_background_mtrl_mult));
    }

    public void initializeAdapter(){
        RVAdapter rvAdapter = new RVAdapter(newsFeed);
        newsList.setAdapter(rvAdapter);
    }
}
