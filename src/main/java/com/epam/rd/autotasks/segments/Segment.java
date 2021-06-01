package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    public Point start;
    public Point end;

    public Segment(Point start, Point end){
        if (start == null || end == null || (start.getX() == end.getX() && start.getY() == end.getY())) throw new RuntimeException();
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(pow((end.getX() - start.getX()), 2) + pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        return new Point((end.getX() + start.getX())/2, (end.getY() + start.getY())/2);
    }

    Point intersection(Segment another) {
//        если оба отрезка вертикальные
//        if((start.getX() - end.getX() == 0) && (another.start.getX() - another.end.getX() == 0)) {
//            //если они лежат на одном X
//            if(start.getX() == another.start.getX()) {
//                return null;
//            }
//            return null;
//        }
//
//        //найдём коэффициенты уравнений, содержащих отрезки
//        //f1(x) = A1*x + b1 = y
//        //f2(x) = A2*x + b2 = y
//
//        //если первый отрезок вертикальный
//        if (start.getX() - end.getX() == 0) {
//
//            //найдём Xa, Ya - точки пересечения двух прямых
//            double Xa = start.getX();
//            double A2 = (another.start.getY() - another.end.getY()) / (another.start.getX() - another.end.getX());
//            double b2 = another.start.getY() - A2 * another.start.getX();
//            double Ya = A2 * Xa + b2;
//
//            if (another.start.getX() <= Xa && another.end.getX() >= Xa && Math.min(start.getY(), end.getY()) <= Ya &&
//                    Math.max(start.getY(), end.getY()) >= Ya) {
//
//                return new Point(Xa,Ya);
//            } else{
//                return null;
//            }
//        }
//
//        //если второй отрезок вертикальный
//        if (another.start.getX() - another.end.getX() == 0) {
//
//            //найдём Xa, Ya - точки пересечения двух прямых
//            double Xa = another.start.getX();
//            double A1 = (start.getY() - end.getY()) / (start.getX() - end.getX());
//            double b1 = start.getY() - A1 * start.getX();
//            double Ya = A1 * Xa + b1;
//
//            if (start.getX() <= Xa && end.getX() >= Xa && Math.min(another.start.getY(), another.end.getY()) <= Ya &&
//                    Math.max(another.start.getY(), another.end.getY()) >= Ya) {
//
//                return new Point(Xa,Ya);
//            }else{
//                return null;
//            }
//        }

        //оба отрезка невертикальные
        double A1 = (start.getY() - end.getY()) / (start.getX() - end.getX());
        double A2 = (another.start.getY() - another.end.getY()) / (another.start.getX() - another.end.getX());
        double b1 = start.getY() - A1 * start.getX();
        double b2 = another.start.getY() - A2 * another.start.getX();
        double delta = (start.getX() - end.getX())*(another.start.getY() - another.end.getY()) - (start.getY() - end.getY())*(another.start.getX() - another.end.getX());

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);
        double Ya = A1 * Xa + b1;

        if(delta!=0 && (Xa<=Math.max(start.getX(), end.getX())) && (Xa>=Math.min(start.getX(), end.getX())) && (Xa<=Math.max(another.start.getX(), another.end.getX())) && (Xa>=Math.min(another.start.getX(), another.end.getX()))){
            return new Point(Xa, Ya);
        } else {
            System.out.println(delta);
            return null;
        }
    }
}
