package com.hashcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * GoogleHashCode2019
 * PACKAGE_NAME
 * <p>
 * Written by yigitiseri in March, 2019.
 */
public class DataImporter {

    public static ProblemData getProblem(String fileName) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        ProblemData problem = null;
        int id = 0;
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            String[] points = line.split(" ");
            if (problem == null) {
                problem = new ProblemData(Integer.valueOf(points[0]));
            } else {
                ArrayList<String> tags = new ArrayList<>();
                for (int i = 0; i < Integer.valueOf(points[1]); i++) {
                    tags.add(points[i + 2]);
                }
                problem.getPhotoList().add(
                        new Photo(id++, points[0], Integer.valueOf(points[1]), tags)
                );
            }
        }
        return problem;
    }

}
