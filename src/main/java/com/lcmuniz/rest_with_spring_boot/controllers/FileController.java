package com.lcmuniz.rest_with_spring_boot.controllers;

import com.lcmuniz.rest_with_spring_boot.dto.UploadFileResponseDTO;
import com.lcmuniz.rest_with_spring_boot.exception.FileNotFoundException;
import com.lcmuniz.rest_with_spring_boot.services.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public UploadFileResponseDTO uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileService.storeFile(file);
        String fileUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName).toUriString();
        return new UploadFileResponseDTO(fileName,file.getContentType(),file.getSize(),fileUrl);
    }

    @PostMapping("/uploads")
    public Collection<UploadFileResponseDTO> uploadFiles(@RequestParam("files") MultipartFile files) {
        return Stream.of(files).map(this::uploadFile).toList();
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> uploadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileService.loadFileAsResource(fileName);
        String contenType = "application/octet-stream";
        try {
            contenType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            throw new FileNotFoundException("File not found");
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contenType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
