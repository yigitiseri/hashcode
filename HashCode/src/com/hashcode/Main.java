package com.hashcode;

import java.io.IOException;
import java.util.*;

/**
 * GoogleHashCode2019
 * PACKAGE_NAME
 * <p>
 * Written by yigitiseri in March, 2019.
 */

public class Main {

    public static String verticalIds = "";
    public static int verticalCounter = 0;
    public static HashMap<String, Integer> sorted = new HashMap<>();

    public static <Arraylist> void main(String[] args) throws IOException {

        ProblemData problemData = DataImporter.getProblem("C:\\Users\\Misafir\\IdeaProjects\\HashCode\\src\\com\\hashcode\\e_shiny_selfies.txt");
        // write your code here
        List<Photo> verticalPhotos = new ArrayList<>();
        List<Slide> slides = new ArrayList<>();
        List<Slide> sortedSlides = new ArrayList<>();
        for (int i = 0; i < problemData.getPhotoList().size(); i++) {
            Photo photo = problemData.getPhotoList().get(i);
            if (photo.getPosition().equals("H")) {
                Slide slide = new Slide(String.valueOf(photo.getId()));
                HashSet<String> hashTag = new HashSet<>();
                for (String tag : photo.getTags()) {
                    hashTag.add(tag);
                }
                slide.setTags(hashTag);
                slides.add(slide);
            } else {
                verticalPhotos.add(photo);
            }
        }
        Collections.sort(verticalPhotos, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return p2.getTagCount() - p1.getTagCount();
            }
        });
        for (int i = 0, j = verticalPhotos.size() - 1; i < verticalPhotos.size() / 2; i++, j--) {
            if (i == j) {
                continue;
            } else {
                HashSet<String> hashTag = new HashSet<>();
                String ids = String.valueOf(verticalPhotos.get(i).getId()) + " " + String.valueOf(verticalPhotos.get(j).getId());
                for (String tag : verticalPhotos.get(i).getTags()) {
                    hashTag.add(tag);
                }
                for (String tag : verticalPhotos.get(j).getTags()) {
                    hashTag.add(tag);
                }
                Slide slide = new Slide(ids);
                slide.setTags(hashTag);
                slides.add(slide);
            }
        }

        slides.get(0).setUsed(true);
        sortedSlides.add(slides.get(0));
        int counter = 0;
        while (true) {
            Slide currentSlide = slides.get(counter);
            int tempScore = 0;
            Slide tempSlide = null;
            for (int i = 0; i < slides.size(); i++) {
                Slide nextSlide = slides.get(i);
                if (nextSlide.isUsed() != true) {
                    int score = currentSlide.calculateScore(nextSlide);
                    if (score >= tempScore) {
                        tempScore = score;
                        tempSlide = nextSlide;
                        counter = i;
                    }
                }
            }
            if (tempSlide != null) {
                tempSlide.setUsed(true);
                sortedSlides.add(tempSlide);
                System.out.println(sortedSlides.size());

            } else {
                break;
            }
        }


        DataExporter.writeProblem("result.txt", sortedSlides);

    }

    static class ArrayCustomizedSorting implements Comparator<Photo> {
        @Override
        public int compare(Photo o1, Photo o2) {
            return (o1.getTags().size() >= o2.getTags().size() ? 1 : 0);
        }
    }
}
