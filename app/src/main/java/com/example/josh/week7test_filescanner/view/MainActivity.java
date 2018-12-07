package com.example.josh.week7test_filescanner.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.josh.week7test_filescanner.R;
import com.example.josh.week7test_filescanner.model.SDCard;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainCallback {
    public static final String TAG = "_TAG";
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter();
    }

    public void onGetSD(View view) {
        mainPresenter.scanSD();
    }

    @Override
    public void onSuccess(List<File> fileList) {
        Log.d(TAG, "onSuccess: ");
    }

    @Override
    public void onFail() {

    }
}
