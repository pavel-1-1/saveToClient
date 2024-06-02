package ru.pavel.repository;

import org.springframework.stereotype.Component;
import ru.pavel.model.OutFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class OutRepository {
    public static List<OutFile> outFiles = new ArrayList<>();

    public void pathScan(String path) {
        File file = new File(path);
        try {
            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()) {
                    pathScan(file1.getAbsolutePath());
                } else {
                    OutFile outFile = new OutFile(file1.getParent(), file1.getName(), file1.getAbsolutePath());
                    if (!outFiles.contains(outFile)) {
                        outFiles.add(outFile);
                    }
                }
            }
        } catch (NullPointerException e) {
            return;
        }
    }
}
