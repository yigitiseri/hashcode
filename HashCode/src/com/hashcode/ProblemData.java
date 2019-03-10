package com.hashcode;

import java.util.ArrayList;

/**
 * GoogleHashCode2019
 * PACKAGE_NAME
 * <p>
 * Written by yigitiseri in March, 2019.
 */

public class ProblemData {

    int photoCount;
    ArrayList<Photo> photoList;

    public ProblemData(int photoCount) {
        this.photoCount = photoCount;
        this.photoList = new ArrayList<>();
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public ArrayList<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(ArrayList<Photo> photoList) {
        this.photoList = photoList;
    }
}
