package sample;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group base = new Group();

        Scene scene = new Scene(base, 500, 450);
        scene.setFill(Color.web("#0080FF"));

        Rectangle rectangle = new Rectangle(80, 25, 200, 200);
        rectangle.setFill(Color.WHITE);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(200.0, 90.0, 200.0, 250.0, 420.0, 230.0);
        triangle.setFill(Color.web("#C0C0C0"));
        triangle.setStroke(Color.web("#C0C0C0"));

        Polygon square = new Polygon();
        square.getPoints().addAll(35.0, 110.0, 180.0, 120.0, 110.0, 260.0, 17.0, 220.0);
        square.setFill(Color.web("#00FF80"));
        square.setStroke(Color.web("#00FF80"));

        Line topLine = new Line(55, 12, 290, 12);
        Line leftLine = new Line(55, 12, 55, 35);
        Line rightLine = new Line(290, 12, 290, 35);

        //color
        topLine.setStroke(Color.YELLOW);
        leftLine.setStroke(Color.YELLOW);
        rightLine.setStroke(Color.YELLOW);

        //width
        topLine.setStrokeWidth(7);
        leftLine.setStrokeWidth(7);
        rightLine.setStrokeWidth(7);

        //strokeCap
        topLine.setStrokeLineCap(StrokeLineCap.ROUND);
        leftLine.setStrokeLineCap(StrokeLineCap.ROUND);
        rightLine.setStrokeLineCap(StrokeLineCap.ROUND);

        base.getChildren().add(rectangle);
        base.getChildren().add(topLine);
        base.getChildren().add(leftLine);
        base.getChildren().add(rightLine);
        base.getChildren().add(triangle);
        base.getChildren().add(square);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
