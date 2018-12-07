package com.example.josh.week7test_filescanner.view;

import com.example.josh.week7test_filescanner.model.SDCard;

import java.io.File;
import java.util.List;

public class MainPresenter {

    MainCallback mainCallback;

    public void scanSD(){

        SDCard sdCard = new SDCard();
        List<File> files = sdCard.largestFiles();
        mainCallback.onSuccess(files);
    }






    public interface MainCallback{

        public void onSuccess(List<File> fileList);
        public void onFail();
    }

}
