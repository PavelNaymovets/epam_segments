package com.epam.rd.autotasks.segments;

public class Main {
    public static void main(String[] args) {
        Segment first = new Segment(new Point(0, 0), new Point(1, 1));
        Segment second = new Segment(new Point(-1, -1), new Point(-2, 2));
        Point intersection = first.intersection(second);

        System.out.println(intersection.getX());
        System.out.println(intersection.getY());
//        System.out.println(intersection == null);
    }
}
