package ru.pavel.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class OutController {

    @GetMapping("/out")
    public ResponseEntity<byte[]> getFile(@RequestParam String path) {
        File file = new File(path.replaceAll("%5C", "/"));
        System.out.println(file.getName());
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8) + "\"").body(bytes);
    }
}
