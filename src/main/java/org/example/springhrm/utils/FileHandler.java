package org.example.springhrm.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Component
public class FileHandler {
    private final String imagesDirectory;
    public FileHandler(@Value("${resources.images.directory}") String imagesDirectory) {
        this.imagesDirectory = imagesDirectory;
    }
   public  String saveUploadedFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }

        try {
            byte[] bytes = file.getBytes();
            String fileName = UUID.randomUUID() +file.getOriginalFilename();
            String urlPath = imagesDirectory +fileName;
            Path path = Paths.get(urlPath);
            Files.write(path, bytes);
            return fileName;
        } catch (IOException e) {
            throw new  IOException("Save file Error: " + e.getMessage());
        }
    }

    public String updateUploadedFile(MultipartFile image, String productImage) {
        try {
            Path path = Paths.get(imagesDirectory + productImage);
        Files.deleteIfExists(path);
        return saveUploadedFile(image);
        }catch (IOException e) {
            try {
                throw new  IOException("Update file Error: " + e.getMessage());
            } catch (IOException ex) {
                throw new RuntimeException("Update file Error: " + e.getMessage());
            }
        }
    }
}
