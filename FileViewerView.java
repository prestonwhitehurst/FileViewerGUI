package me.prestonwhitehurst.filemanager;

import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;

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