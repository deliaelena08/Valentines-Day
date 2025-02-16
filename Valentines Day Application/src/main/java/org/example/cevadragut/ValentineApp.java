package org.example.cevadragut;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

public class ValentineApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text message = new Text("Will you be my Valentine?");
        message.setFont(new Font(30));
        message.setFill(Color.DEEPPINK);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        styleButton(yesButton, Color.LIGHTPINK);
        styleButton(noButton, Color.LIGHTGRAY);

        Random random = new Random();
        noButton.setOnMouseEntered(e -> {
            noButton.setTranslateX(random.nextInt(400) - 200);
            noButton.setTranslateY(random.nextInt(400) - 200);
        });

        yesButton.setOnAction(e -> showAnimation(primaryStage));

        VBox vbox = new VBox(20, message, yesButton, noButton);
        vbox.setStyle("-fx-alignment: center; -fx-padding: 20px;");
        vbox.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, CornerRadii.EMPTY, null)));

        StackPane root = new StackPane(vbox);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Valentine Surprise");
        primaryStage.show();
    }

    private void showAnimation(Stage stage) {
        Text loveText = new Text("Yay! Happy Valentine's Day!");
        loveText.setFont(new Font(32));
        loveText.setFill(Color.RED);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), loveText);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        StackPane lovePane = new StackPane(loveText);
        lovePane.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, null)));
        Scene loveScene = new Scene(lovePane, 500, 400);
        stage.setScene(loveScene);
    }

    private void styleButton(Button button, Color color) {
        button.setStyle("-fx-background-color: " + toRgbString(color) + "; -fx-font-size: 16px; -fx-font-weight: bold;");
    }

    private String toRgbString(Color color) {
        return "rgb(" + (int)(color.getRed()*255) + "," + (int)(color.getGreen()*255) + "," + (int)(color.getBlue()*255) + ")";
    }

    public static void main(String[] args) {
        launch(args);
    }
}
