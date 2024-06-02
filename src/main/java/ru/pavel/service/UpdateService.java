package ru.pavel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.pavel.model.OutFile;
import ru.pavel.repository.OutRepository;

import java.util.List;

@Service
public class UpdateService {
    @Autowired
    private OutRepository outRepository;
    @Value("${dir.path}")
    private String path;

    public List<OutFile> update() {
        outRepository.pathScan(path);
        return OutRepository.outFiles;
    }
}
