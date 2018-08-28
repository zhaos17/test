package com.zhaos.Test.extendAndzuhe;

/**
 * @author zhaos
 * @date 2018-08-28
 */
class Draw {
    public void draw() {
        System.out.println("draw");
    }
}

class Erase {
    public void erase() {
        System.out.println("erase");
    }
}

class Work {
    public void work() {
        new Draw().draw();
        new Erase().erase();
    }

    public static void main(String[] args) {
        new Work().work();
    }
}
