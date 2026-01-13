package com.lcmuniz.rest_with_spring_boot.services;

import com.lcmuniz.rest_with_spring_boot.config.FileStorageConfig;
import com.lcmuniz.rest_with_spring_boot.exception.FileNotFoundException;
import com.lcmuniz.rest_with_spring_boot.exception.FileStorageException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileService {

    private final Path uploadDir;

    public FileService(FileStorageConfig config) {
        this.uploadDir = Paths.get(config.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(uploadDir);
        } catch (IOException e) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }

    public String storeFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {

            if (filename.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + filename);
            }

            Path targetLocation = uploadDir.resolve(filename);

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (IOException e) {
            throw new FileStorageException("Could not store file " + filename + ". Please try again!", e);
        }
    }

    public Resource loadFileAsResource(String filename) {
        try {
            Path filePath = uploadDir.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileStorageException("Could not read file: " + filename);
            }
        } catch (Exception e) {
            throw new FileNotFoundException("File not found");
        }
    }
}
