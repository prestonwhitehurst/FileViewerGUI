package me.prestonwhitehurst.fileviewer;

import java.util.ArrayList;
import java.io.File;

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

    public File[] getCurrentDirectoryFiles() {
        return getCurrentDirectory().listFiles();
    }
}
