package main.java;

import main.java.days.*;
import processing.core.PApplet;

public class Aoc extends PApplet {

    final boolean USE_EXAMPLE = false;
    final int DAY = 2;
    final String INPUT_PATH = "2023/inputs/";

    public void settings() {
        // size(500, 500);

        // Create day and run it
        try {
            AbstractDay day = createDay();
            day.puzzle1();
            day.puzzle2();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    private AbstractDay createDay() throws ReflectiveOperationException {
        Class myClass = Class.forName("main.java.days.Day" + DAY);
        Class[] types = { PApplet.class, String.class, Integer.TYPE, Boolean.TYPE };
        return (AbstractDay) myClass.getDeclaredConstructor(types).newInstance(this, INPUT_PATH,
                DAY, USE_EXAMPLE);
    }

    public static void main(String[] args) {
        String[] processingArgs = { "AOC 2023" };
        Aoc mySketch = new Aoc();
        PApplet.runSketch(processingArgs, mySketch);
    }
}