package agh.ics.oop.gui;

import agh.ics.oop.*;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class App extends Application {
    private final int numberOfGrassTufts = 10;
    private final MapBoundary boundary = new MapBoundary();
    private final AbstractWorldMap map = new GrassField(numberOfGrassTufts, boundary);
    private final OptionsParser commandParser = new OptionsParser();

    GridPane grid = new GridPane();
    private int gridWidth;
    private int gridHeight;
    private final int cellSize = 50;

    // Start in Terminal with:
    // ./gradlew run --args="f b r l f f r r f f f f f f f f"

    public void init() throws Exception {
        try {
            MoveDirection[] directions = commandParser.parse(getParameters().getRaw());
            //String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            //String[] args = {"f"};
            //MoveDirection[] directions = commandParser.parse(List.of(args));
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        grid.setGridLinesVisible(true);
        grid.setStyle("-fx-background-color: transparent;");
        Map<Vector2d, AbstractWorldMapElement> mapElements = map.getMapElements();
        Vector2d lowerLeftCorner = boundary.getLowerLeftCorner();
        Vector2d upperRightCorner = boundary.getUpperRightCorner();
        int rows = upperRightCorner.y - lowerLeftCorner.y + 2;
        int cols = upperRightCorner.x - lowerLeftCorner.x + 2;

        gridHeight = rows * cellSize;
        gridWidth = cols * cellSize;

        Label label = new Label();

        for (int i = 0; i < cols; i++) {
            ColumnConstraints col = new ColumnConstraints(cellSize);
            col.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(col);
        }

        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(cellSize);
            row.setValignment(VPos.CENTER);
            grid.getRowConstraints().add(row);
        }

        label.setText("y\\x");
        label.setFont(new Font("Helvetica", 20));
        label.setTextFill(Color.BLACK);
        grid.add(label, 0, 0);

        for (int i = 0; i < cols - 1; i++) {
            label = new Label();
            label.setText(Integer.toString(i + lowerLeftCorner.x+1));
            label.setFont(new Font("Helvetica", 20));
            label.setTextFill(Color.BLACK);
            grid.add(label, i + 1, 0);
        }

        for (int i = 0; i < rows - 1; i++) {
            label = new Label();
            label.setText(Integer.toString(i + lowerLeftCorner.y));
            label.setFont(new Font("Helvetica", 20));
            label.setTextFill(Color.BLACK);
            grid.add(label, 0, i + 1);
        }

        addMapElements(mapElements, lowerLeftCorner, upperRightCorner, rows, cols);

        Scene scene = new Scene(grid, gridWidth, gridHeight);
        scene.setFill(new RadialGradient(
                0, 0, 0, 0, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#81c483")),
                new Stop(1, Color.web("#fcc200")))
        );

        primaryStage.getIcons().add(new Image(new FileInputStream("src/main/resources/icon.png"))); // try catch
        primaryStage.setTitle("Animals Simulator");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addMapElements(Map<Vector2d, AbstractWorldMapElement> mapElements,
                                Vector2d lowerLeftCorner, Vector2d upperRightCorner, int rows, int cols) {
        int firstX = lowerLeftCorner.x;
        int firstY = lowerLeftCorner.y;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                Vector2d position = new Vector2d(firstX + j, rows + firstY - 2 - i);

                if (mapElements.containsKey(position)) {
                    AbstractWorldMapElement element = mapElements.get(position);

                    if (element instanceof Grass) {
                        Label label = new Label();
                        label.setText("Grass");
                        label.setFont(new Font("Helvetica", 15));
                        label.setTextFill(Color.GREEN);
                        grid.add(label, j + 1, i + 1);
                    } else if (element instanceof Animal) {
                        Animal animal = (Animal) element;
                        Label label = new Label();
                        label.setText(animal.toString());
                        label.setFont(new Font("Helvetica", 30));
                        label.setTextFill(Color.BLACK);
                        grid.add(label, j + 1, i + 1);
                    }
                }
            }
        }
    }
}
