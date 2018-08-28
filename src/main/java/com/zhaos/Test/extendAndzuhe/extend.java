package com.zhaos.Test.extendAndzuhe;

/**
 * @author zhaos
 * @date 2018-08-28
 */

class Shape {
    public void draw() {
        System.out.println("draw a shape");
    }

    public void erase() {
        System.out.println("erase");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("draw a Square");
    }

    public static void main(String[] args) {
        Square s = new Square();
        s.draw();
        s.erase();
    }
}
