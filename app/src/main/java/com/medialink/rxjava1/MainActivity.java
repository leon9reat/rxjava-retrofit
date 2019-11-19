package com.medialink.rxjava1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medialink.rxjava1.model.Pimpinan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity
        implements MainAdapter.AdapterCallback {

    private static final String TAG = "MainActivity";

    @BindView(R.id.progress_main)
    ProgressBar progressMain;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    Unbinder unbinder;

    private MainAdapter mAdapter;
    private PimpinanViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel = ViewModelProviders.of(this).get(PimpinanViewModel.class);
        mModel.initPimpinan();

        mAdapter = new MainAdapter(this, this);

        mModel.getPimpinan().observe(this, new Observer<List<Pimpinan>>() {
            @Override
            public void onChanged(List<Pimpinan> pimpinans) {
                if (pimpinans != null) {
                    mAdapter.setData((ArrayList<Pimpinan>) pimpinans);
                }
            }
        });
        unbinder = ButterKnife.bind(this);

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setItemAnimator(new DefaultItemAnimator());
        rvMain.setHasFixedSize(true);
        rvMain.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rvMain.setAdapter(mAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onRowClick(Pimpinan data) {
        Log.d(TAG, "onRowClick: "+data.getNmPimpinan());
    }
}
