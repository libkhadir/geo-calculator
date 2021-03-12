package com.github.libkhadir.utils;

import com.github.libkhadir.model.Point;

/**
 * Util class for calculating distance between two points using latitude and longitude coordinates
 * unit k for kilometers
 * unit miles by default
 * unit n for nautical miles
 * @author tkhadir
 */
public class MathHelper {
    public static final double RADIUS = 6378;//km
    public static final double MAX_WEIGHT = 10000;//kg

    public static double distance(Point p1, Point p2) {
        return distance(p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude(), "K");
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
