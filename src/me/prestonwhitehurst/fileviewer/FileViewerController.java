package me.prestonwhitehurst.fileviewer;

import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import java.io.File;

public class FileViewerController {
    private final FileViewerModel model;
    private final FileViewerView view;

    public FileViewerController(FileViewerModel model, FileViewerView view) {
        this.model = model;
        this.view = view;
        setOnActionBackButton(view.getBackButton());
        updateFilesFlowPane(view.getFilesFlowPane());
    }

    public void updateCurrentDirectory(File file) {
        if(model.getCurrentDirectory().listFiles() != null) {
            model.setCurrentDirectory(file);
        }
    }

    public void removeCurrentDirectory() {
        if(model.getSizeOfArray() != 1) {
            model.removeCurrentDirectory();
        }
    }

    public File[] getFiles() {
        return model.getCurrentDirectoryFiles();
    }

    public void setOnActionBackButton(Button backButton) {
        backButton.setOnAction(e -> {
            removeCurrentDirectory();
            updateFilesFlowPane(view.getFilesFlowPane());
        });
    }

    public void updateFilesFlowPane(FlowPane filesFlowPane) {
        if(filesFlowPane.getChildren() != null) {
            filesFlowPane.getChildren().clear();
            File[] f = getFiles();
            for(final File file : f) {
                Button fileButton = new Button(file.getName());
                fileButton.setOnMouseClicked(e -> {
                    if(e.getClickCount() == 2) {
                        updateCurrentDirectory(file.getAbsoluteFile());
                        updateFilesFlowPane(filesFlowPane);
                    }
                });
                filesFlowPane.getChildren().add(fileButton);
            }
        }
        else {
            File[] f = getFiles();
            for(final File file : f) {
                Button fileButton = new Button(file.getName());
                fileButton.setOnMouseClicked(e -> {
                    if(e.getClickCount() == 2) {
                        updateCurrentDirectory(file.getAbsoluteFile());
                        updateFilesFlowPane(filesFlowPane);
                    }
                });
                filesFlowPane.getChildren().add(fileButton);
            }
        }
    }
}
