package com.lcmuniz.rest_with_spring_boot.dto;

import java.util.Objects;

public class UploadFileResponseDTO {

    private String fileName;
    private String fileType;
    private Long fileSize;
    private String fileUrl;

    public UploadFileResponseDTO() {
    }

    public UploadFileResponseDTO(String fileName, String fileType, Long fileSize, String fileUrl) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        UploadFileResponseDTO that = (UploadFileResponseDTO) o;
        return Objects.equals(fileName, that.fileName) && Objects.equals(fileType, that.fileType) && Objects.equals(fileSize, that.fileSize) && Objects.equals(fileUrl, that.fileUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileType, fileSize, fileUrl);
    }
}
