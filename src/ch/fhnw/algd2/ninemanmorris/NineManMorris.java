package ch.fhnw.algd2.ninemanmorris;

import ch.fhnw.algd2.ninemanmorris.gui.Controller;
import ch.fhnw.algd2.ninemanmorris.gui.GUI;
import ch.fhnw.algd2.ninemanmorris.gui.PModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Claudio on 09.01.2017.
 */
public class NineManMorris extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        PModel model = new PModel();
        GUI ui = new GUI();
        Controller controller = new Controller(ui, model);
        Scene scene = new Scene(ui, 800, 600);

//        scene.getStylesheets().add("/" + model.cssFileName);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Nine man morris");
//        primaryStage.getIcons().add(new Image(CantonPM.imagesFolder + "ch.png"));
        primaryStage.show();
    }
}
