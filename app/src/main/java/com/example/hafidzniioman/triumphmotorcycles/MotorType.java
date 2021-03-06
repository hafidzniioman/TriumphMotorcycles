package com.example.hafidzniioman.triumphmotorcycles;

import java.util.ArrayList;

/**
 * Created by hafidzniioman on 21/02/18.
 */

public class MotorType {
    public static String[][] data = new String[][]{
            {"Bonneville", "The Most Famous name in motorcycling. Bonneville stands for freedom",
                    "https://imgd.aeplcdn.com//393x221//bw/models/triumph-bonneville-standard-327.jpg?20151209203720&q=85"},
            {"Scrambler", "The much loved modern classic and a genuine style icon",
                    "https://auto.ndtvimg.com/bike-images/colors/triumph/street-scrambler/triumph-street-scrambler-jet-black.png?v=9"},
            {"Street Twin Range", "Our Most contemporary, fun and accessible Bonneville, powered by a thrilling new 900cc HT engine",
                    "https://hertstriumph.co.uk/dbimages/image3790797--1507981863.png"},
            {"Tiger Explorer", "The Real Adventure starts here",
                    "https://static1.bikedekho.com/upload/userfiles/images/d9f907c221eef8eae4635a806f7faab3.jpg"},
    };

    public static ArrayList<Motor> getListMotor() {
        Motor motor = null;
        ArrayList<Motor> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            motor = new Motor();
            motor.setName(data[i][0]);
            motor.setRemarks(data[i][1]);
            motor.setPhoto(data[i][2]);

            list.add(motor);
        }
        return list;
    }
}
