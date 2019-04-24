package me.prestonwhitehurst.fileviewer;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class FileViewerView {
    private VBox root;
    private Button backButton;
    private FlowPane filesFlowPane;

    public FileViewerView() {
        root = new VBox();
        backButton = new Button("Go back");
        filesFlowPane = new FlowPane();
        root.getChildren().addAll(backButton, filesFlowPane);
    }

    public VBox getRoot() {
        return root;
    }

    public Button getBackButton() {
        return backButton;
    }

    public FlowPane getFilesFlowPane() {
        return filesFlowPane;
    }
}
