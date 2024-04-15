package de.telran.homeworkSets;



import java.util.*;

public class Point implements Comparable<Point>{
//    Создать класс Point для хранения координат (x, y) точки на плоскости.
//    Создать список точек, отсортировать по координате y.
//    Создать TreeSet со всеми уникальными точками.
//    Создать TreeSet со всеми различными по координате y точками.


    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

        @Override
    public int compareTo( Point o) {
        int result = this.x - o.x;
        if (result == 0) {
            result = this.y - o.y;
        }
        return result;
    }
    public static class SortByYComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.y, o2.y);
        }
    }

    public static void main(String[] args) {
        Point point1 = new Point(0, 5);
        Point point2 = new Point(7, -2);
        Point point3 = new Point(-4, 5);
        Point point4 = new Point(7, 2);


        List<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        System.out.println(points);

        Collections.sort(points, new Point.SortByYComparator());

            System.out.println(points);

        System.out.println("--------------------");

        Set<Point> pointSet = new TreeSet<>();
        pointSet.addAll(points);
        System.out.println(pointSet);

        Set<Point> differentYSet = new TreeSet<>(new SortByYComparator());
        differentYSet.add(point1);
        differentYSet.add(point2);
        differentYSet.add(point3);
        differentYSet.add(point4);
        System.out.println(differentYSet);
    }
}
