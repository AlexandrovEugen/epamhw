package com.epam.java.se.hw1;


import java.util.Objects;

public class Pen {

    private final PenType type;
    private final int diameterOfRod;
    private final int cost;
    private final Color color;

    /**
     *
     * @param diameterOfRod in mm
     * @param color of pen
     * @param type  of pen
     * @param cost  in  kopeks. Term was given from Wiki
     */

    public Pen(int diameterOfRod, Color color, PenType type, int cost) {
        Objects.requireNonNull(color, "colour can't be  a null");
        Objects.requireNonNull(type, "type of pen can't be a null");
        if (diameterOfRod <= 0 || cost < 0){
            throw  new IllegalArgumentException();
        }
        this.diameterOfRod = diameterOfRod;
        this.color = color;
        this.type = type;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (diameterOfRod != pen.diameterOfRod) return false;
        if (cost != pen.cost) return false;
        if (type != pen.type) return false;
        return color == pen.color;

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 13 * result + diameterOfRod;
        result = 13 * result + cost;
        result = 13 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final String colorToText = color.toString();
        final String typeOfPen = type.toString();
        final int rubles = cost / 100;
        final int kopecs = cost % 100;
        final String format = "%s, colour inc: %s, diameter of rod: %d mm, type of pen: %s, pen's cost: %d.%02d RUR";
        return String.format(format,this.getClass().getSimpleName(), colorToText, diameterOfRod, typeOfPen, rubles, kopecs);
    }



     enum Color{

        red("red"), green("green"), blue("green"), black("black"), otherColor("other");

        private String color;

        Color(String color){
            this.color = color;
        }

        public void setColor(String colour){
            if (color.equals("other")){
                color = colour;
            }
        }

        @Override
        public String toString(){
            return color;
        }
    }

     enum PenType{

        ballpoint("ballpoint"), technical("technical"), rollerball("rollerball"), otherType("otherType");

        private String type;

        public void setType(String newType){
            if (type.equals("otherType")){
                type = newType;
            }
        }

        PenType(String type) {
            this.type = type;
        }

        @Override
        public String toString(){
            return type;
        }
    }
}
