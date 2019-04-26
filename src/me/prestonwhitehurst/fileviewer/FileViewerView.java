package me.prestonwhitehurst.fileviewer;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class FileViewerView {
    private VBox root;
    private Button backButton;
    private TableView<FileWrapper> filesTable;

    public FileViewerView() {
        root = new VBox();
        backButton = new Button("Go back");
        filesTable = new TableView<>();
        root.getChildren().addAll(backButton, filesTable);
    }

    public VBox getRoot() {
        return root;
    }

    public Button getBackButton() {
        return backButton;
    }

    public TableView<FileWrapper> getFilesTable() {
        return filesTable;
    }
}
