package com.example.demosheshbesh.logic.view;

import com.example.demosheshbesh.logic.Chip;
import com.example.demosheshbesh.logic.Field;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class GameView {

    public final static int CELL_SIZE = 15;

    private final Field game;
    private Cubes cubes;
    Chip chip = new Chip(0,9);
    Field field = new Field();
    private final Canvas canvas;
    public GameView(Field game, Canvas canvas, Cubes cubes) {
        this.canvas = canvas;
        this.game = game;
        this.cubes = cubes;
    }


    public void draw() {
        /*int cube1 = cubes.dice1();
        int cube2 = cubes.dice2();*/
        clear();
        drawField();
        drawBoard();
        drawStartPosition();
        drawChip();
       // drawCubes(1, 0, cube1);
    }

    private void drawCubes(int x, int y,int c) {

        double size = 26.85;
        GraphicsContext gc = canvas.getGraphicsContext2D();
       // gc.setFill(Color.BLUE);
        gc.fillRect(x * size, y * size, size, size);


        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", 14));
        gc.fillText(String.valueOf(c), x * size + 10, y * size + size / 2);
        gc.fillRect(x * CELL_SIZE/ getScale(), y * CELL_SIZE / getScale(), CELL_SIZE /getScale(), CELL_SIZE/getScale());
    }

    private void drawBoard() {
        int[][] board = field.createField();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double scale = getScale();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(i * CELL_SIZE/ scale, j * CELL_SIZE / scale, CELL_SIZE /scale, CELL_SIZE/scale);
                }
            }
        }
    }

    private double getScale() {
        double size = Math.min(canvas.getWidth(), canvas.getHeight());
        double scale = CELL_SIZE * 28 / size;
        return scale;
    }

    private void drawStartPosition() {
        int[][] board = field.createField();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double scale = getScale();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 2) {
                    gc.setFill(Color.GREEN);
                    gc.fillRect(i * CELL_SIZE/ scale, j * CELL_SIZE / scale, CELL_SIZE /scale, CELL_SIZE/scale);
                }
            }
        }
    }

    private void drawChip() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int a = chip.getX();
        int b = chip.getY();

        double scale = getScale();
        gc.setFill(Color.BISQUE);
        gc.fillOval(a * CELL_SIZE / scale, b * CELL_SIZE / scale, CELL_SIZE / scale, CELL_SIZE / scale);
    }

    private void drawField() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.WHITE);
        double size = Math.min(canvas.getWidth(),canvas.getHeight());
        double scale = CELL_SIZE * 28 / size;
        for (int i = 0; i < 28; i++){
            gc.strokeLine(0,i * CELL_SIZE / scale, size, i * CELL_SIZE / scale);
            gc.strokeLine(i * CELL_SIZE / scale, 0, i * CELL_SIZE / scale, size);
        }
        gc.strokeRect(0,0,size,size);
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
