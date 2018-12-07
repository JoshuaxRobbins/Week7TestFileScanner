package com.example.josh.week7test_filescanner.model;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SDCard {
    public static final String TAG = "_TAG";
    public SDCard() {
        getFileList();
    }

    private List<File> dir;
    private List<File> files;

    public void getFileList() {
        dir = new ArrayList<>();
        files = new ArrayList<>();

        File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d(TAG, "getFileList: " + root.toString());
        File[] rootDirs = root.listFiles();

        if(rootDirs != null) {
            for (File f : rootDirs) {
                scan(f);
            }
        }
        Log.i("files", "" + files.size());
        Log.i("dir", "" + dir.size());


    }

    public void scan(File path) {

        for (File f : path.listFiles()) {
            if (f.isFile()) {
                files.add(f);
            } else {
                dir.add(f);
                scan(f);
            }
        }
    }

    public List<File> largestFiles(){

        mergeSort(0,files.size());
        return files.subList(0,10);
    }

    public long averageSize(){
        long size = 0;
        for(File f: files){
            size+= f.length()/1024; //kilos
        }
        return (size/files.size());
    }

    public void mergeSort(int left, int right){

        if(left < right){
            int center = left + ((right - left) / 2);
            mergeSort(left,center);
            mergeSort(center + 1,right);
            merge(left,center,right);

        }

    }

    public void merge(int left, int center, int right){

        List<File> temp = new ArrayList<>();
        for(int i = left; i <= right; i++){
            temp.set(i,files.get(i));
        }
        int tempLeft = left;
        int tempCenter = center + 1;
        int tempRight = left;

        while(tempLeft <= center && tempCenter <= right){
            if(temp.get(tempLeft).length() <= temp.get(tempCenter).length()){
                files.set(tempRight,temp.get(tempRight));
                tempLeft++;
            }
            else{
                files.set(tempRight,temp.get(tempCenter));
                tempCenter++;
            }
            tempRight++;
        }
        while(tempLeft <= center){
            files.set(tempRight,temp.get(tempLeft));
            tempLeft++;
            tempRight++;

        }


    }
}


