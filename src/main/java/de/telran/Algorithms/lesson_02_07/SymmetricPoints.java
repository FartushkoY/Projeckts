package de.telran.Algorithms.lesson_02_07;
// Дан массив точек на плоскости. Точки определены парой координат (x, y).
// Необходимо написать функцию, которая определяет, существует ли такая
// вертикальная прямая линия, которая симметрично делит этот набор точек на две части.
// Для хранения точки можно определить класс Point(x, y).

import java.util.*;

public class SymmetricPoints {

    public static void main(String[] args) {
        Point[] pointsSym1 = new Point[]{
                new Point(-2, 5),
                new Point(-1, 3),
                new Point(4, 3),
                new Point(0, 5),
                new Point(0, -1),
                new Point(2, 3),
                new Point(1, 3),
                new Point(2, 3),
                new Point(5, 5),
                new Point(3, -1),
                new Point(6, 3),
                new Point(-3, 3),
                new Point(3, 5)
        };

        Point[] pointsSym2 = new Point[]{
                new Point(4, 3),
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, -1),
                new Point(3, -1),
                new Point(5, 1),
                new Point(-1, 1),
                new Point(3, 3),
                new Point(1, 3),


        };
        Point[] pointsSym3 = new Point[]{
                new Point(1, 3),
                new Point(3, 3),
                new Point(1, -1),
                new Point(3, -1),
                new Point(0, -1),
                new Point(4, -1),
        };

        System.out.println(hasSplitLine(pointsSym1));
        System.out.println(hasSplitLine(pointsSym2));
        System.out.println(hasSplitLine(pointsSym3));


    }

    public static boolean hasSplitLine(Point[] points) {
        int minX = points[0].getX();
        int maxX = points[0].getX();
        for (int i = 1; i < points.length; i++) {
            if (points[i].getX() < minX) {
                minX = points[i].getX();
            }
            if (points[i].getX() > maxX) {
                maxX = points[i].getX();
            }
        }
        double lineX = (maxX - minX) / 2.0 + minX;
        Map<Integer, TreeSet<Integer>> pointsMap = new HashMap<>();

        for (Point point : points) {
            int key = point.getY();
            if (pointsMap.containsKey(point.getY())) {
                pointsMap.get(key).add(point.getX());
            } else {
                pointsMap.put(key, new TreeSet<>());
                pointsMap.get(key).add(point.getX());
            }
        }

        Collection<TreeSet<Integer>> xGroups = pointsMap.values();
        for (TreeSet<Integer> set : xGroups) {
            if (!isSymmetric(set, lineX)) return false;
        }
        return true;
    }

    private static boolean isSymmetric(TreeSet<Integer> set, double lineX) {
        while (!set.isEmpty()) {
            int x1 = set.first();
            int symX = (int) Math.round(2 * lineX - x1);
            if (set.contains(symX)) {
                set.remove(x1);
                set.remove(symX);
            } else {
                return false;
            }
        }
        return true;
    }
}
