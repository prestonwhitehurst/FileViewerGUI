package me.prestonwhitehurst.fileviewer;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class FileViewer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("File Manager");
        FileViewerModel model = new FileViewerModel();
        FileViewerView view = new FileViewerView();
        FileViewerController controller = new FileViewerController(model, view);
        primaryStage.setScene(new Scene(view.getRoot(), 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
