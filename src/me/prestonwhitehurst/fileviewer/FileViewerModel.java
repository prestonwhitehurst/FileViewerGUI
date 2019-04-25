package me.prestonwhitehurst.fileviewer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;

public class FileViewerModel {
    private final ArrayList<File> directoryArrayList;

    public FileViewerModel() {
        directoryArrayList = new ArrayList<>();

        if(OSValidator.isWindows()) {
            setCurrentDirectory(new File(System.getenv("SystemDrive") + "//"));
        }

        else if(OSValidator.isUnix()) {
            setCurrentDirectory(new File("/"));
        }
    }

    public void setCurrentDirectory(File file) {
        if(file.isDirectory()) {
            if(file.listFiles() != null) {
                directoryArrayList.add(file);
            }
        }
    }

    public File getCurrentDirectory() {
        return directoryArrayList.get(directoryArrayList.size() - 1);
    }

    public void removeCurrentDirectory() {
        if(directoryArrayList.size() != 1) {
            directoryArrayList.remove(getCurrentDirectory());
        }
    }

    public ObservableList<FileWrapper> getCurrentDirectoryFiles() {
        ArrayList<File> f = new ArrayList<>(Arrays.asList(getCurrentDirectory().listFiles()));
        ArrayList<FileWrapper> fw = new ArrayList<>();

        for(File file : f) {
            fw.add(new FileWrapper(file));
        }

        return FXCollections.observableList(fw);
    }
}