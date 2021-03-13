package com.github.libkhadir.utils;

import com.github.libkhadir.model.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Util class for calculating distance between two points using latitude and longitude coordinates
 * unit k for kilometers
 * unit miles by default
 * unit n for nautical miles
 * @author tkhadir
 */
public class MathHelper {
    private static final String KM_UNIT = "K";

    public static String[][] distances(List<String> lines) {
        String[][] result = new String[lines.size()][5];
        IntStream.range(0, lines.size()).forEach(i -> {
            result[i] = new String[]{lines.get(i).split(";")[0], lines.get(i).split(";")[1],
                                     lines.get(i).split(";")[2], lines.get(i).split(";")[3],
                                     distance(lines.get(i).split(";")[0], lines.get(i).split(";")[1], lines.get(i).split(";")[2], lines.get(i).split(";")[3])
            };
        });
        return result;
    }

    public static String distance(String lat1, String lon1, String lat2, String lon2) {
        return String.valueOf(distance(Double.valueOf(lat1), Double.valueOf(lon1), Double.valueOf(lat2), Double.valueOf(lon2), KM_UNIT));
    }

    public static double distance(Point p1, Point p2) {
        return distance(p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude(), KM_UNIT);
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}
