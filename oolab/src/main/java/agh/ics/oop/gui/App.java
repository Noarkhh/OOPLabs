package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

import static java.lang.System.out;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Zwierzak");
        Label l1 = new Label("*");
        Label l2 = new Label("*");
        Label l3 = new Label("*");

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.add(l1, 0, 0);
        gridPane.add(l2, 1, 0);
        gridPane.add(l3, 2, 0);


        Scene scene = new Scene(gridPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        IWorldMap map = new GrassField(10);
        List<MoveDirection> directions = OptionsParser.parse(getParameters().getRaw());
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        out.println(map);
        engine.run();
        out.println(map);
    }
}
