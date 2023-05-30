package com.example.demosheshbesh;

import com.example.demosheshbesh.logic.Chip;
import com.example.demosheshbesh.logic.Field;
import com.example.demosheshbesh.logic.Player;
import com.example.demosheshbesh.logic.view.Cubes;
import com.example.demosheshbesh.logic.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class GameController {

    @FXML private Pane pane;
    @FXML private Canvas canvas;

    private GameView view;
    private Field game;

    private Cubes cubes;
    private Chip chip;
    private Player player;


    public void initialize(){
    canvas.widthProperty().bind(pane.widthProperty());
    canvas.heightProperty().bind(pane.heightProperty());

    canvas.widthProperty().addListener(evt -> view.draw());
    canvas.heightProperty().addListener(evt -> view.draw());
    game = new Field();
    view = new GameView(game, canvas, cubes);
    player = new Player(game.createField());
    pane.requestFocus();

    }
    public void processMouse(MouseEvent mouseEvent) {

        double size = Math.min(canvas.getWidth(), canvas.getHeight());
        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();
        System.out.println("mouse: " + mouseX + " " + mouseY);

        int indexX = (int) (mouseX / size);
        int indexY = (int) (mouseY / size);
        player.chooseCell(indexX, indexY);



    }

}