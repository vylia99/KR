package com.example.demosheshbesh.logic;

import com.example.demosheshbesh.logic.view.Cubes;

public class Player {

    private int[][] field;
    private int playerIndex;
    private Chip chip;
    Cubes cubes = new Cubes();




    public Player(int[][] field){
        this.field = field;
        this.playerIndex = 0;
        this.chip = new Chip(9,0);



    }
    public void chooseCell(int x, int y) {
       /* int a = chip.getX();
        int b = chip.getY();
        int dice1 = cubes.dice1();
        int dice2 = cubes.dice2();*/
                 if (field[x][y] == 1 ) {
                    chip.setX(x);
                    chip.setY(y);

                 }
    }


}

