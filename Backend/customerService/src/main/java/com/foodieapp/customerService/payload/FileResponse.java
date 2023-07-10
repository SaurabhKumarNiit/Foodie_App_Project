package com.foodieapp.customerService.payload;

public class FileResponse {
    String fileName;
    String message;

    public FileResponse(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }

    public FileResponse() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "fileName='" + fileName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
