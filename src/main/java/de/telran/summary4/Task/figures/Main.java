package de.telran.summary4.Task.figures;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1. Создать набор классов для хранения геометрических фигур:
//        прямоугольник, квадрат, круг, треугольник (пусть для простоты будет только прямоугольный)
//        2. Добавить метод вычисления площади фигур
//        3. Составить список из разных геометрических фигур и отсортировать его по площади
//        4. Составить TreeSet из геометрических фигур - тех, для которых это имеет смысл

        Rectangle rectangle = new Rectangle(5, 3);
        Square square1 = new Square(7);
        Square square2 = new Square(2);
        Square square3 = new Square(1);
        Square square4 = new Square(4);
        Circle circle1 = new Circle(4);
        Circle circle2 = new Circle(2);
        Circle circle3 = new Circle(3);
        Circle circle4 = new Circle(8);
        Triangle triangle = new Triangle(4, 3);

        List<Figure> figuresList = new ArrayList<Figure>();
        figuresList.add(rectangle);
        figuresList.add(square1);
        figuresList.add(square2);
        figuresList.add(square3);
        figuresList.add(square4);
        figuresList.add(circle1);
        figuresList.add(circle2);
        figuresList.add(circle3);
        figuresList.add(circle4);
        figuresList.add(triangle);

        System.out.println(rectangle.getArea());
        System.out.println(square1.getArea());
        System.out.println(square2.getArea());
        System.out.println(square3.getArea());
        System.out.println(square4.getArea());
        System.out.println(circle1.getArea());
        System.out.println(circle2.getArea());
        System.out.println(circle3.getArea());
        System.out.println(circle4.getArea());
        System.out.println(triangle.getArea());

        Collections.sort(figuresList, new Comparator<Figure>() {
            @Override
            public int compare(Figure o1, Figure o2) {
                return Double.compare(o1.getArea(), o2.getArea());
            }
        });
        System.out.println(figuresList);

        Set<Circle> circleSet = new TreeSet<>();
        circleSet.add(circle1);
        circleSet.add(circle2);
        circleSet.add(circle3);
        circleSet.add(circle4);
        System.out.println(circleSet);

        Set<Square> squareSet = new TreeSet<>();
        squareSet.add(square1);
        squareSet.add(square2);
        squareSet.add(square3);
        squareSet.add(square4);
        System.out.println(squareSet);

    }
}
