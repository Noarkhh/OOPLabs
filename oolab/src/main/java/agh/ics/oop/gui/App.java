package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

import static java.lang.System.out;

public class App extends Application implements IPositionChangeObserver {

    private AbstractWorldMap mapToDraw;
    private SpriteContainer spriteContainer;
    private final Vector2d windowSize = new Vector2d(1000, 1000);
    private final Vector2d verticalHeaderCellSize = new Vector2d(20, 40);
    private final Vector2d horizontalHeaderCellSize = new Vector2d(40, 20);

    private GridPane grid;
    private Thread engineThread;

    @Override
    public void start(Stage primaryStage) {
        grid = new GridPane();
        updateGrid();

        Scene scene = new Scene(grid, windowSize.x, windowSize.y);
        primaryStage.setScene(scene);
        primaryStage.show();

        engineThread.start();
    }

    public void updateGrid() {
        grid.getChildren().clear();
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.setGridLinesVisible(false);
        drawHeader(grid);
        drawElements(grid);
        grid.setGridLinesVisible(true);
    }

    @Override
    public void init() throws Exception {
        super.init();
        try {
            spriteContainer = new SpriteContainer(List.of(new String[]{"up", "left", "down", "right", "grass"}));
        } catch (NullPointerException ex) {
            out.println(ex.getMessage());
        }
        AbstractWorldMap map = new GrassField(10);
        mapToDraw = map;
        List<MoveDirection> directions = OptionsParser.parse(getParameters().getRaw());
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.addObserver(this);
        engineThread = new Thread(engine);
    }

    private void drawHeader(GridPane grid) {
        Vector2d[] corners = mapToDraw.getDrawingBounds();
        Vector2d lowerLeft = corners[0], upperRight = corners[1];

        Label xy = new Label("x\\y");
        GridPane.setHalignment(xy, HPos.CENTER);
        grid.add(xy, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(verticalHeaderCellSize.x));
        grid.getRowConstraints().add(new RowConstraints(horizontalHeaderCellSize.y));

        for (int index = lowerLeft.x, i = 1; index <= upperRight.x; index++, i++) {
            Label label = new Label(String.format("%2d", index));
            grid.add(label, i, 0);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(horizontalHeaderCellSize.x));
        }

        for (int index = upperRight.y, i = 1; index >= lowerLeft.y; index--, i++) {
            Label label = new Label(String.format("%2d", index));
            grid.add(label, 0, i);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(verticalHeaderCellSize.y));
        }

    }

    private void drawElements(GridPane grid) {
        Vector2d[] corners = mapToDraw.getDrawingBounds();
        Vector2d lowerLeft = corners[0], upperRight = corners[1];

        for (int x = lowerLeft.x, i = 1; x <= upperRight.x; x++, i++) {
            for (int y = upperRight.y, j = 1; y >= lowerLeft.y; y--, j++) {
                drawElementFrom(grid, new Vector2d(x, y), new Vector2d(i, j));
            }
        }
    }

    private void drawElementFrom(GridPane grid, Vector2d elementPosition, Vector2d gridDrawPosition) {
        AbstractMapElement elementToDraw = mapToDraw.elementAt(elementPosition);
        if (elementToDraw == null) return;

        GuiElementBox guiElementBox = new GuiElementBox(elementToDraw, spriteContainer);

        grid.add(guiElementBox.getBox(), gridDrawPosition.x, gridDrawPosition.y);
        GridPane.setHalignment(guiElementBox.getBox(), HPos.CENTER);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(this::updateGrid);
    }
}
