package com.example.demosheshbesh.logic.view;

import java.util.Random;

public class Cubes {

    Random random = new Random();

    public int dice1() {

        return random.nextInt(7);
    }
    public int dice2() {

        return random.nextInt(7);
    }
}
