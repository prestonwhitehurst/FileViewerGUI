package me.prestonwhitehurst.filemanager;

import java.io.File;
import java.util.ArrayList;

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
        directoryArrayList.remove(getCurrentDirectory());
    }

    public File[] getCurrentDirectoryFiles() {
        return getCurrentDirectory().listFiles();
    }

    public int getSizeOfArray() {
        return directoryArrayList.size();
    }
}