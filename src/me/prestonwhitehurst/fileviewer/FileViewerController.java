package me.prestonwhitehurst.fileviewer;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import java.io.File;
import javafx.scene.control.Alert;
import java.awt.Desktop;
import java.io.IOException;

public class FileViewerController {
    private final FileViewerModel model;
    private final FileViewerView view;
    private ObservableList<FileWrapper> data;

    public FileViewerController(FileViewerModel model, FileViewerView view) {
        this.model = model;
        this.view = view;
        initialiseTableViewControls(view.getFilesTable());
        initialiseBackButtonControl(view.getBackButton(), view.getFilesTable());
    }

    public VBox getView() {
        return view.getRoot();
    }

    public void updateCurrentDirectory(File file) {
        model.setCurrentDirectory(file);
    }

    public void removeCurrentDirectory() {
        model.removeCurrentDirectory();
    }

    public ObservableList<FileWrapper> getFiles() {
        return model.getCurrentDirectoryFiles();
    }

    public void initialiseTableViewControls(TableView<FileWrapper> filesTable) {
        TableColumn nameCol = new TableColumn("Name");
        TableColumn sizeCol = new TableColumn("Size");
        TableColumn dateLastModifiedCol = new TableColumn("Last Modified");
        nameCol.setMinWidth(250);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        sizeCol.setMinWidth(125);
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        dateLastModifiedCol.setMinWidth(200);
        dateLastModifiedCol.setCellValueFactory(new PropertyValueFactory<>("dateLastModified"));
        data = getFiles();
        filesTable.setItems(data);
        filesTable.setRowFactory(tableView -> {
            TableRow<FileWrapper> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if(e.getClickCount() == 2 && (!row.isEmpty())) {

                    if(row.getItem().getFile().isDirectory()) {
                        updateCurrentDirectory(row.getItem().getFile());
                        data = getFiles();
                        filesTable.setItems(data);
                    }

                    else if(row.getItem().getFile().isFile()) {

                        try {
                            Desktop.getDesktop().open(row.getItem().getFile());
                        }catch(IOException exc) {
                            Alert dialog = new Alert(Alert.AlertType.ERROR);
                            dialog.setHeaderText("File Could Not Be Opened");
                            dialog.setContentText(exc.getMessage());
                            dialog.setResizable(true);
                            dialog.getDialogPane().setPrefSize(480, 320);
                            dialog.showAndWait();
                        }
                    }
                }
            });
            return row;
        });
        filesTable.getColumns().addAll(nameCol, sizeCol, dateLastModifiedCol);
    }

    public void initialiseBackButtonControl(Button backButton, TableView<FileWrapper> filesTable) {
        backButton.setOnAction(e -> {
            removeCurrentDirectory();
            data = getFiles();
            filesTable.setItems(data);
        });
    }
}
