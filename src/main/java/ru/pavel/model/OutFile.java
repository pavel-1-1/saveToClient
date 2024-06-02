package ru.pavel.model;

import java.util.Objects;

public class OutFile {
    private String pathDir;
    private String fileName;
    private String filePath;

    public OutFile(String pathDir, String fileName, String filePath) {
        this.pathDir = pathDir;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getPathDir() {
        return pathDir;
    }

    public void setPathDir(String pathDir) {
        this.pathDir = pathDir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutFile outFile = (OutFile) o;
        return Objects.equals(pathDir, outFile.pathDir) && Objects.equals(fileName, outFile.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathDir, fileName);
    }

    @Override
    public String toString() {
        return "pathDir='" + pathDir + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'';
    }
}
