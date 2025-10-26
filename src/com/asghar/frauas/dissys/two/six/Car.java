package com.asghar.frauas.dissys.two.six;

public class Car implements Display {
    private final String colour;
    private final int horsPower;
    private final float weight;

    public Car(String colour, int horsPower, float weight){
        this.colour = colour;
        this.horsPower = horsPower;
        this.weight = weight;
    }

    public void print(){
        System.out.println("Colour: " + colour);
        System.out.println("HorsPower: " + horsPower);
        System.out.println("Weight: " + weight);
    }
}
