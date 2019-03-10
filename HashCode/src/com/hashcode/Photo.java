package com.hashcode;

import java.util.ArrayList;

/**
 * GoogleHashCode2019
 * PACKAGE_NAME
 * <p>
 * Written by yigitiseri in March, 2019.
 */

public class Photo {
    int id;
    String position;
    int tagCount;
    ArrayList<String> tags;

    public Photo(int id, String position, int tagCount, ArrayList<String> tags) {
        this.id = id;
        this.position = position;
        this.tagCount = tagCount;
        this.tags = tags;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
