package com.hashcode;

import java.util.HashSet;

/**
 * GoogleHashCode2019
 * PACKAGE_NAME
 * <p>
 * Written by yigitiseri in March, 2019.
 */

public class Slide {

    private String id;
    private HashSet<String> tags;
    private boolean used;

    public int calculateScore(Slide slide) {
        int onlyA = 0;
        int onlyB = 0;
        int intersection = 0;
        int totalA = tags.size();
        int totalB = slide.getTags().size();
        for (String tag : tags) {
            if (slide.getTags().contains(tag)) {
                intersection++;
            } else {
                onlyA++;
            }
        }
        onlyB = totalB - intersection;

        return Math.min(Math.min(onlyA, intersection), onlyB);
    }

    public Slide(String id) {
        this.id = id;
        this.tags = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
