package me.prestonwhitehurst.fileviewer;

import java.io.File;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleStringProperty;

public class FileWrapper {
    private File file;
    private SimpleStringProperty name;
    private SimpleStringProperty size;
    private SimpleStringProperty dateLastModified;

    public FileWrapper(File file) {
        name = new SimpleStringProperty();
        name.set(file.getName());
        size = new SimpleStringProperty();
        if(file.isFile()) {
            size.set(humanReadableByteCount(file.length(), false));
        }
        else {
            size.set("");
        }
        dateLastModified = new SimpleStringProperty();
        dateLastModified.set(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(file.lastModified()));
        this.file = file;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public SimpleStringProperty dateLastModifiedProperty() {
        return dateLastModified;
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public File getFile() {
        return file;
    }
}