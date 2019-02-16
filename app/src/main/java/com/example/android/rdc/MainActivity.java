package com.example.android.rdc;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SchemeModal> schemeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SchemeAdapter schemeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();
        schemeAdapter=new SchemeAdapter(this,schemeList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(schemeAdapter);
        sampleSchemes();
    }

    private void initCollapsingToolbar()
    {
        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("");
        final AppBarLayout appBar = findViewById(R.id.app_bar);
        appBar.setExpanded(true);

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if(scrollRange==-1)
                {
                    scrollRange=appBar.getTotalScrollRange();
                }
                else if(scrollRange+i==0)
                {
                    collapsingToolbar.setTitle(getString(R.string.main_title));
                    isShow=true;
                }
                else if(isShow)
                {
                    collapsingToolbar.setTitle("");
                    isShow=false;
                }
            }
        });
    }
    private void sampleSchemes()
    {
        schemeList.add(new SchemeModal("Pradhan Mantri Jan Dhan Yojana","Central"));
        schemeList.add(new SchemeModal("Pradhan Mantri Rozgar Yojana","Central"));
        schemeList.add(new SchemeModal("Pradhan Mantri Jan Awas Yojana","Central"));
        schemeList.add(new SchemeModal("Pradhan Mantri Ujjawal Yojana","Central"));
        schemeList.add(new SchemeModal("Swacchh Bharat Mission","State"));
        schemeList.add(new SchemeModal("Pradhan Mantri Jan Dhan Yojana","Central"));
        schemeList.add(new SchemeModal("Pradhan Mantri Rozgar Yojana","Central"));
        schemeList.add(new SchemeModal("Pradhan Mantri Jan Awas Yojana","Central"));
        schemeList.add(new SchemeModal("Pradhan Mantri Ujjawal Yojana","Central"));
        schemeList.add(new SchemeModal("Swacchh Bharat Mission","State"));
    }
}
