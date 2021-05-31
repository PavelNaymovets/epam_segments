package com.epam.rd.autotasks.segments;

public class Main {
    public static void main(String[] args) {
        Segment first = new Segment(new Point(0, 0), new Point(4, 4));
        Segment second = new Segment(new Point(2, 0), new Point(0, 2));
        Point intersection = first.intersection(second);

        System.out.println(intersection == null);
    }
}
